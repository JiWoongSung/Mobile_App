package com.example.oh.jw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("나의 첫번째 어플리케이션");

        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);


        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);


            }




        });


        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){

                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);


            }




        });

        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){

                Intent intent = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent);


            }




        });

        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){

                Intent intent = new Intent(MainActivity.this,Main5Activity.class);
                startActivity(intent);


            }




        });

        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){

                Intent intent = new Intent(MainActivity.this,Main6Activity.class);
                startActivity(intent);


            }




        });







    }
}
