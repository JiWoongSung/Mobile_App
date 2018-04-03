package com.example.jiwoong.a4week;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnCreateContextMenuListener, View.OnClickListener {

    Button b1, b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.b1) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);

            dlg.setTitle("제목")
                    .setMessage("내용")
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기", null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),
                                    "확인을 눌렀습니다", Toast.LENGTH_SHORT).show();
                        }

                    })
                    .show();
        } else if (v.getId() == R.id.b2) {

            final String data[] = {"치킨","스파게티"};
            AlertDialog.Builder dlg = new AlertDialog.Builder(this); dlg.setTitle("라디오 대화상자");
            dlg.setIcon(R.mipmap.ic_launcher);
            dlg.setSingleChoiceItems(data, 1, null); dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                } });
            dlg.show();

        } else if (v.getId() == R.id.b3) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);

            final String data[] = {"치킨", "피자", "짜장", "탕슉"};
            final boolean checked[] = {true, false, true, false};
            dlg.setTitle("먹고싶은 메뉴는?")
                    .setMultiChoiceItems(data, checked, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            checked[which] = isChecked;
                        }
                    })
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기", null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "확인 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();

        } else if (v.getId() == R.id.b4) {

            View view = View.inflate(this, R.layout.mytoast, null);
            final TextView et = (TextView) view.findViewById(R.id.msg);

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("먹고싶은 메뉴는?")
                    .setView(view)
                    .setMessage("내용")
                    .setIcon(R.mipmap.ic_launcher)
                    .setPositiveButton("닫기", null)
                    .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),
                                    "", Toast.LENGTH_SHORT).show();
                        }

                    })
                    .show();


        }
    }
}
