package com.example.jiwoong.homework3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t1;
    ImageView v1,v2;
    LinearLayout L1;
    int count =0;
    float n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴를 눌러보세요");

        t1 = (TextView)findViewById(R.id.textView);

        v1 = (ImageView)findViewById(R.id.imageView);
        v2 = (ImageView)findViewById(R.id.imageView2);


        L1 = (LinearLayout)findViewById(R.id.back);







    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //치킨,스파게티
        if (item.getItemId() == R.id.menu4){
            v1.setVisibility(View.VISIBLE);
            v2.setVisibility(View.GONE);

            t1.setText("겁나 맛있는 치킨");
            item.setChecked(true);
            v1.setRotation(0);


        }
        else if(item.getItemId() == R.id.menu5){
            v2.setVisibility(View.VISIBLE);
            v1.setVisibility(View.GONE);

            t1.setText("새콤한 스파게티");
            item.setChecked(true);
            v2.setRotation(0);



        }

         //배경색 바꾸기
        if(item.getItemId() == R.id.red){
            L1.setBackgroundColor(Color.RED);


        }

        else if(item.getItemId() == R.id.blue){
            L1.setBackgroundColor(Color.BLUE);

        }

        else if(item.getItemId() == R.id.yellow){
            L1.setBackgroundColor(Color.YELLOW);

        }


        //제목보이기
        if(item.getItemId() == R.id.menu2){


            if(item.isChecked()){
                item.setChecked(false);
                t1.setVisibility(View.INVISIBLE);
            }
            else {
                item.setChecked(true);
                t1.setVisibility(View.VISIBLE);
            }

        }
        //2배늘이기
        if(item.getItemId() == R.id.menu3){


            if(item.isChecked()){
                item.setChecked(false);
                v1.setScaleX(1);
                v1.setScaleY(1);
                v2.setScaleX(1);
                v2.setScaleY(1);

            }
            else {
                item.setChecked(true);
                v1.setScaleX(1);
                v1.setScaleY(2);
                v2.setScaleX(1);
                v2.setScaleY(2);

            }

        }

        //30도 회전
        if(item.getItemId() == R.id.menu1){

          count++;
            rotation();



        }





        return super.onOptionsItemSelected(item);
    }



        void rotation(){
                    n=count;

                    v1.setRotation(30* n);
                    v2.setRotation(30* n);



        }




}
