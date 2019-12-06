package com.test.little;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

public class Intent_0 extends AppCompatActivity {
    String str;
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent();
            EditText t = (EditText) findViewById(R.id.text1);
            str = "0" + t.getText();
            intent.putExtra("data_return", str);
            setResult(RESULT_OK, intent);
            finish();
        }
        catch (Exception exp){
            finish();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 0:
                if(resultCode == RESULT_OK){
                    String s = data.getStringExtra("data_return");
                    if (s.compareTo("1") == 0 || s.compareTo("2") == 0)
                        Toast.makeText(this, "您未在上个界面输入任何数据", Toast.LENGTH_SHORT).show();
                    else if (s.substring(0, 1).compareTo("1") == 0)
                        Toast.makeText(this, "您于第一页输入了"+s.substring(1), Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(this, "您于第二页输入了"+s.substring(1), Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_0);
        Button btn1 = findViewById(R.id.btn_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t = (EditText) findViewById(R.id.text1);
                str = "0"+ t.getText() ;
                Intent in = new Intent(Intent_0.this,Intent_1.class);
                in.putExtra("extra_data",str);
                startActivityForResult(in,0);
            }
        });
        Button btn2 = findViewById(R.id.btn_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t = (EditText) findViewById(R.id.text1);
                str = "0"+ t.getText() ;
                Intent in = new Intent(Intent_0.this,Intent_2.class);
                in.putExtra("extra_data",str);
                startActivityForResult(in,0);
            }
        });
    }
}
