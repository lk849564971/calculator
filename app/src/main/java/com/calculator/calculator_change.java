package com.calculator;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class calculator_change extends AppCompatActivity implements View.OnClickListener{
    private Spinner sp1,sp2;
    private TextView t1,t2;
    private ArrayAdapter<CharSequence> adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.calculator,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.help_item:
                Toast.makeText(this,"进制转换只能横屏使用", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit_item:
                finish();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        Button btn_0 = findViewById(R.id.btn_0),
                btn_1 = findViewById(R.id.btn_1),
                btn_2 = findViewById(R.id.btn_2),
                btn_3 = findViewById(R.id.btn_3),
                btn_4 = findViewById(R.id.btn_4),
                btn_5 = findViewById(R.id.btn_5),
                btn_6 = findViewById(R.id.btn_6),
                btn_7 = findViewById(R.id.btn_7),
                btn_8 = findViewById(R.id.btn_8),
                btn_9 = findViewById(R.id.btn_9),
                btn_emp = findViewById(R.id.btn_c),
                btn_back = findViewById(R.id.btn_back),
                btn_bs = findViewById(R.id.btn_backspace),
                btn_arc = findViewById(R.id.btn_arc),
                btn_poi = findViewById(R.id.btn_dian);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_emp.setOnClickListener(this);
        btn_poi.setOnClickListener(this);
        btn_bs.setOnClickListener(this);
        btn_arc.setOnClickListener(this);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        sp1 = (Spinner)findViewById(R.id.spinnerleft);
        sp2 = (Spinner)findViewById(R.id.spinnerright);
        t1 = (TextView)findViewById(R.id.text_1);
        t2 = (TextView)findViewById(R.id.text_2);
        adapter = ArrayAdapter.createFromResource(calculator_change.this, R.array.system,
                android.R.layout.simple_spinner_item);
        sp1.setAdapter(adapter);
        adapter = ArrayAdapter.createFromResource(calculator_change.this, R.array.system2,
                android.R.layout.simple_spinner_item);
        sp2.setAdapter(adapter);
        sp1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                int v1 = Integer.parseInt((String)sp1.getSelectedItem());
                int v2 = Integer.parseInt((String)sp2.getSelectedItem());
                String s1 = t1.getText() + "";
                String s2 = "";
                int n = s1.length();
                if(n>0) {
                    char[] ch = s1.toCharArray();
                    for(int i = 0;i < n;i++)
                        if(ch[i]>v1+47){
                            t1.setText("");
                            s1 = "";
                            break;
                        }
                }
                try {
                    if (s1.length() != 0)
                        s2 = calculate(s1,v1,v2);
                }
                catch (Exception e){
                    s2 = "数据过大或输入有误";
                }
                t2.setText(s2);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        sp2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                int v1 = Integer.parseInt((String)sp1.getSelectedItem());
                int v2 = Integer.parseInt((String)sp2.getSelectedItem());
                String s1 = t1.getText() + "";
                String s2 = "";
                try {
                    if (s1.length() != 0)
                        s2 = calculate(s1,v1,v2);
                }
                catch (Exception e){
                    s2 = "数据过大或输入有误";
                }
                t2.setText(s2);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        int v1 = Integer.parseInt((String)sp1.getSelectedItem());
        int v2 = Integer.parseInt((String)sp2.getSelectedItem());
        String s1 = t1.getText() + "";
        String s2 = "";
        String c1 = " ";
        String c2 = " ";
        char[] ch = null;
        int n = s1.length();
        if(n>0) {
            c1 = s1.substring(n - 1);
            ch = s1.toCharArray();
        }
        if(n>1)
            c2 = s1.substring(n - 2,n - 1);
        switch(v.getId()) {
            case R.id.btn_0:
                if(c1.compareTo("0")!=0||c2.compareTo(" ")!=0)
                    s1 = s1 + "0";
                break;
            case R.id.btn_1:
                if(c1.compareTo("0")==0 && n==1)
                    s1 = ((Button)v).getText()+ "";
                else
                    s1 = s1 + "1";
                break;
            case R.id.btn_2:
                if(v1 < 3)
                    break;
                if(c1.compareTo("0")==0 && n==1)
                    s1 = "2";
                else
                    s1 = s1 + "2";
                break;
            case R.id.btn_3:
                if(v1 < 4)
                    break;
                else if(c1.compareTo("0")==0 && n==1)
                    s1 = "3";
                else
                    s1 = s1 + "3";
                break;
            case R.id.btn_4:
                if(v1 < 5)
                    break;
                if(c1.compareTo("0")==0 && n==1)
                    s1 = "4";
                else
                    s1 = s1 + "4";
                break;
            case R.id.btn_5:
                if(v1 < 6)
                    break;
                if(c1.compareTo("0")==0 && n==1)
                    s1 = "5";
                else
                    s1 = s1 + "5";
                break;
            case R.id.btn_6:
                if(v1 < 7)
                    break;
                if(c1.compareTo("0")==0 && n==1)
                    s1 = "6";
                else
                    s1 = s1 + "6";
                break;
            case R.id.btn_7:
                if(v1 < 8)
                    break;
                if(c1.compareTo("0")==0 && n==1)
                    s1 = "7";
                else
                    s1 = s1 + "7";
                break;
            case R.id.btn_8:
                if(v1 < 9)
                    break;
                if(c1.compareTo("0")==0 && n==1)
                    s1 = "8";
                else
                    s1 = s1 + "8";
                break;
            case R.id.btn_9:
                if(v1 < 10)
                    break;
                if(c1.compareTo("0")==0 && n==1)
                    s1 = "9";
                else
                    s1 = s1 + "9";
                break;
            case R.id.btn_c:
                s1 = "";
                break;
            case R.id.btn_arc:
                if(n==0)
                    s1 = "-";
                else if(s1.substring(0,1).compareTo("-")==0)
                    s1 = s1.substring(1);
                else
                    s1 = "-" + s1;
                break;
            case R.id.btn_dian:
                if(n ==0)
                    s1 = s1 + "0.";
                for(int i =n-1;i>-1;i--)
                    if(ch[i]=='.')
                        break;
                    else if(i==0)
                        s1 = s1 + ".";
                break;
            case R.id.btn_backspace:
                if( n<=1 )
                    s1 = "";
                else
                    s1 = s1.substring(0,n-1);
                break;
            default:
                break;
        }
        t1.setText(s1);
        try {
            if (s1.length() != 0)
                s2 = calculate(s1,v1,v2);
        }
        catch (Exception e){
            s2 = "数据过大或输入有误";
        }
        t2.setText(s2);
    }

    private String calculate(String str , int v1,int v2){
        if(v1 == v2)
            return str;
        else if(v1 == 10)
            return arc_change(str,v2);
        else if(v2 == 10)
            return change(str,v1);
        else {
            str = change(str,v1);
            return arc_change(str,v2);
        }
    }

    //从指定进制变成十进制
    private String change(String str,int mod){
        String sign = "",
                left = "",
                right = "";
        if(str.substring(0,1).compareTo("-")==0){
            sign = "-";
            str = str.substring(1);
        }
        char[] ch = str.toCharArray();
        int x = ch.length;
        for(int i = 0 ;i<ch.length;i++){
            if(ch[i]=='.') {
                x = i;
                break;
            }
        }
        left = str.substring(0,x);
        if(left.compareTo("0")==0)
            left = "0";
        else
            left = Integer.valueOf(left,mod).toString();
        if(x < ch.length-1){
            right = str.substring(x+1);
            if(right.compareTo("0")==0)
                right = ".0";
            else
                right = point(right,mod).substring(1);
        }
        return sign + left + right;
    }

    //从指定进制变成十进制,小数部分
    private  String point(String str,int mod){
        int value = 0;
        char[] ch = str.toCharArray();
        double sb = 0;
        for(int i  = 0;i<ch.length;i++){
            value = (int)ch[i]-48;
            sb = sb + value / Math.pow(mod,i+1);
        }
        return sb+"";
    }

    //从十进制变成指定进制
    private String arc_change(String str,int mod){
        String sign = "",
                left = "",
                right = "",
                point = "";
        if(str.substring(0,1).compareTo("-")==0){
            sign = "-";
            str = str.substring(1);
        }
        char[] ch = str.toCharArray();
        int x = ch.length;
        for(int i = 0 ;i<ch.length;i++){
            if(ch[i]=='.') {
                x = i;
                break;
            }
        }
        left = str.substring(0,x);
        if(left.compareTo("0")==0)
            left = "0";
        else
            left = Integer.toString(Integer.parseInt(left), mod);
        if(x < ch.length-1){
            point = ".";
            right = str.substring(x+1);
            if(right.compareTo("0")==0)
                right = "0";
            else
                right = arc_point(right,mod);
        }
        if(right.compareTo("错误")==0)
            return "数据过大或者终值无限循环";
        else
            return sign + left + point + right;
    }

    //从十进制变成指定进制,小数部分
    private  String arc_point(String str,int mod){
        int count = 15;
        int one = 0;
        str = "0." + str;
        double value = Double.parseDouble(str);
        StringBuffer sb = new StringBuffer();
        do{
            if(count==-1)
                return "错误";
            value = value * mod;
            one = (int)value;
            switch (one){
                case 10:
                    sb.append("a");
                    break;
                case 11:
                    sb.append("b");
                    break;
                case 12:
                    sb.append("c");
                    break;
                case 13:
                    sb.append("d");
                    break;
                case 14:
                    sb.append("e");
                    break;
                case 15:
                    sb.append("f");
                    break;
                default:
                    sb.append(one);
                    break;
            }
            value = value - one;
            count--;
        }while(value!=0);
        return new String(sb);
    }
}
