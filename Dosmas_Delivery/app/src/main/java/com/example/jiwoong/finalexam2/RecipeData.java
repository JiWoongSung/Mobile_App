package com.example.jiwoong.finalexam2;

import android.graphics.drawable.Drawable;

/**
 * Created by jiwoong on 2017. 6. 8..
 */

public class RecipeData {



    private String burito;
    private String subMenu;
    private int orderNum;

    public RecipeData(int orderNum, String burito, String subMenu){
        this.orderNum = orderNum;
        this.burito = burito ;
        this.subMenu = subMenu;

    }
    public String getBurito() {
        return burito;
    }

    public void setBurito(String burito) {
        this.burito = burito;
    }

    public String getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String subMenu) {
        this.subMenu = subMenu;
    }

    public int getOrderNum(){
        return orderNum;
    }

    public void setOrderNum(int orderNum){
        this.orderNum = orderNum;
    }




}
