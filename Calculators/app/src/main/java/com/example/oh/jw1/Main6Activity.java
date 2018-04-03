package com.example.oh.jw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {

    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        setTitle("계산기");

        Button b1,b2,b3,b4;

        b1=(Button)findViewById(R.id.button4);
        b2=(Button)findViewById(R.id.button5);
        b3=(Button)findViewById(R.id.button6);
        b4=(Button)findViewById(R.id.button7);

        e1=(EditText)findViewById(R.id.editText5);
        e2=(EditText)findViewById(R.id.editText6);

            b1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void  onClick(View a){
                    String text1 = e1.getText().toString();
                    String text2 = e2.getText().toString();

                    if (e1.length() == 0 ) {
                        Toast.makeText(getApplicationContext(), "숫자를 입력하세요" , Toast.LENGTH_SHORT).show();
                        e1.requestFocus();
                    }
                    else if (e2.length() == 0)  {
                        Toast.makeText(getApplicationContext(), "숫자를 입력하세요" , Toast.LENGTH_SHORT).show();
                        e2.requestFocus();
                    }

                    else {

                        int result = Integer.parseInt(text1) + Integer.parseInt(text2);

                        Toast.makeText(getApplicationContext(), "더하기 계산결과는" + result + " 입니다", Toast.LENGTH_SHORT).show();
                    }
                }




            });

            b2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void  onClick(View a){
                    String text1 = e1.getText().toString();
                    String text2 = e2.getText().toString();

                    if (e1.length() == 0 ) {
                        Toast.makeText(getApplicationContext(), "숫자를 입력하세요" , Toast.LENGTH_SHORT).show();
                        e1.requestFocus();
                    }
                    else if (e2.length() == 0)  {
                        Toast.makeText(getApplicationContext(), "숫자를 입력하세요" , Toast.LENGTH_SHORT).show();
                        e2.requestFocus();
                    }
                    else {
                        int result = Integer.parseInt(text1) - Integer.parseInt(text2);

                        Toast.makeText(getApplicationContext(), "빼기 계산결과는" + result + " 입니다", Toast.LENGTH_SHORT).show();
                    }
                }




            });

            b3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void  onClick(View a){
                    String text1 = e1.getText().toString();
                    String text2 = e2.getText().toString();
                    if (e1.length() == 0 ) {
                        Toast.makeText(getApplicationContext(), "숫자를 입력하세요" , Toast.LENGTH_SHORT).show();
                        e1.requestFocus();
                    }
                    else if (e2.length() == 0)  {
                        Toast.makeText(getApplicationContext(), "숫자를 입력하세요" , Toast.LENGTH_SHORT).show();
                        e2.requestFocus();
                    }
                    else {
                        int result = Integer.parseInt(text1) * Integer.parseInt(text2);

                        Toast.makeText(getApplicationContext(), "곱하기 계산결과는" + result + " 입니다", Toast.LENGTH_SHORT).show();
                    }
                }




            });

            b4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void  onClick(View a){
                    String text1 = e1.getText().toString();
                    String text2 = e2.getText().toString();
                    if (e1.length() == 0 ) {
                        Toast.makeText(getApplicationContext(), "숫자를 입력하세요" , Toast.LENGTH_SHORT).show();
                        e1.requestFocus();
                    }
                    else if (e2.length() == 0)  {
                        Toast.makeText(getApplicationContext(), "숫자를 입력하세요" , Toast.LENGTH_SHORT).show();
                        e2.requestFocus();
                    }
                    else {

                            int result = Integer.parseInt(text1) / Integer.parseInt(text2);

                            Toast.makeText(getApplicationContext(), "나누기 계산결과는" + result + " 입니다", Toast.LENGTH_SHORT).show();

                    }
                }




            });
    }
}
