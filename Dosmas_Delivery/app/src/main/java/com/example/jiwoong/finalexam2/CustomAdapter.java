package com.example.jiwoong.finalexam2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jiwoong on 2017. 6. 8..
 */

public class CustomAdapter extends BaseAdapter{

    private ArrayList<RecipeData> recipeDatas = new ArrayList<RecipeData>();

    public CustomAdapter(ArrayList<RecipeData> recipeDatas) {
        this.recipeDatas = recipeDatas;
    }

    public int getCount() {
        return recipeDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //Adapter에서 사용할 itemLayOut 선언
            convertView = inflater.inflate(R.layout.activity_custom_adaper , parent, false);
        }

        TextView titleTextView = (TextView) convertView.findViewById(R.id.adaptertext);
        RecipeData tmprecipedata = recipeDatas.get(position);

        titleTextView.setText("이름 : " + tmprecipedata.getBurito() + "\n옵션 : " + tmprecipedata.getSubMenu());
        return convertView;
    }






    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(int orderNum, String title,String subMenu) {
        RecipeData item = new RecipeData(orderNum,title,subMenu);
        recipeDatas.add(item);
    }
}



