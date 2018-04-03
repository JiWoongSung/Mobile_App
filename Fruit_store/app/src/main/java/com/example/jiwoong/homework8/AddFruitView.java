package com.example.jiwoong.homework8;

/**
 * Created by jiwoong on 2017. 5. 3..
 */

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by OH on 2017-04-27.
 */

public class AddFruitView extends LinearLayout implements View.OnClickListener{
    int itemNum = 0;
    AutoCompleteTextView widget_fruitNameATextView;
    EditText widget_fruitNamePriceEditText;
    ImageView widget_fruitImageView;
    Button widget_nextFruitImageButton;
    Button widget_addButton;


    public AddFruitView(Context context){
        this(context, null);
    }

    public AddFruitView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public void initLayout(Context context) {
        LayoutInflater.from(context).inflate(R.layout.custom_widget, this);

        widget_fruitNameATextView = (AutoCompleteTextView)findViewById(R.id.widget_fruitNameATextView);
        widget_fruitNamePriceEditText = (EditText)findViewById(R.id.widget_fruitNamePriceEditText);
        widget_fruitImageView = (ImageView)findViewById(R.id.widget_fruitImageView);
        widget_nextFruitImageButton = (Button)findViewById(R.id.widget_nextFruitImageButton);
        widget_addButton = (Button)findViewById(R.id.widget_addButton);

        widget_nextFruitImageButton.setOnClickListener(this);
        widget_addButton.setOnClickListener(this);

        widget_fruitNameATextView.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, MainActivity.fruitNames));
    }

    public void setFruit(String name, String price, int image, int position){
        widget_fruitNameATextView.setText(name);
        widget_fruitNamePriceEditText.setText(price);
        widget_fruitImageView.setImageResource(image);
        itemNum = position;
        widget_addButton.setText("M");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.widget_nextFruitImageButton :
                //화살표 눌렀을 때
                itemNum++;
                if (itemNum > 7) itemNum = 0;
                widget_fruitImageView.setImageResource(MainActivity.fruitImages[itemNum]);
                MainActivity.imageNum = MainActivity.fruitImages[itemNum];
                break;
            case R.id.widget_addButton :
                //추가버튼 눌렀을 때
                if (widget_addButton.getText().toString().equals("M")){
                    widget_addButton.setText("ADD");
                    onAddListener.onModify(MainActivity.clickedFruitName, widget_fruitNameATextView.getText().toString(), widget_fruitNamePriceEditText.getText().toString());
                }
                else if(widget_addButton.getText().equals("ADD")) {
                    onAddListener.onAdd(widget_fruitNameATextView.getText().toString(), widget_fruitNamePriceEditText.getText().toString(), MainActivity.imageNum);
                }
                break;



        }
    }

    interface OnAddListener{
        void onAdd(String name, String price, int imgnum);
        void onModify(String clickedName, String name, String price);
    }

    public OnAddListener onAddListener;

    public void setOnAddListener(OnAddListener onAddListener){
        this.onAddListener = onAddListener;
    }
}
