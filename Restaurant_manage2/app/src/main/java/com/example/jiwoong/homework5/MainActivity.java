package com.example.jiwoong.homework5;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    Button b1;
    int tel;
    ListView listView;
    EditText search;
    Button selectBtn;

    int count = 0;

    boolean delBtnClicked= false;

    //정보를 갖고있는 어레이 리스트
    ArrayList<food> arrayList = new ArrayList<>();
    //제목을 보여주기위한 어레이 리스트
    ArrayList<String> list;
    NewA adapt;

    ArrayList<Integer> deleteList;

    Comparator<food> dataAsc = new Comparator<food>() {
        @Override
        public int compare(food o1, food o2) {
            return o1.getname().compareToIgnoreCase(o2.getname());
        }
    };

    Comparator<food> kindComp = new Comparator<food>() {
        @Override
        public int compare(food o1, food o2) {
            return o1.getRadio().compareTo(o2.getRadio());
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listview);
        search=(EditText)findViewById(R.id.search);
        selectBtn = (Button)findViewById(R.id.select);


        list = new ArrayList<String>();

        adapt = new NewA(this, arrayList, delBtnClicked);



        //seach기능
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ArrayList<food> searchResult = new ArrayList<food>();
                String search = s.toString();

                for(food temp : arrayList) {
                    if(temp.getname().contains(search)) {
                        searchResult.add(temp);
                    }
                }

                adapt.setData(searchResult);

                adapt.notifyDataSetChanged();
            }
        });








        //짧은 클릭으로 세번째 레이아웃 이동
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                intent.putExtra("data",arrayList.get(position));
                startActivityForResult(intent, 0);

            }
        });

        //롱클릭으로 대화상자 열기
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
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
                            adapt.notifyDataSetChanged();


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

        //이름정렬
        else if(v.getId()==R.id.sname){

            //adapt.setNameAscSort();
            Collections.sort(arrayList, dataAsc);
            adapt.notifyDataSetChanged();

        }

        else if(v.getId() == R.id.kind) {


            Collections.sort(arrayList, kindComp);
            adapt.notifyDataSetChanged();
        }

        else if (v.getId() == R.id.select) {
            if(selectBtn.getText().equals("선택")) {
                delBtnClicked = true;

                adapt.setDelBtn(delBtnClicked);

                adapt.notifyDataSetChanged();

                selectBtn.setText("삭제");
            } else {
                deleteList = adapt.getDeleteList();


                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("삭제확인");
                dlg.setIcon(R.drawable.a);
                dlg.setMessage("선택한 맛집을 정말 삭제하시겠습니까?");
                dlg.setNegativeButton("취소", null);
                dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    //리스트 삭제
                    public void onClick(DialogInterface dialog, int which) {

                        for(int i = deleteList.size()-1;i>=0;i--) {
                            Log.i("deleteTest", Integer.toString(deleteList.get(i)));
                            arrayList.remove(deleteList.get(i).intValue());

                        }
                        delBtnClicked= false;
                        adapt.setDelBtn(delBtnClicked);
                        selectBtn.setText("선택");

                        adapt.notifyDataSetChanged();


//                        Snackbar.make(/**/,"삭제되었습니다",Snackbar.LENGTH_SHORT).show();
                    }
                });
                dlg.show();

//                delBtnClicked = false;
//
//                adapt.setDelBtn(delBtnClicked);
//
//                adapt.notifyDataSetChanged();


            }



        }

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK){
            food foodData = data.getParcelableExtra("food");
            arrayList.add(foodData);

//            //리스트에 추가
//            list.add(arrayList.get(count).getname());

            //리스트화면에 보여주기
            listView.setAdapter(adapt);





            count++;


        }
        super.onActivityResult(requestCode, resultCode, data);
    }




//    private ArrayList<food> sortByName(ArrayList<food> foodList) {
//        ArrayList<food> sortedList = new ArrayList<food>();
//
//        Collections.sort();
//
//        return sortedList;
//    }




}
