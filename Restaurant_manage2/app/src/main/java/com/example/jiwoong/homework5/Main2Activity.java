package com.example.jiwoong.homework5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    EditText etname,ettel,etmenu1,etmenu2,etmenu3,website;
    RadioButton radio1,radio2,radio3;
    ArrayList<food> arrayList = new ArrayList<food>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etname = (EditText)findViewById(R.id.etname);
        ettel = (EditText)findViewById(R.id.ettel);
        etmenu1= (EditText)findViewById(R.id.etmenu1);
        etmenu2= (EditText)findViewById(R.id.etmenu2);
        etmenu3= (EditText)findViewById(R.id.etmenu3);
        website= (EditText)findViewById(R.id.etaddr);
        radio1=(RadioButton)findViewById(R.id.radio1);
        radio2=(RadioButton)findViewById(R.id.radio2);
        radio3=(RadioButton)findViewById(R.id.radio3);


    }


    public void onClick(View v) {

        //맛집추가 취소 버튼
        if (v.getId() == R.id.btnCancel) {
            finish();
        }


        //맛집추가화면
        else if (v.getId() == R.id.btnAdd) {
            Intent intent = new Intent();
            String etnameT = etname.getText().toString();
            String ettelT = ettel.getText().toString();
            String etmenu1T = etmenu1.getText().toString();
            String etmenu2T = etmenu2.getText().toString();
            String etmenu3T = etmenu3.getText().toString();
            String websiteT = website.getText().toString();
            String radio="chicken";


            if(radio1.isChecked()){
                radio="chicken";
            }
            else if(radio2.isChecked()){
                radio="pizza";
            }
            else if(radio3.isChecked()){
                radio="hamburger";
            }
       //     String radiostring = radio;
            food food = new food(etnameT, ettelT,etmenu1T, etmenu2T, etmenu3T, websiteT, radio);
            intent.putExtra("food", food);
            setResult(RESULT_OK, intent);
            finish();


        }
    }

}

