package com.example.jiwoong.homework8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final static String[] fruitNames = {"Abocado", "Banana", "Cherry", "Cranberry", "Grape", "Kiwi", "Orange", "Wetermelon"};
    final static String[] fruitPrices = {"1000", "2000", "3000", "4000", "5000", "6000", "7000", "8000"};
    final static int[] fruitImages = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry,
            R.drawable.cranberry, R.drawable.grape, R.drawable.kiwi,
            R.drawable.orange, R.drawable.watermelon};
    public static boolean check = false;
    public static int imageNum = R.drawable.abocado; //default image

    ArrayList<String> cartList = new ArrayList<>();
    ArrayList<FruitData> fruitDatas = new ArrayList<>();
    FruitAdapter fruitAdapter;
    GridView gridView;
    AddFruitView addFruitView;
    CheckBox checkBox;

    public static String clickedFruitName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), fruitDatas.get(position).fName, Toast.LENGTH_SHORT).show();
                addFruitView.setFruit(fruitDatas.get(position).fName,
                        fruitDatas.get(position).fPrice,
                        fruitDatas.get(position).fImage,
                        position);
                clickedFruitName = fruitDatas.get(position).fName;
                imageNum = fruitDatas.get(position).fImage;
                cartList.add(fruitDatas.get(position).fName);
            }
        });
        init();
    }

    public void init() {
        for (int i = 0; i < 8; i++)
            fruitDatas.add(new FruitData(fruitNames[i], fruitPrices[i], fruitImages[i]));
        fruitAdapter = new FruitAdapter(this, fruitDatas);
        gridView.setAdapter(fruitAdapter);

        addFruitView = (AddFruitView) findViewById(R.id.addfruit);
        addFruitView.setOnAddListener(new AddFruitView.OnAddListener() {
            @Override
            public void onAdd(String name, String price, int imgnum) {
                imageNum = imgnum;
                fruitDatas.add(new FruitData(name, price, imgnum));
                fruitAdapter.notifyDataSetChanged();
            }

            @Override
            public void onModify(String clickedFname, String changedName, String changedPrice) {
                for(FruitData fruitData : fruitDatas){
                    if(fruitData.getfName().equals(clickedFname)){
                        fruitData.setfName(changedName);
                        fruitData.setfPrice(changedPrice);
                        fruitAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.checkBox:
                if (checkBox.isChecked())
                    check = true;
                else
                    check = false;
                fruitAdapter.notifyDataSetChanged();
                break;
            case R.id.button:
                Toast.makeText(getApplicationContext(), "카트에 " + showCartList() + " 가 담겨있습니다.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public String showCartList() {
        String cartData = "";
        for (int i = 0; i < cartList.size(); i++){
            if(i == (cartList.size() - 1)){
                cartData += cartList.get(i).toString() ;
            }
            else{
                cartData += cartList.get(i).toString()+", ";
            }
        }
        return cartData;
    }

}