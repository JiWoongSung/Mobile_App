package com.example.jiwoong.homework14;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.b1) {

            Intent intent = new Intent(this, Url.class);
            startActivity(intent);

        } else if (v.getId() == R.id.b2) {

            Intent intent2 = new Intent(this, Networking.class);
            startActivity(intent2);


        } else if (v.getId() == R.id.b3) {

            Intent intent3 = new Intent(this, Login.class);
            startActivity(intent3);


        }


    }
}