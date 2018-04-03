package com.example.jiwoong.homework5;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button b1;
    int tel;
    ListView l1;

    int count = 0;

    ListView listView;
    ArrayList<food> arrayList = new ArrayList<>();
    ArrayList<String> list;
    ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l1=(ListView)findViewById(R.id.listview);
        tv=(TextView)findViewById(R.id.tv);

        list = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        //짧은 클릭으로 세번째 레이아웃 이동
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                intent.putExtra("data",arrayList.get(position));
                startActivityForResult(intent, 0);

            }
        });

        //롱클릭으로 대화상자 열기
        l1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {

                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("삭제확인");
                    dlg.setIcon(R.drawable.a);
                    dlg.setMessage("선택한 맛집을 정말 삭제하시겠습니까?");
                    dlg.setNegativeButton("취소", null);
                    dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                        @Override
                        //리스트 삭제
                        public void onClick(DialogInterface dialog, int which) {

                            list.remove(position);
                            arrayList.remove(position);
                            adapter.notifyDataSetChanged();
                            count--;
                            tv.setText("맛집 리스트 "+count+"개");

                            Snackbar.make(view,"삭제되었습니다",Snackbar.LENGTH_SHORT).show();
                        }
                    });
                    dlg.show();
                    return true;
            }
        });




    }

    public void onClick(View v){

        //맛집추가 버튼
        if(v.getId()==R.id.add) {

            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivityForResult(intent, 0);
        }


    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK){
            food foodData = data.getParcelableExtra("food");
            arrayList.add(foodData);

            //리스트에 추가
            list.add(arrayList.get(count).getname());

            //리스트화면에 보여주기
            l1.setAdapter(adapter);

            count++;

            tv.setText("맛집 리스트 "+count+"개");

        }
        super.onActivityResult(requestCode, resultCode, data);
    }




}
