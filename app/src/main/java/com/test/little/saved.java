package com.test.little;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.R;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class saved extends AppCompatActivity {

    private EditText t;
    private String s = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        t = (EditText)findViewById(R.id.text_1);
        try{
            String s2 = load("back");
            if(!TextUtils.isEmpty(s2)) {
                t.setText(s2);
                t.setSelection(s2.length());
                Toast.makeText(saved.this, "已读取上次未保存的数据", Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e3) {
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = t.getText().toString();
                if(!TextUtils.isEmpty(s)) {
                    save("data", s);
                    Toast.makeText(saved.this,"写入成功",Toast.LENGTH_SHORT).show();
                }
                else {
                    AlertDialog.Builder Builder = new AlertDialog.Builder(
                            saved.this);
                    Builder.setTitle("提示")
                            .setMessage("是否使用默认数据？")
                            .setCancelable(false)
                            .setPositiveButton("确定",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            save("data",s);
                                            Toast.makeText(saved.this,"写入成功",Toast.LENGTH_SHORT).show();
                                        }
                                    })
                            .setNegativeButton("取消",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    Builder.show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s3 = load("data");
                if(!TextUtils.isEmpty(s3)){
                    t.setText(s3);
                    t.setSelection(s3.length());
                    Toast.makeText(saved.this,"读取成功",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save("data","");
                Toast.makeText(saved.this,"操作成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        s = t.getText().toString();
        save("back",s);
    }

    private  void save(String filename,String input){
        FileOutputStream out = null;
        BufferedWriter wr = null;
        try{
            out = openFileOutput(filename, Context.MODE_PRIVATE);
            wr = new BufferedWriter(new OutputStreamWriter(out));
            wr.write(input);
        }
        catch(Exception e){
            Toast.makeText(saved.this,"写入失败",Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                if (wr != null)
                    wr.close();
            } catch (Exception e2) {
                Toast.makeText(saved.this, "操作失败", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private  String load(String filename){
        FileInputStream in;
        BufferedReader r = null;
        StringBuilder str = new StringBuilder();
        try{
            in = openFileInput(filename);
            r = new BufferedReader(new InputStreamReader(in));
            String line;
            while((line = r.readLine()) != null)
                str.append(line);
        }
        catch(Exception e){
            if(filename.compareTo("back")!=0)
                Toast.makeText(saved.this,"读取失败",Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                if (r != null)
                    r.close();
            } catch (Exception e2) {
                if(filename.compareTo("back")!=0)
                    Toast.makeText(saved.this, "操作失败", Toast.LENGTH_SHORT).show();
            }
        }
        return str.toString();
    }
}
