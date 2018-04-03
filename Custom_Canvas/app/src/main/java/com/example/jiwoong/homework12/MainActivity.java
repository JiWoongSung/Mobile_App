package com.example.jiwoong.homework12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyCanvas myCanvas;
    CheckBox checkBox;
    static boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCanvas = (MyCanvas) findViewById(R.id.mycanvas);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
                    check = true;
                } else
                    check = false;




            }
        });

    }

    public void onClick(View v) {
        myCanvas.setOperationType((String) v.getTag());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //메뉴생성


        getMenuInflater().inflate(R.menu.menu, menu);  // 만든 메뉴 불러오기


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // 메뉴를 클릭할때 기능

        if (item.getItemId() == R.id.bluring) {

            if (item.isChecked()) {
                item.setChecked(false);
                myCanvas.setOperationType("nobluring");

            } else {
                item.setChecked(true);
                myCanvas.setOperationType("bluring");

            }


        }
        if (item.getItemId() == R.id.coloring) {

            if (item.isChecked()) {
                item.setChecked(false);
                myCanvas.setOperationType("nocoloring");


            } else {
                item.setChecked(true);
                myCanvas.setOperationType("coloring");

            }
        }


        if (item.getItemId() == R.id.big) {
            if (item.isChecked()) {
                item.setChecked(false);
                myCanvas.setOperationType("nobig");

            } else {
                item.setChecked(true);
                myCanvas.setOperationType("big");


            }
        }
        if (item.getItemId() == R.id.red) {
            myCanvas.setOperationType("red");
        }
        if (item.getItemId() == R.id.blue) {
            myCanvas.setOperationType("blue");
        }


        return super.onOptionsItemSelected(item);
    }


}
