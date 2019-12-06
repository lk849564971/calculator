package com.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.R;

import java.text.DecimalFormat;

public class calculator_main extends AppCompatActivity implements View.OnClickListener{
    private long mExitTime;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.calculator,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.help_item:
                Configuration mConfiguration = this.getResources().getConfiguration();
                int ori = mConfiguration.orientation;
                if (ori == mConfiguration.ORIENTATION_LANDSCAPE) {
                    Toast.makeText(this,"log是以10为底的对数", Toast.LENGTH_SHORT).show();
                } else if (ori == mConfiguration.ORIENTATION_PORTRAIT) {
                    Toast.makeText(this,"横屏以解锁更多操作", Toast.LENGTH_SHORT).show();
                }
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
        setContentView(R.layout.activity_calculator);
        Button btn_0 = findViewById(R.id.btn0),
                btn_1 = findViewById(R.id.btn1),
                btn_2 = findViewById(R.id.btn2),
                btn_3 = findViewById(R.id.btn3),
                btn_4 = findViewById(R.id.btn4),
                btn_5 = findViewById(R.id.btn5),
                btn_6 = findViewById(R.id.btn6),
                btn_7 = findViewById(R.id.btn7),
                btn_8 = findViewById(R.id.btn8),
                btn_9 = findViewById(R.id.btn9),
                btn_add = findViewById(R.id.btn_add),
                btn_sub = findViewById(R.id.btn_subtract),
                btn_mul = findViewById(R.id.btn_multiply),
                btn_div = findViewById(R.id.btn_divide),
                btn_back = findViewById(R.id.btn_delete),
                btn_emp = findViewById(R.id.btn_empty),
                btn_poi = findViewById(R.id.btn_point),
                btn_per = findViewById(R.id.btn_percent),

                btn_equ = findViewById(R.id.btn_equal),

                btn_left = findViewById(R.id.btn_left),
                btn_right = findViewById(R.id.btn_right),
                btn_sin = findViewById(R.id.btn_sin),
                btn_cos = findViewById(R.id.btn_cos),
                btn_tan = findViewById(R.id.btn_tan),
                btn_log = findViewById(R.id.btn_log),
                btn_ln = findViewById(R.id.btn_ln),
                btn_e = findViewById(R.id.btn_e),
                btn_pai = findViewById(R.id.btn_pai),
                btn_squ = findViewById(R.id.btn_square),
                btn_fac = findViewById(R.id.btn_factorial),
                btn_gen = findViewById(R.id.btn_genhao),
                btn_more = findViewById(R.id.btn_more),
                btn_change = findViewById(R.id.btn_change),
                btn_other = findViewById(R.id.btn_other);
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
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_emp.setOnClickListener(this);
        btn_poi.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_per.setOnClickListener(this);

        btn_equ.setOnClickListener(this);

        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
        btn_sin.setOnClickListener(this);
        btn_cos.setOnClickListener(this);
        btn_tan.setOnClickListener(this);
        btn_log.setOnClickListener(this);
        btn_ln.setOnClickListener(this);
        btn_e.setOnClickListener(this);
        btn_pai.setOnClickListener(this);
        btn_squ.setOnClickListener(this);
        btn_fac.setOnClickListener(this);
        btn_gen.setOnClickListener(this);
        btn_more.setOnClickListener(this);
        btn_change.setOnClickListener(this);
        btn_other.setOnClickListener(this);

    }

    public void onClick(View v) {
        TextView t1 = findViewById(R.id.text1);
        TextView t2 = findViewById(R.id.text2);
        String s1 = t1.getText() + "";
        String s2 = t2.getText() + "";
        if(s2.length()!=0) {
            s1 = "";
            s2 = "";
        }
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
            case R.id.btn0:
                if(n==0) {
                    s1 = "0";
                }
                else {
                    if(ch[n-1]=='e'||ch[n-1]=='π'||ch[n-1]=='%'||ch[n-1]==')' ||ch[n-1]=='!') {
                        s1 = s1 + "*0";
                        break;
                    }
                    int num = n-1;
                    for(int i =n-1;i>-1;i--){
                        if(ch[i]<48||ch[i]>57) {
                            if(num==i && i!=n-1 && ch[i]!='.')
                                break;
                            s1 = s1 + "0";
                            break;
                        }
                        else if(ch[i]!='0') {
                            s1 = s1 + "0";
                            break;
                        }
                        else
                            num = num - 1;
                    }
                }
                break;
            case R.id.btn1: case R.id.btn2: case R.id.btn3:
            case R.id.btn4: case R.id.btn5: case R.id.btn6:
            case R.id.btn7: case R.id.btn8: case R.id.btn9:
                if("eπ%)!".contains(c1))
                    s1 = s1 + "*" + ((Button)v).getText();
                else if(c1.compareTo("0")==0) {
                    if(n==1)
                        s1 = ((Button)v).getText() + "";
                    else if(ch[n-2]>47&&ch[n-2]<58)
                        s1 = s1 + ((Button)v).getText();
                    else
                        s1 = s1.substring(0,n-1) + ((Button)v).getText();
                }
                else
                    s1 = s1 + ((Button)v).getText();
                break;
            case R.id.btn_subtract:
                if(c1.compareTo("+")==0)
                    s1 = s1.substring(0,n-1)+"-";
                else if(c1.compareTo("*")==0||c1.compareTo("÷")==0)
                    s1 = s1 + "(-";
                else if(c1.compareTo("-")!=0&&c1.compareTo(".")!=0)
                    s1 = s1+"-";
                break;
            case R.id.btn_add:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                if(n==0||c1.compareTo(".")==0||c1.compareTo("(")==0
                        ||c1.compareTo("-")==0&&n==1)
                    break;
                if(c1.compareTo("*")==0||c1.compareTo("+")==0||c1.compareTo("÷")==0)
                    s1 = s1.substring(0,n-1)+((Button)v).getText();
                else if(c1.compareTo("-")==0) {
                    if (c2.compareTo("*") == 0 || c2.compareTo("÷") == 0)
                        s1 = s1.substring(0, n - 2) + ((Button)v).getText();
                    else if(c2.compareTo("(") != 0)
                        s1 = s1.substring(0, n - 1) + ((Button)v).getText();
                }
                else
                    s1 = s1 + ((Button)v).getText();
                break;
            case R.id.btn_delete:
                if( n<=1 )
                    s1 = "";
                else if(c1.compareTo("(")==0)
                    if (ch[n - 2] == '^' || ch[n - 2] == '√')
                        s1 = s1.substring(0, n - 2);
                    else if (ch[n - 2] == 'n')
                        if (ch[n - 3] == 'l')
                            s1 = s1.substring(0, n - 3);
                        else
                            s1 = s1.substring(0, n - 4);
                     else if (ch[n - 2] == 's' || ch[n - 2] == 'g')
                        s1 = s1.substring(0, n - 4);
                     else
                        s1 = s1.substring(0, n - 1);
                else
                    s1 = s1.substring(0, n - 1);
                break;
            case R.id.btn_empty:
                s1 = "";
                break;
            case R.id.btn_point:
                if(n==0) {
                    s1 = s1 + "0.";
                    break;
                }
                else if(c1.compareTo(".")==0)
                    break;
                if("eπ%)!".contains(c1)) {
                    s1 = s1 + "*0.";
                    break;
                }
                for(int i =n-1;i>-1;i--){
                    if(ch[i]=='.')
                        break;
                    else if(ch[i]<48||ch[i]>57) {
                        if(i==n-1) {
                            s1 = s1 + "0.";
                            break;
                        }
                        else {
                            s1 = s1 + ".";
                            break;
                        }
                    }
                    else if(i==0)
                        s1 = s1 + ".";
                }
                break;
            case R.id.btn_percent:
                if("eπ%)!0123456789".contains(c1))
                    s1 = s1 + "%";
                break;


            case R.id.btn_e:
            case R.id.btn_pai:
                if(n==0) {
                    s1 = ((Button)v).getText()+ "";
                    break;
                }
                if("eπ%)!0123456789".contains(c1))
                    s1 = s1 + "*" + ((Button)v).getText();
                else if(c1.compareTo(".")==0)
                    break;
                else
                    s1 = s1 + ((Button)v).getText();
                break;
            case R.id.btn_left:
                if(n==0) {
                    s1 = s1 + "(";
                    break;
                }
                if(c1.compareTo(".")==0)
                    break;
                if("eπ%)!0123456789".contains(c1))
                    s1 = s1 + "*(";
                else
                    s1 = s1 + "(";
                break;
            case R.id.btn_right:
                if(n<2||c1.compareTo("(")==0)
                    break;
                int left = 0,
                        right = 0;
                for(int i =0;i<n;i++)
                    if(ch[i]=='(')
                        left++;
                    else if(ch[i]==')')
                        right++;
                if(left>right && c1.compareTo(".")!=0)
                    s1 = s1 + ")";
                break;
            case R.id.btn_sin: case R.id.btn_cos: case R.id.btn_tan:
            case R.id.btn_ln: case R.id.btn_log:
            case R.id.btn_genhao:
                if(n==0) {
                    s1 = s1 + ((Button)v).getText() + "(";
                    break;
                }
                if("eπ%)!0123456789".contains(c1))
                    s1 = s1 + "*" + ((Button)v).getText() + "(";
                else if(c1.compareTo(".")==0)
                    break;
                else
                    s1 = s1 + ((Button)v).getText() + "(";
                break;
            case R.id.btn_square:
                if("eπ%)!0123456789".contains(c1))
                    s1 = s1 + "^(2)";
                break;
            case R.id.btn_more:
                if("eπ%)!0123456789".contains(c1))
                    s1 = s1 + "^(";
                break;
            case R.id.btn_factorial:
                if(n==0||".eπ%(!".contains(c1))
                    break;
                for(int i =n-1;i>-1;i--){
                    if(ch[i]=='.')
                        break;
                    else if(ch[i]<48||ch[i]>57) {
                        if (i != n - 1) {
                            s1 = s1 + "!";
                            break;
                        }
                    }
                    else if(i==0)
                        s1 = s1 + "!";
                }
                break;


            case R.id.btn_equal:
                while(true){
                    n = s1.length();
                    if(n==0)
                        break;
                    else if("(^√logctasin+-*÷".contains(ch[n-1]+""))
                        s1 = s1.substring(0,n-1);
                    else
                        break;
                }
                if(s1.compareTo("")==0)
                    Toast.makeText(this,"请先输入数据", Toast.LENGTH_SHORT).show();
                else {
                    if (t2.getText().length() != 0)
                        s1 = t1.getText() + "";
                    else {
                        ch = s1.toCharArray();
                        int l = 0,
                                r = 0;
                        for (int i = 0; i < n; i++)
                            if (ch[i] == '(')
                                l++;
                            else if (ch[i] == ')')
                                r++;
                        l = l - r;
                        StringBuilder stb = new StringBuilder(s1);
                        for (int i = 0; i < l; i++)
                            stb.append(")");
                        s1 = stb.toString();
                    }
                    try {
                        s2 = "= " + calculate(s1);
                        n = s2.length();
                        if(s2.substring(n-2).compareTo(".0")==0)
                            s2 = s2.substring(0,n-2);
                        else if(s2.substring(n-1).compareTo(".")==0)
                            s2 = s2.substring(0,n-1);
                    } catch (Exception e) {
                        s2 = "错误";
                    }
                }
                break;

            case R.id.btn_change:
                Intent intent1 = new Intent(calculator_main.this,calculator_change.class);
                startActivity(intent1);
                break;
            case R.id.btn_other:
                Intent intent2 = new Intent("com.example.other.ACTION_START");
                intent2.addCategory("com.example.other.MY_CATEGORY");
                startActivity(intent2);
                break;
            default:
                break;
        }
        t1.setText(s1);
        t2.setText(s2);
    }

    public String calculate(String str) {
        int weightPlus = 0, topOp = 0,
                topNum = 0, weightTemp = 0,
                begin,flag = 1;
        //weightPlus为同一（）下的基本优先级，weightTemp临时记录优先级的变化
        //topOp为weight[]，operator[]的计数器；topNum为number[]的计数器
        //flag为正负数的计数器，1为正数，-1为负数,begin为提取数字时的开始位置
        int[] weight= new int[100];  //保存operator栈中对应运算符的优先级
        double[] number= new double[100];  //保存数字
        char[] operator = new char[100],//operator[]保存运算符
                ch = str.toCharArray();
        for(int i = 0;i < str.length();i++) {
            if (i == 0) {
                if (ch[i] == '-')
                    flag = -1;
            }
            else if(ch[i-1] == '(' && ch[i] == '-')
                flag = -1;

            if (ch[i] <= '9' && ch[i] >= '0') {
                begin = i;
                do{
                    i++;
                }while (i < str.length() && (ch[i] <= '9' && ch[i]>= '0'|| ch[i] == '.' ));
                number[topNum++] = Double.parseDouble(str.substring(begin,i))*flag;
                flag = 1;
                i--;
            }
            else if (ch[i] == 'e') {
                number[topNum++] = 2.718281828459045*flag;
                flag = 1;
            }
            else if (ch[i] == 'π') {
                number[topNum++] = 3.141592653589793*flag;
                flag = 1;
            }
            //计算运算符的优先级,+-的优先级为1,*÷的优先级为2，为2,sincos之类优先级为3,^√%!优先级为4
            else if (ch[i] == '(') weightPlus+=4;
            else if (ch[i] == ')') weightPlus-=4;
            else if (ch[i] == '-' && flag == 1 || ch[i] == '+' || ch[i] == '*'|| ch[i] == '÷' ||
                    ch[i] == 's' ||ch[i] == 'c' || ch[i] == 't' || ch[i] == 'g' || ch[i] == 'l' ||
                    ch[i] == '!' || ch[i] == '√' || ch[i] == '^'|| ch[i] == '%') {
                switch (ch[i]) {
                    case '+': case '-':
                        weightTemp = 1 + weightPlus;
                        break;
                    case '*': case '÷':
                        weightTemp = 2 + weightPlus;
                        break;
                    case 's': case 'c': case 't': case 'g':
                        weightTemp = 3 + weightPlus;
                        break;
                    case 'l':
                        if(ch[i+1] == 'n')
                            weightTemp = 3 + weightPlus;
                        else
                            continue;
                        break;
                    default:
                        weightTemp = 4 + weightPlus;
                        break;
                }
                //如果当前优先级大于堆栈顶部元素，则直接入栈,否则将堆栈中运算符逐个取出，直到当前堆栈顶部运算符的优先级小于当前运算符
                if (topOp == 0 || weight[topOp-1] < weightTemp) {
                    weight[topOp] = weightTemp;
                    operator[topOp] = ch[i];
                    topOp++;

                }
                else {
                    while (topOp > 0 && weight[topOp-1] >= weightTemp) {
                        switch (operator[topOp-1]) {
                            case '+':
                                number[topNum-2]+=number[topNum-1];
                                break;
                            case '-':
                                number[topNum-2]-=number[topNum-1];
                                break;
                            case '*':
                                number[topNum-2]*=number[topNum-1];
                                break;
                            case '÷':
                                if (number[topNum-1] == 0) {
                                    showError(1);
                                    return "错误";
                                }
                                number[topNum-2]/=number[topNum-1];
                                break;
                            case '√':
                                if(number[topNum-1] == 0 || (number[topNum-2] < 0 &&
                                        number[topNum-1] % 2 == 0)) {
                                    showError(2);
                                    return "错误";
                                }
                                number[topNum-2] =
                                        Math.pow(number[topNum-2], 1/number[topNum-1]);
                                break;
                            case '^':
                                number[topNum-2] =
                                        Math.pow(number[topNum-2], number[topNum-1]);
                                break;
                            //sin
                            case 's':
                                number[topNum-1] = Math.sin(number[topNum-1]);
                                topNum++;
                                break;
                            //cos
                            case 'c':
                                number[topNum-1] = Math.cos(number[topNum-1]);
                                topNum++;
                                break;
                            //tan
                            case 't':
                                if((Math.abs(number[topNum-1])/(Math.PI/2))%2 == 1) {
                                    showError(2);
                                    return "错误";
                                }
                                number[topNum-1] = Math.tan(number[topNum-1]);
                                topNum++;
                                break;
                            //log
                            case 'g':
                                if(number[topNum-1] <= 0) {
                                    showError(2);
                                    return "错误";
                                }
                                number[topNum-1] = Math.log10(number[topNum-1]);
                                topNum++;
                                break;
                            //ln
                            case 'l':
                                if(number[topNum-1] <= 0) {
                                    showError(2);
                                    return "错误";
                                }
                                number[topNum-1] = Math.log(number[topNum-1]);
                                topNum++;
                                break;
                            case '!':
                                if(number[topNum-1] > 170) {
                                    showError(3);
                                    return "错误";
                                } else if(number[topNum-1] < 0) {
                                    showError(2);
                                    return "错误";
                                }
                                number[topNum-1] = N(number[topNum-1]);
                                topNum++;
                                break;
                            case '%':
                                number[topNum-1] = number[topNum-1]/100;
                                topNum++;
                                break;
                        }
                        topNum--;
                        topOp--;
                    }
                    weight[topOp] = weightTemp;
                    operator[topOp] = ch[i];
                    topOp++;
                }
            }
        }
        while (topOp>0) {
            switch (operator[topOp-1]) {
                case '+':
                    number[topNum-2]+=number[topNum-1];
                    break;
                case '-':
                    number[topNum-2]-=number[topNum-1];
                    break;
                case '*':
                    number[topNum-2]*=number[topNum-1];
                    break;
                case '÷':
                    if (number[topNum-1] == 0) {
                        showError(1);
                        return "错误";
                    }
                    number[topNum-2]/=number[topNum-1];
                    break;
                case '√':
                    if(number[topNum-1] == 0 || (number[topNum-2] < 0 &&
                            number[topNum-1] % 2 == 0)) {
                        showError(2);
                        return "错误";
                    }
                    number[topNum-2] =
                            Math.pow(number[topNum-2], 1/number[topNum-1]);
                    break;
                case '^':
                    number[topNum-2] =
                            Math.pow(number[topNum-2], number[topNum-1]);
                    break;
                //sin
                case 's':
                    number[topNum-1] = Math.sin(number[topNum-1]);
                    topNum++;
                    break;
                //cos
                case 'c':
                    number[topNum-1] = Math.cos(number[topNum-1]);
                    topNum++;
                    break;
                //tan
                case 't':
                    if((Math.abs(number[topNum-1])/(Math.PI/2))%2 == 1) {
                        showError(2);
                        return "错误";
                    }
                    number[topNum-1] = Math.tan(number[topNum-1]);
                    topNum++;
                    break;
                //log
                case 'g':
                    if(number[topNum-1] <= 0) {
                        showError(2);
                        return "错误";
                    }
                    number[topNum-1] = Math.log10(number[topNum-1]);
                    topNum++;
                    break;
                //ln
                case 'l':
                    if(number[topNum-1] <= 0) {
                        showError(2);
                        return "错误";
                    }
                    number[topNum-1] = Math.log(number[topNum-1]);
                    topNum++;
                    break;
                case '!':
                    if(number[topNum-1] > 170) {
                        showError(3);
                        return "错误";
                    } else if(number[topNum-1] < 0) {
                        showError(2);
                        return "错误";
                    }
                    number[topNum-1] = N(number[topNum-1]);
                    topNum++;
                    break;
                case '%':
                    number[topNum-1] = number[topNum-1]/100;
                    topNum++;
                    break;
            }
            topNum--;
            topOp--;
        }
        //数字太大
        if(number[0] > 7.3E306) {
            showError(3);
            return "错误";
        }
        return String.valueOf(FP(number[0]));
    }

    public double FP(double n) {
        DecimalFormat format = new DecimalFormat("0.#############");
        return Double.parseDouble(format.format(n));
    }

    //阶乘
    public double N(double n) {
        int i = 0;
        double sum = 1;
        for(i = 1;i <= n;i++) {
            sum = sum*i;
        }
        return sum;
    }

    public void showError(int code) {
        String message="";
        switch (code) {
            case 1:
                message = "零不能作除数";
                break;
            case 2:
                message = "函数格式错误";
                break;
            case 3:
                message = "值太大了，超出范围";
        }
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
