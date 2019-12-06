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

public class Intent_2 extends AppCompatActivity {
    String str;

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        EditText t = (EditText) findViewById(R.id.text1);
        str = "2"+ t.getText() ;
        intent.putExtra("data_return",str);
        setResult(RESULT_OK,intent);
        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 2:
                if(resultCode == RESULT_OK){
                    String s = data.getStringExtra("data_return");
                    if (s.compareTo("1") == 0)
                        Toast.makeText(this, "您未在上个界面输入任何数据", Toast.LENGTH_SHORT).show();
                    else if (s.substring(0, 1).compareTo("1") == 0)
                        Toast.makeText(this, "您于上个界面输入了"+s.substring(1), Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_2);
        Button btn1 = findViewById(R.id.btn_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t = (EditText) findViewById(R.id.text1);
                str = "2"+ t.getText() ;
                Intent in = new Intent(Intent_2.this,Intent_1.class);
                in.putExtra("extra_data",str);
                startActivityForResult(in,2);
            }
        });
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        if (data.compareTo("0") == 0 || data.compareTo("1") == 0)
            Toast.makeText(this, "您未在上个界面输入任何数据", Toast.LENGTH_SHORT).show();
        else if (data.substring(0, 1).compareTo("0") == 0)
            Toast.makeText(this, "您于主页输入了"+data.substring(1), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "您于第一页输入了"+data.substring(1), Toast.LENGTH_SHORT).show();
    }
}
