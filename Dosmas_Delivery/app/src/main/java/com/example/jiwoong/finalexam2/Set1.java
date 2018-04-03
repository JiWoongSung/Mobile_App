package com.example.jiwoong.finalexam2;

import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Set1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set1);
        setTitle("메뉴");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



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

    public void onClick(View v){
        Intent intent = new Intent(this, Option.class);
        int price = 0;
        String menu = "";
        switch (v.getId()){
            case R.id.i1:
                menu = "닭고기브리또";
                price = 3000;
                break;
            case R.id.i2:
                menu = "섞어서브리또";
                price = 3000;
                break;
            case R.id.i3:
                menu = "소고기브리또";
                price = 3500;
                break;
            case R.id.i4:
                menu = "제육브리또";
                price = 3500;
                break;
            case R.id.i5:
                menu = "텐더브리또";
                price = 4000;
                break;
        }

        intent.putExtra("price",price);
        intent.putExtra("menu",menu);
        startActivity(intent);




    }
}
