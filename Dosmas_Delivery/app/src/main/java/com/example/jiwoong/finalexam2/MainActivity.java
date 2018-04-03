package com.example.jiwoong.finalexam2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button menu;
    Option option;
    Set.myTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        menu=(Button)findViewById(R.id.menu);
    }

    public void onClick(View v){

        if(v.getId()==R.id.menu) {

            Intent intent = new Intent(this, Set.class);
            startActivity(intent);

        }

        else if(v.getId()==R.id.location){

            Intent intent2 = new Intent(this, Web.class);
            startActivity(intent2);


        }

        else if(v.getId()==R.id.myrecipe){

            Intent intent3 = new Intent(this, MyRecipe.class);
            startActivity(intent3);


        }

        else if(v.getId()==R.id.site){

            Intent intent4 =  new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/dosmasburrito/?fref=ts"));
            startActivity(intent4);


        }

        else if(v.getId()==R.id.phonenum){

            Intent intent5 =  new Intent(Intent.ACTION_DIAL, Uri.parse("tel:031-409-6969"));
            startActivity(intent5);


        }




    }
}
