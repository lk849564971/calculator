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

import java.nio.DoubleBuffer;
import java.text.DecimalFormat;

public class calculator_other extends AppCompatActivity implements View.OnClickListener{
    private Spinner sp1,sp2,sp3;
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
                Toast.makeText(this,"单位换算只能横屏使用", Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_other);
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
                btn_poi = findViewById(R.id.btn_point);
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
        adapter = ArrayAdapter.createFromResource(calculator_other.this, R.array.unit,
                android.R.layout.simple_spinner_item);
        sp1 = (Spinner) findViewById(R.id.spinner);
        sp2 = (Spinner) findViewById(R.id.spinnerleft);
        sp3 = (Spinner) findViewById(R.id.spinnerright);
        t1 = (TextView) findViewById(R.id.text_1);
        t2 = (TextView) findViewById(R.id.text_2);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                String s = (String) sp1.getSelectedItem();
                switch (s) {
                    case "长度":
                        adapter = ArrayAdapter.createFromResource(calculator_other.this, R.array.length,
                                android.R.layout.simple_spinner_item);
                        break;
                    case "面积":
                        adapter = ArrayAdapter.createFromResource(calculator_other.this, R.array.area,
                                android.R.layout.simple_spinner_item);
                        break;
                    case "体积":
                        adapter = ArrayAdapter.createFromResource(calculator_other.this, R.array.volume,
                                android.R.layout.simple_spinner_item);
                        break;
                    case "质量":
                        adapter = ArrayAdapter.createFromResource(calculator_other.this, R.array.mass,
                                android.R.layout.simple_spinner_item);
                        break;
                    case "时间":
                        adapter = ArrayAdapter.createFromResource(calculator_other.this, R.array.time,
                                android.R.layout.simple_spinner_item);
                        break;
                    case "数据存储":
                        adapter = ArrayAdapter.createFromResource(calculator_other.this, R.array.data,
                                android.R.layout.simple_spinner_item);
                        break;
                    default:
                        break;
                }
                sp2.setAdapter(adapter);
                sp3.setAdapter(adapter);
                t1.setText("");
                t2.setText("");
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        sp2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                String v1 = (String)sp2.getSelectedItem();
                String v2 = (String)sp3.getSelectedItem();
                String s1 = t1.getText() + "";
                String s2 = "";
                try {
                    if (s1.length() != 0) {
                        s2 = calculate(s1, v1, v2);
                        int n = s2.length();
                        if (s2.substring(n - 2).compareTo(".0") == 0)
                            s2 = s2.substring(0, n - 2);
                    }
                }
                catch (Exception e){
                    s2 = "数据过大或输入有误";
                }
                t2.setText(s2);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        sp3.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                String v1 = (String)sp2.getSelectedItem();
                String v2 = (String)sp3.getSelectedItem();
                String s1 = t1.getText() + "";
                String s2 = "";
                try {
                    if (s1.length() != 0) {
                        s2 = calculate(s1, v1, v2);
                        int n = s2.length();
                        if (s2.substring(n - 2).compareTo(".0") == 0)
                            s2 = s2.substring(0, n - 2);
                    }
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
        String v1 = (String)sp2.getSelectedItem();
        String v2 = (String)sp3.getSelectedItem();
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
            case R.id.btn_1: case R.id.btn_2: case R.id.btn_3:
            case R.id.btn_4: case R.id.btn_5: case R.id.btn_6:
            case R.id.btn_7: case R.id.btn_8: case R.id.btn_9:
                if(c1.compareTo("0")==0 && n==1)
                    s1 = ((Button)v).getText().toString();
                else
                    s1 = s1 + ((Button)v).getText();
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
            case R.id.btn_point:
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
            if (s1.length() != 0) {
                s2 = calculate(s1, v1, v2);
                n = s2.length();
                if(n>1) {
                    if (s2.substring(n - 2).compareTo(".0") == 0)
                        s2 = s2.substring(0, n - 2);
                }
            }
        }
        catch (Exception e){
            s2 = "数据过大或输入有误";
        }
        t2.setText(s2);
    }
    private String calculate(String str,String v1,String v2){
        if(v1.compareTo(v2)==0)
            return str;
        else if(v1.compareTo("米(m)")==0||v1.compareTo("平方米(m²)")==0||v1.compareTo("立方米(m³)")==0
        ||v1.compareTo("千克(kg)")==0||v1.compareTo("日(day)")==0||v1.compareTo("千字节(kb)")==0)
            return change(str,v2,true);
        else if(v2.compareTo("米(m)")==0||v2.compareTo("平方米(m²)")==0||v2.compareTo("立方米(m³)")==0
                ||v2.compareTo("千克(kg)")==0||v2.compareTo("日(day)")==0||v2.compareTo("千字节(kb)")==0)
            return change(str,v1,false);
        else
            str = change(str,v1,false);
        return change(str,v2,true);
    }
    //取 m,m²,m³,kg,day,kb作为中间单位
    //在中间单位与其他单位互换，arc为true前者变后者，false为后者变前者
    private String change(String str,String mod,boolean arc){
        String sign = "";
        double value;
        if(str.substring(0,1).compareTo("-")==0){
            sign = "-";
            str = str.substring(1);
        }
        if(str.compareTo("0")==0)
            value = 0;
        else {
            value = Double.parseDouble(str);
            switch (mod) {
                case "千米(km)":case "吨(t)":
                    if(arc)
                        value = value / 1000;
                    else
                        value = value * 1000;
                    break;
                case "分米(dm)":
                    if(arc)
                        value = value * 10;
                    else
                        value = value / 10;
                    break;
                case "厘米(cm)":case "平方分米(dm²)":
                    if(arc)
                        value = value * 100;
                    else
                        value = value / 100;
                    break;
                case "毫米(mm)":case "立方分米(dm³)":case "升(l)":case "克(g)":
                    if(arc)
                        value = value * 1000;
                    else
                        value = value / 1000;
                    break;

                case "平方千米(km²)":
                    if(arc)
                        value = value / Math.pow(10,6);
                    else
                        value = value * Math.pow(10,6);
                    break;
                case "平方厘米(cm²)":
                    if(arc)
                        value = value * 10000;
                    else
                        value = value / 10000;
                    break;
                case "平方毫米(mm²)":case "立方厘米(cm³)":
                    if(arc)
                        value = value * Math.pow(10,6);
                    else
                        value = value / Math.pow(10,6);
                    break;
                case "公顷(ha)":
                    if(arc)
                        value = value / 100;
                    else
                        value = value * 100;
                    break;
                case "亩":
                    if(arc)
                        value = value * 0.0015;
                    else
                        value = value / 0.0015;
                    break;

                case "斤":
                    if(arc)
                        value = value * 2;
                    else
                        value = value / 2;
                    break;

                case "年(yr)":
                    if(arc)
                        value = value / 365;
                    else
                        value = value * 365;
                    break;
                case "周(week)":
                    if(arc)
                        value = value / 7;
                    else
                        value = value * 7;
                    break;
                case "小时(h)":
                    if(arc)
                        value = value * 24;
                    else
                        value = value / 24;
                    break;
                case "分钟(min)":
                    if(arc)
                        value = value * 1440;
                    else
                        value = value / 1440;
                    break;
                case "秒(s)":
                    if(arc)
                        value = value * 86400;
                    else
                        value = value / 86400;
                    break;

                case "比特(bit)":
                    if(arc)
                        value = value * 8192;
                    else
                        value = value / 8192;
                    break;
                case "字节(b)":
                    if(arc)
                        value = value * 1024;
                    else
                        value = value / 1024;
                    break;
                case "兆字节(mb)":
                    if(arc)
                        value = value / 1024;
                    else
                        value = value * 1024;
                    break;
                case "千兆字节(gb)":
                    if(arc)
                        value = value / 1048576;
                    else
                        value = value * 1048576;
                    break;
                default:
                    break;
            }
        }
        return sign + String.valueOf(FP(value));
    }

    public double FP(double n) {
        DecimalFormat format = new DecimalFormat("0.#############");
        return Double.parseDouble(format.format(n));
    }
}