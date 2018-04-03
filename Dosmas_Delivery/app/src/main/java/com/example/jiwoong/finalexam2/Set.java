package com.example.jiwoong.finalexam2;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Set extends AppCompatActivity {

    int orderNum = 1;
    int kind=0;
    int changetime = 1;
    myTask task;
    ImageView imageView;
    TextView setname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        imageView=(ImageView)findViewById(R.id.imageView);
        setname=(TextView)findViewById(R.id.setname);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("메뉴선택");




    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
               // NavUtils.navigateUpFromSameTask(this);
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    };

    @Override
    protected void onStart() {
        super.onStart();
        task = new myTask();
        task.execute(0);
    }

    @Override
    protected void onPause() {
        super.onPause();
        task.cancel(true);
    }

    public void onClick(View v){

        if(v.getId()==R.id.b1){
            Intent intent2 = new Intent(this, Set1.class);
            startActivity(intent2);

        }
        else if(v.getId()==R.id.b2){
            Intent intent3 = new Intent(this, Set2.class);
            startActivity(intent3);

        }
        else if(v.getId()==R.id.b3){
            Intent intent4 = new Intent(this, Set3.class);
            startActivity(intent4);

        }
        else if(v.getId()==R.id.b4){
            Intent intent5 = new Intent(this, Set4.class);
            startActivity(intent5);

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


                    Thread.sleep(1100);
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


            if (values[0] % changetime == 0) {

                kind++;
                change();


            }



        }


        protected void onCancelled() { // iscanceled true면 일로

            super.onCancelled();
        }
    }


    public void change() {
        if (kind == 1) {
            imageView.setImageResource(R.drawable.a);
            setname.setText(" Set1 ");

        }
        if (kind == 2) {
            imageView.setImageResource(R.drawable.b);
            setname.setText(" Set2 ");

        }
        if (kind == 3) {
            imageView.setImageResource(R.drawable.c);
            setname.setText(" Set3 ");

        }
        if (kind == 4) {
            imageView.setImageResource(R.drawable.d);
            setname.setText(" Set4 ");
            kind = 0;

        }


    }
}
