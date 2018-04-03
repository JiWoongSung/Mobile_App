package com.example.jiwoong.homework4;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jiwoong on 2017. 4. 4..
 */

public class A {
    private String tablename;
    private String time;
    private int s;
    private int p;
    private int membershipType;
    private int price;





    public A(int s, int p){
        this.s = s;
        this.p = p;

    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getTime() {
        return time;
    }

    public void setTime() {
        this.time = times();
    }

    public void setS(int s){
        this.s = s;
    }

    public int getS(){
        return s;
    }

    public void setP(int p){
        this.p = p;
    }

    public int getP(){
        return p;
    }

    public String toString(){
        return getS() + " " + getP();
    }


    public int getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(int membershipType) {
        this.membershipType = membershipType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private String times() {

        long now = System.currentTimeMillis();
        // 현재시간을 date 변수에 저장한다.
        Date date = new Date(now);
        // 시간을 나타냇 포맷을 정한다 ( yyyy/MM/dd 같은 형태로 변형 가능 )
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // nowDate 변수에 값을 저장한다.
        String formatDate = sdfNow.format(date);

            return formatDate;
    }



}
