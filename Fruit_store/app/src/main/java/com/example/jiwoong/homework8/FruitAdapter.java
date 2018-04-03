package com.example.jiwoong.homework8;

/**
 * Created by jiwoong on 2017. 5. 3..
 */
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by OH on 2017-04-27.
 */

public class FruitAdapter extends BaseAdapter {
    Context context;
    ArrayList<FruitData> fruitDatas;


    public FruitAdapter(Context context, ArrayList<FruitData> fruitDatas) {
        this.context = context;
        this.fruitDatas = fruitDatas;
    }

    @Override
    public int getCount() {
        return fruitDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return fruitDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
        ImageView fruitImageView = (ImageView)convertView.findViewById(R.id.fruitImageView);
        TextView fruitNameTextView = (TextView)convertView.findViewById(R.id.fruitNameTextView);
        TextView fruitPriceTextView = (TextView)convertView.findViewById(R.id.fruitPriceTextView);

        fruitImageView.setImageResource(fruitDatas.get(position).fImage);
        fruitNameTextView.setText(fruitDatas.get(position).fName);
        fruitPriceTextView.setText(fruitDatas.get(position).fPrice + "원");

        if (MainActivity.check == false)
            fruitPriceTextView.setVisibility(View.INVISIBLE);
        else
            fruitPriceTextView.setVisibility(View.VISIBLE);

        return convertView;
    }
}