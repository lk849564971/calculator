package com.test.little;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class toast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast_main);
        final Button btn1 = findViewById(R.id.btn1);
        final Button btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v1){
                LayoutInflater li = LayoutInflater.from(context);
                View view = li.inflate(R.layout.toast_ex, null);
                AlertDialog.Builder Builder = new AlertDialog.Builder(
                        context);
                Builder.setView(view);
                final EditText t1 = (EditText) view.findViewById(R.id.userno);
                final EditText t2 = (EditText) view.findViewById(R.id.password);
                Builder
                        .setCancelable(false)
                        .setPositiveButton("登录",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        final String s1 = t1.getText()+"";
                                        final String s2 = t2.getText()+"";
                                        Toast to = null;
                                        if(s1.compareTo("abc")==0&&s2.compareTo("123")==0)
                                            to = Toast.makeText(toast.this,"成功",Toast.LENGTH_SHORT);
                                        else
                                            to = Toast.makeText(toast.this,"错误",Toast.LENGTH_SHORT);
                                        to.setGravity(Gravity.CENTER, 0, 0);
                                        to.show();
                                    }
                                })
                        .setNegativeButton("取消",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog ex = Builder.create();
                ex.show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v2) {
                Toast to =Toast.makeText(toast.this,"请点击-登录-按钮进行登录",Toast.LENGTH_SHORT);
                to.setGravity(Gravity.CENTER, 0, 0);
                to.show();
            }
        });
    }
}
