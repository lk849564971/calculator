package com.test.little;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class handle_change extends AppCompatActivity {
    public static final int UPDATE_TEXT = 1;
    private TextView t;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            if(msg.what == UPDATE_TEXT) {
                int a = (int) (1 + Math.random() * 50);
                t = findViewById(R.id.text_1);
                switch (a) {
                    case 1:case 2:case 3:case 4:case 5:case 6:case 7: case 8:case 9:
                        if(t.getText().toString().compareTo("别按按钮改变文本！")==0)
                            t.setText("都说了别按，不信！");
                        else
                            t.setText("别按按钮改变文本！");
                        break;
                    case 10:
                        if(t.getText().toString().compareTo("不错，居然能看到这条欧皇检测提示")==0)
                            t.setText("可以啊，挺欧的！");
                        else if(t.getText().toString().compareTo("欧皇啊！")==0)
                            t.setText("能看到这条你真的是究极欧皇！");
                        else
                            t.setText("没想到吧！");
                        break;
                    default:
                        if(t.getText().toString().compareTo("快点把我变回去！")==0)
                            t.setText("怎么肥四小老弟？");
                        else
                            t.setText("快点把我变回去！");
                        break;
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);
        Button btn1 = findViewById(R.id.btn_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable(){
                    public void run(){
                        Message m = new Message();
                        m.what = UPDATE_TEXT;
                        handler.sendMessage(m);
                    }
                }).start();
            }
        });
    }
}
