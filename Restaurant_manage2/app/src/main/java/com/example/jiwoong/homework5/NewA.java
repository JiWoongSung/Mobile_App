package com.example.jiwoong.homework5;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.example.jiwoong.homework5.R.drawable.chichen;
import static com.example.jiwoong.homework5.R.drawable.hamburger;
import static com.example.jiwoong.homework5.R.drawable.pizza;

/**
 * Created by jiwoong on 2017. 4. 13..
 */

public class NewA extends BaseAdapter {


    TextView t1;
    TextView t2;
    ImageView i1;
    CheckBox checkBox;

    ArrayList<food> data = new ArrayList<food>();
    Context context;
    boolean delBtn;

    ArrayList<Integer> deleteList;

    public NewA(Context context, ArrayList<food> data, boolean delBtn) {
        this.context = context;
        this.data = data;
        this.delBtn = delBtn;
        deleteList = new ArrayList<Integer>();
    }

    public void setDelBtn(boolean delBtn) {
        this.delBtn = delBtn;
    }
    public ArrayList<Integer> getDeleteList() {
        return deleteList;
    }

    public void setData(ArrayList<food> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listlayout, null);

        }

         t1 = (TextView) convertView.findViewById(R.id.name);
         t2 = (TextView) convertView.findViewById(R.id.tel22);
         i1 = (ImageView) convertView.findViewById(R.id.imageView);
        checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckBox current = (CheckBox) buttonView;
//                Log.i("check",current.getTag().toString());
                if(isChecked) {

                    deleteList.add(Integer.parseInt(current.getTag().toString()));
                } else {

                    deleteList.remove(Integer.parseInt(current.getTag().toString()));
                }
            }
        });

        checkBox.setTag(position);



        food one = data.get(position);


         t1.setText(one.getname());
         t2.setText(one.getTel());

        if(one.getRadio().equals("chicken")){
            i1.setImageResource(chichen);

        }
        else if(one.getRadio().equals("pizza")){
            i1.setImageResource(pizza);

        }
        else if(one.getRadio().equals("hamburger")){
            i1.setImageResource(hamburger);

        }

        if(delBtn) {
            checkBox.setVisibility(View.VISIBLE);
        } else {
            checkBox.setChecked(false);
            checkBox.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }




}
