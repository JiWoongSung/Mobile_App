package com.example.jiwoong.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class button extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button b1,b2,b3;



        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);


        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                Intent intent = new Intent(button.this,relative.class);
                startActivity(intent);


            }




        });


        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){

                Intent intent = new Intent(button.this,MainActivity.class);
                startActivity(intent);


            }




        });

        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){

                Intent intent = new Intent(button.this,Main2Activity.class);
                startActivity(intent);


            }




        });


    }
}
