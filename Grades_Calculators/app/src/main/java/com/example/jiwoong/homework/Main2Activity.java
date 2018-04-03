package com.example.jiwoong.homework;

import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {


    Chronometer c1;
    TextView t1,tt1,tt2,tt3,q1,q2;
    LinearLayout l1;
    DatePicker d1;
    TimePicker time1;
    GridLayout g1;
    Button b1,b2;
    Switch s1;
    TableLayout table;
    EditText e1,e2,e3;
    int count=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("레스토랑 예약시스템");





        table=(TableLayout)findViewById(R.id.table);
        c1=(Chronometer)findViewById(R.id.chronometer2);
        t1=(TextView)findViewById(R.id.t1);
        tt1=(TextView)findViewById(R.id.textView20);
        tt2=(TextView)findViewById(R.id.textView18);
        tt3=(TextView)findViewById(R.id.textView16);
        q1=(TextView)findViewById(R.id.textView24);
        q2=(TextView)findViewById(R.id.textView22);
        l1=(LinearLayout)findViewById(R.id.L1) ;
        d1=(DatePicker)findViewById(R.id.datePicker);
        time1=(TimePicker)findViewById(R.id.timePicker);
        g1=(GridLayout)findViewById(R.id.Grid);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        s1=(Switch)findViewById(R.id.switch1);
        e1=(EditText)findViewById(R.id.editText4);
        e2=(EditText)findViewById(R.id.editText6);
        e3=(EditText)findViewById(R.id.editText7);




        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            void date(){
                q1.setText(d1.getYear() + "년 " + (d1.getMonth()+1) + "월 " + d1.getDayOfMonth() + "일");
            }

            void setTime() {
                int Hour, Minute;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Hour = time1.getHour();
                    Minute = time1.getMinute();
                } else {
                    Hour = time1.getCurrentHour();
                    Minute = time1.getCurrentMinute();
                }
                 q2.setText(String.format("%d시 %d분", Hour, Minute));
            }




            void button2() {
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String text1 = e1.getText().toString();
                        String text2 = e2.getText().toString();
                        String text3 = e3.getText().toString();
                        tt1.setText(text1 + "명");
                        tt2.setText(text2 + "명");
                        tt3.setText(text3 + "명");
                        date();
                        setTime();

                        count++;
                        screen();

                    }


                });
            }

            void screen() {
                if (count == 1) {
                    d1.setVisibility(View.VISIBLE);
                    time1.setVisibility(View.INVISIBLE);
                    table.setVisibility(View.INVISIBLE);
                    g1.setVisibility(View.INVISIBLE);
                    b1.setEnabled(false);
                    b2.setEnabled(true);

                } else if (count == 2) {
                    d1.setVisibility(View.INVISIBLE);
                    time1.setVisibility(View.VISIBLE);
                    table.setVisibility(View.INVISIBLE);
                    g1.setVisibility(View.INVISIBLE);
                    b1.setEnabled(true);
                    b2.setEnabled(true);

                }else if (count == 3) {
                    d1.setVisibility(View.INVISIBLE);
                    time1.setVisibility(View.INVISIBLE);
                    table.setVisibility(View.VISIBLE);
                    g1.setVisibility(View.INVISIBLE);
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    button2();


                }else if (count == 4) {
                    d1.setVisibility(View.INVISIBLE);
                    time1.setVisibility(View.INVISIBLE);
                    table.setVisibility(View.INVISIBLE);
                    g1.setVisibility(View.VISIBLE);

                    b1.setEnabled(true);
                    b2.setEnabled(false);


                }
                else{
                    d1.setVisibility(View.INVISIBLE);
                    time1.setVisibility(View.INVISIBLE);
                    table.setVisibility(View.INVISIBLE);
                    g1.setVisibility(View.INVISIBLE);


                }
            }

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    count++;
                    t1.setVisibility(View.VISIBLE);
                    c1.setVisibility(View.VISIBLE);
                    l1.setVisibility(View.VISIBLE);


                    c1.setBase(SystemClock.elapsedRealtime());
                    c1.start();
                    screen();


                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            count--;
                            screen();

                        }


                    });
                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            count++;
                            screen();

                        }


                    });




                }
                else
                {
                    count=0;
                    t1.setVisibility(View.GONE);
                    c1.setVisibility(View.GONE);
                    l1.setVisibility(View.INVISIBLE);
                    screen();

                    c1.stop();

                }

            }


        });




         }








    }





