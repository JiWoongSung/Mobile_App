package com.example.jiwoong.homework3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TabHost tabHost;
    TextView t1,t2,t3,t4;
    Button b1,b2,b3;
    EditText e1,e2,e3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("각종 계산기");


        tabHost=(TabHost)findViewById(R.id.t1);

        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("A").setContent(R.id.tab2)
                .setIndicator("BMI 계산기");
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("B").setContent(R.id.tab1)
                .setIndicator("면적 계산기");
        tabHost.addTab(tab2);


        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.e1);
        t3=(TextView)findViewById(R.id.textView7);
        t1=(TextView)findViewById(R.id.t2);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.b1);
        b3=(Button)findViewById(R.id.b2);




        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View a) {
                String text1 = e1.getText().toString();
                String text2 = e2.getText().toString();


                double result = (Integer.parseInt(text2)/ Math.pow(Integer.parseInt(text1),2))*10000;
                Toast.makeText(getApplicationContext(), "비만도는 "+String.format("%.2f",result) , Toast.LENGTH_SHORT).show();

                if (result >= 25) {
                    t3.setText("비만입니다!!");
                    t3.setTextColor(Color.RED);
                }
                else if(result>=23){
                    t3.setText("과체중입니다!!");
                    t3.setTextColor(Color.RED);

                }
                else if(result>=18.5){
                    t3.setText("정상입니다!!");
                    t3.setTextColor(Color.BLUE);
                }
                else if(result<18.5){
                    t3.setText("체중부족입니다!!");
                    t3.setTextColor(Color.RED);
                }



            }

            });

        b2.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View a) {

                String text1 = e3.getText().toString();
                double result = Integer.parseInt(text1)*(3.305785);

                t1.setText(result+"제곱미터");

            }

        });


        b3.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View a) {

                String text1 = e3.getText().toString();
                double result = Integer.parseInt(text1)*(0.3025);

                t1.setText(result+"평");


            }

        });



        }
    }