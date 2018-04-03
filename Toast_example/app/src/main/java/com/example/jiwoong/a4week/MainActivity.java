package com.example.jiwoong.a4week;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button b1,b2,b3,b4;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {


                Toast.makeText(getApplicationContext(), "기본메세지입니다", Toast.LENGTH_SHORT).show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                Toast toastView = Toast.makeText(getApplicationContext(),"위치 지정 메세지 창입니다", Toast.LENGTH_SHORT);

                toastView.setGravity(Gravity.LEFT | Gravity.TOP, 10,20);
                toastView.show();


            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = getLayoutInflater().inflate(R.layout.mytoast,null);
                TextView tv = (TextView)view.findViewById(R.id.msg) ;
                tv.setText("레이아웃으로 만든 토스트 창입니다.");
                Toast toastView = new Toast(getApplicationContext());
                toastView.setDuration(Toast.LENGTH_SHORT);
                toastView.setGravity(Gravity.CENTER,0,100);
                toastView.setView(view);
                toastView.show();




            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {


                    Snackbar.make(a, "Message",1000).setAction("확인", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                        }
                    }).show();



            }
        });



    }



}
