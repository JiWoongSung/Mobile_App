package com.example.jiwoong.finalexam2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class MyRecipe extends AppCompatActivity {

    ListView listView;
    ArrayList<RecipeData> recipeData = new ArrayList<RecipeData>(); //레시피데이터를 갖는 어레이 리스트
    CustomAdapter adapter; //커스텀 어댑터



    DatePicker datePicker;
    LinearLayout myrecipe, linear2;
    EditText memo;
    ArrayList<String> Data = new ArrayList<String>();
    ArrayAdapter adapter2;
    int index = 0;
    int number =0;
    Button btnsave;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipe);
        setTitle("MyRecipe");
        final DbHelper dbHelper = new DbHelper(getApplicationContext(), "RECIPE.db", null, 2);




       //dbHelper.deleteTable(1);
        //    dbHelper.deleteAllTable();




        //아이템 삭제 : ex)deleteItem("텐더브리또");

        Log.i("haha","LastOrderNum : " +String.valueOf(dbHelper.getLastOrderNum()));

        listView=(ListView)findViewById(R.id.listview);
        recipeData = dbHelper.getResult();
        adapter = new CustomAdapter(recipeData); //어뎁터 생성

        listView.setAdapter(adapter); // 리스트뷰에 어댑터를 연결





        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);








        listView = (ListView) findViewById(R.id.listview);
        myrecipe= (LinearLayout) findViewById(R.id.myrecipe); //첫번째 화면
        linear2 = (LinearLayout) findViewById(R.id.linear2); //두번째 화면
        memo = (EditText) findViewById(R.id.edittext); //메모칸
        btnsave=(Button) findViewById(R.id.btnsave);

        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Data);


        setPermission();
        createDirectory();
        allFile();


       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try {
                    String path = getExternalPath();
                    BufferedReader br = new BufferedReader(new FileReader(path + "diary/" + Data.get(position)));
                    number = position;
                    index++;
                    String readStr = "";
                    String str = null;
                    while ((str = br.readLine()) != null)
                        readStr += str + " \n";
                    br.close();
                    memo.setText(readStr);
                    myrecipe.setVisibility(View.GONE);
                    linear2.setVisibility(View.VISIBLE);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "File not found", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }




            }



        }); */



    }






    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    };

    public void onClick(View v) {

        if(v.getId()==R.id.add) {
            Intent intent = new Intent(this, Set1.class);
            startActivity(intent);
        }

       else if(v.getId()==R.id.basic) {

            Intent intentst = new Intent(this, MainActivity.class);
            startActivity(intentst);

        }

        else if (v.getId()==R.id.delete){
            final DbHelper dbHelper = new DbHelper(getApplicationContext(), "RECIPE.db", null, 2);
            Log.i("haha","ddddd");

            dbHelper.deleteAllTable();




            Toast.makeText(getApplicationContext(),"초기화 되었습니다",Toast.LENGTH_SHORT).show();
            Intent reintent = new Intent(this, MyRecipe.class);
            startActivity(reintent);
        }




         else if (v.getId() == R.id.btncancel) {
            myrecipe.setVisibility(View.VISIBLE);
            linear2.setVisibility(View.GONE);
            memo.setText("");

        } else if (v.getId() == R.id.btnsave) {
            try {
                if (btnsave.getText().toString() == "수정") {
                    String path = getExternalPath();
                    File file = new File(path + "diary/" + Data.get(number));
                    file.delete();
                    Data.remove(number);
                    adapter.notifyDataSetChanged();
                    index--;
                }

                String path = getExternalPath();
                BufferedWriter bw = new BufferedWriter(new FileWriter(path + "diary/" + Data.get(index), true));
                index++;
                bw.write(memo.getText().toString());
                bw.close();
                Toast.makeText(getApplicationContext(), "저장완료", Toast.LENGTH_SHORT).show();
                linear2.setVisibility(View.GONE);
                myrecipe.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), e.getMessage() + " : " + getFilesDir(), Toast.LENGTH_SHORT).show();
            }

        }







    }









    private void createDirectory() {
        String path1 = getExternalPath();
        File file = new File(path1 + "diary");
        if (!file.isDirectory())
            file.mkdir();
    }



    private void allFile() {
        String path2 = getExternalPath();
        File[] files = new File(path2 + "diary").listFiles();

        String str = "";
        for (File f : files) {
            Data.add(f.getName());
            index++;
        }
    }

   private void setPermission() {
        int permissionInfo = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permissionInfo == PackageManager.PERMISSION_GRANTED){}
          //  Toast.makeText(getApplicationContext(), "SDCard 쓰기 권한 있음", Toast.LENGTH_SHORT).show();
        else { // 재요청
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE))
                Toast.makeText(getApplicationContext(), "권한의 필요성 설명", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
    }

    public String getExternalPath() {
        String sdPath = "";
        String ext = Environment.getExternalStorageState();
        if (ext.equals(Environment.MEDIA_MOUNTED))
            sdPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
        else {
            sdPath = getFilesDir() + "";
            Toast.makeText(getApplicationContext(), sdPath, Toast.LENGTH_SHORT).show();
        }
        return sdPath;
    }


    public void WriteMemo(int num){
        try {
            String path = getExternalPath();
            BufferedWriter bw = new BufferedWriter(new FileWriter(path + "diary/" + Data.get(num), true));
            bw.write("");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getMessage() + " : " + getFilesDir(), Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteMemo(int n){

        index=0;
        String path = getExternalPath();
        File file = new File(path + "diary/" + Data.get(n));
        file.delete();
        Data.remove(n);

    }

}
