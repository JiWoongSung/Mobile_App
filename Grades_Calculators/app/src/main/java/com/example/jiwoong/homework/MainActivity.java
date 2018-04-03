package com.example.jiwoong.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    TextView t1,t2;
    ImageView v1,v2,v3,v4,v5;


    void Invisible(){
        v1.setVisibility(View.GONE);
        v2.setVisibility(View.GONE);
        v3.setVisibility(View.GONE);
        v4.setVisibility(View.GONE);
        v5.setVisibility(View.GONE);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("학점계산기");

        Button b1,b2;


        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);


        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);


        t1=(TextView)findViewById(R.id.textView4);
        t2=(TextView)findViewById(R.id.textView6);

        v1=(ImageView)findViewById((R.id.imageView));
        v2=(ImageView)findViewById((R.id.imageView2));
        v3=(ImageView)findViewById((R.id.imageView3));
        v4=(ImageView)findViewById((R.id.imageView4));
        v5=(ImageView)findViewById((R.id.imageView5));

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View a){
                String text1 = e1.getText().toString();
                String text2 = e2.getText().toString();
                String text3 = e3.getText().toString();

                int result = Integer.parseInt(text1)+Integer.parseInt(text2)+Integer.parseInt(text3) ;
                int result2 = (Integer.parseInt(text1)+Integer.parseInt(text2)+Integer.parseInt(text3))/3 ;




                t1.setText(result+ "점");
                t2.setText(result2+ "점");

                Invisible();

                if(result2<=100 &&result2>=90){
                           v1.setVisibility(View.VISIBLE);


                }
                else if(result2>= 80){
                            v2.setVisibility(View.VISIBLE);

                }
                else if(result2>=70){
                            v3.setVisibility(View.VISIBLE);
                }
                else if(result2>=60){
                    v4.setVisibility(View.VISIBLE);
                }
                else if(result2 < 60){
                    v5.setVisibility(View.VISIBLE);
                }





            }




        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                e1.setText(null);
                e2.setText(null);
                e3.setText(null);
                t1.setText("0점");
                t2.setText("0점");
                Invisible();

                Toast.makeText(getApplicationContext(), "초기화 되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
