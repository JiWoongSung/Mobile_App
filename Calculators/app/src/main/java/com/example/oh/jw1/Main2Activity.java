package com.example.oh.jw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("사과 계산");

        Button b1;



        b1=(Button)findViewById(R.id.button);

        e1=(EditText)findViewById(R.id.editText2);
        e2=(EditText)findViewById(R.id.editText3);


        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View a){
                String text1 = e1.getText().toString();
                String text2 = e2.getText().toString();


                int result = Integer.parseInt(text1) * Integer.parseInt(text2) ;


                Toast.makeText(getApplicationContext(), "사과의 총 가격은 "+result+"입니다." , Toast.LENGTH_SHORT).show();

            }




        });

    }
}
