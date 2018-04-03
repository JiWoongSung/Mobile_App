package com.example.oh.jw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("나이계산기");

        Button b1,b2;

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);

        e1=(EditText)findViewById(R.id.editText2);
        e2=(EditText)findViewById(R.id.editText3);


        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View a){
                String text1 = e1.getText().toString();


                int result = 2017-Integer.parseInt(text1)+1 ;


                Toast.makeText(getApplicationContext(), " 당신의 나이는"+result+"세 입니다" , Toast.LENGTH_SHORT).show();

            }




        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View a){
                String text2 = e2.getText().toString();


                int result = 2017-Integer.parseInt(text2)+1 ;


                Toast.makeText(getApplicationContext(), " 당신이 태어난 해는 "+result+"년도 입니다" , Toast.LENGTH_SHORT).show();

            }




        });


    }
}
