
package com.example.oh.jw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Main5Activity extends AppCompatActivity {

    EditText e1,e2,e3;
    TextView t1,t2;
    CheckBox a1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        setTitle("레스토랑 메뉴 주문");

        Button b1;


        b1=(Button)findViewById(R.id.button3);

        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);

        t1=(TextView)findViewById(R.id.textView8);
        t2=(TextView)findViewById(R.id.textView9);

        a1=(CheckBox)findViewById(R.id.checkBox);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                String text1 = e1.getText().toString();
                String text2 = e2.getText().toString();
                String text3 = e3.getText().toString();

                if(text1.length()==0){
                    e1.setText("0");
                    text1 = e1.getText().toString();
                }

                if(text2.length()==0){
                    e2.setText("0");
                    text2 = e2.getText().toString();
                }

                if(text3.length()==0){
                    e3.setText("0");
                    text3 = e3.getText().toString();
                }



                int result1 = Integer.parseInt(text1) + Integer.parseInt(text2) + Integer.parseInt(text3);
                int result2 = Integer.parseInt(text1)*15000 + Integer.parseInt(text2)*13000 + Integer.parseInt(text3)*9000;

                if(a1.isChecked()==true){
                    result2= result2*9/10;

                }

                t1.setText(result1+ "개");
                t2.setText(result2+ "원");

            }



        });
    }
}