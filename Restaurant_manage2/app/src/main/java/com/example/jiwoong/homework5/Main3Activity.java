package com.example.jiwoong.homework5;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Date;

import static com.example.jiwoong.homework5.R.drawable.chichen;
import static com.example.jiwoong.homework5.R.drawable.hamburger;
import static com.example.jiwoong.homework5.R.drawable.pizza;

public class Main3Activity extends AppCompatActivity {

    Button btnback;
    TextView txtname,etmenu1,etmenu2,etmenu3,website,ettel,date;
    ImageView imgno;
    String number;
    String site;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnback=(Button)findViewById(R.id.btnback);
        txtname=(TextView)findViewById(R.id.txtname);
        etmenu1=(TextView)findViewById(R.id.etmenu1);
        etmenu2=(TextView)findViewById(R.id.etmenu2);
        etmenu3=(TextView)findViewById(R.id.etmenu3);
        website=(TextView)findViewById(R.id.tvURL);
        ettel=(TextView)findViewById(R.id.tvTel);
        date=(TextView)findViewById(R.id.tvRegdate);
        imgno=(ImageView)findViewById(R.id.imgno);


        Intent intent = getIntent();
        food data = intent.getParcelableExtra("data");
        String rb = data.getRadio();

        //번호와 사이트 저장
        number= data.getTel();
        site= data.getWebsite();


        txtname.setText(data.getname());
        etmenu1.setText(data.getMenu1());
        etmenu2.setText(data.getMenu2());
        etmenu3.setText(data.getMenu3());
        website.setText(data.getWebsite());
        ettel.setText(data.getTel());

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

//텍스트뷰에 현재 시간과 날짜를 출력
        date.setText(currentDateTimeString.substring(0,12));



//사진 바꾸기
        if(rb.equals("chicken")){
            imgno.setImageResource(chichen);

        }
        else if(rb.equals("pizza")){
            imgno.setImageResource(pizza);

        }
        else if(rb.equals("hamburger")){
            imgno.setImageResource(hamburger);

        }





    }



    public void onClick(View v){
        //뒤로가기
        if(v.getId()==R.id.btnback) {
            finish();
        }
        //번호 걸기
        else if(v.getId()==R.id.imageView2){

            Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
            startActivity(intent2);
        }
        //사이트 이동
        else if(v.getId()==R.id.imageView3){

            Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+site));
            startActivity(intent3);

        }


    }
}
