package com.example.jiwoong.finalexam2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiwoong on 2017. 6. 9..
 */

public class DbHelper extends SQLiteOpenHelper {



    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE RECIPE (id INTEGER PRIMARY KEY AUTOINCREMENT, orderNum INTEGER, menu TEXT, sub_menu TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    //String flag;

    public void createTable(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("CREATE TABLE RECIPE (id INTEGER PRIMARY KEY AUTOINCREMENT, orderNum INTEGER, menu TEXT, sub_menu TEXT);");


    }

    public void deleteTable(Integer flag){


        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM RECIPE WHERE orderNum ="+flag+" ;");
        //  db.execSQL("TRUNCATE TABLE RECIPE");

        //  if(flag.compareTo("drop") == 0){
        //  db.execSQL("DROP TABLE IF EXISTS RECIPE");
        //}
      //  db.execSQL("CREATE TABLE RECIPE (id INTEGER PRIMARY KEY AUTOINCREMENT, orderNum INTEGER, menu TEXT, sub_menu TEXT);");

        //else if(flag.compareTo("delete") == 0){
        //   db.execSQL("DELETE FROM RECIPE");
        //        }
    }

    public  void deleteAllTable(){

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM RECIPE ;");
        db.execSQL("VACUUM ;");

    }

    public void deleteItem(String menu){

        SQLiteDatabase db = getWritableDatabase();

        // DB에 입력한 값으로 행 추가
        db.execSQL("DELETE FROM RECIPE WHERE menu = '" + menu + "'");
        Log.i("haha","insert DONE");
        db.close();
    }

    public void insert(int orderNum, String menu, String sub_menu) {


        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO RECIPE VALUES(null," + orderNum+", '" + menu + "', '" + sub_menu + "');");
        Log.i("haha","insert DONE");

        db.close();
    }

    public ArrayList<RecipeData> getResult() {


        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<RecipeData> recipeData = new ArrayList<RecipeData>(); //레시피데이터를 갖는 어레이 리스트

        Log.i("haha","3a");
        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT orderNum, menu, sub_menu FROM RECIPE", null);
        Log.i("haha","4a");

        while (cursor.moveToNext()) {
            int orderNum = cursor.getInt(0);
            String menu = cursor.getString(1);
            String sub_menu = cursor.getString(2);
            boolean existOrder = false;

            for(int i = 0; i < recipeData.size(); i++){

                if(recipeData.get(i).getOrderNum() == orderNum){
                    existOrder = true;
                    recipeData.get(i).setSubMenu(recipeData.get(i).getSubMenu() + "," + sub_menu);

                }
            }


            if(!existOrder){

                recipeData.add(new RecipeData(orderNum,menu,sub_menu));
            }
        }

        return recipeData;
    }

    public boolean isAlreadyFavorite(String menu){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(menu) FROM RECIPE WHERE menu = '" + menu +"'", null);
        while(cursor.moveToNext()){
            if(cursor.getInt(0) > 0){
                return true;
            }
        }
        return false;
    }


     public int getLastOrderNum(){
         Log.i("haha","d");
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT MAX(orderNum) FROM RECIPE", null);
        if(cursor.moveToNext()){
            return cursor.getInt(0);

        }
        else{
            return 0;
        }


    }
}
