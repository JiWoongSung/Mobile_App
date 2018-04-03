package com.example.jiwoong.homework13;

import android.graphics.Color;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText insert;
    ImageView imageview;
    TextView time;
    myTask task;
    int index = 0;
    int aftertime = 0;

    int changetime = 1;

    int kind = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = (EditText) findViewById(R.id.insert);    //초 입력
        time = (TextView) findViewById(R.id.time);
        imageview = (ImageView) findViewById(R.id.imageView);


    }


    public void onClick(View v) {

        String num = insert.getText().toString();

        if(num.getBytes().length==0){
            Toast.makeText(getApplicationContext(),"초 간격을 입력해주세요.",Toast.LENGTH_SHORT).show();

        }
        else {
            changetime = Integer.parseInt(num);

            if (v.getId() == R.id.imageView) {

                if (index == 0) {

                    task = new myTask();
                    task.execute(0);


                    index++;
                } else {
                    task.cancel(true);
                    task = null;
                    index--;
                }

            }
        }







        if (v.getId() == R.id.first) {

            if (index == 0) {
                time.setText("시간");
                imageview.setImageResource(R.drawable.abc);

            } else {
                Toast.makeText(getApplication(), "중단 후 눌러주세요", Toast.LENGTH_SHORT).show();
            }

        }


    }


    class myTask extends AsyncTask<Integer, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();    //시작하기전


        }

        @Override
        protected Void doInBackground(Integer... params) {
            for (int i = 1; i < 101; i++) {
                if (isCancelled() == true) {

                    return null;

                }
                try {


                    Thread.sleep(1000);
                    publishProgress(i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);



            time.setText("시작부터 " + values[0] + "초");


            if (values[0] % changetime == 0) {

                kind++;
                change();


            }


            aftertime = values[0];


        }


        protected void onCancelled() { // iscanceled true면 일로
            time.setText(kind + 1 + "번 고양이 선택 " + "(" + aftertime + "초)");
            super.onCancelled();
        }
    }


    public void change() {
        if (kind == 1) {
            imageview.setImageResource(R.drawable.a);

        }
        if (kind == 2) {
            imageview.setImageResource(R.drawable.b);

        }
        if (kind == 3) {
            imageview.setImageResource(R.drawable.c);
            kind = 0;
        }


    }


}