package com.example.jiwoong.homework5;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jiwoong on 2017. 4. 6..
 */

public class food implements Parcelable
{
    private String name;
    private String tel;
    private String menu1;
    private String menu2;
    private String menu3;
    private String website;
    private String radio;

    public food(String name, String tel ,String menu1, String menu2, String menu3, String website, String radio){
        this.name = name;
        this.tel= tel;
        this.menu1=menu1;
        this.menu2=menu2;
        this.menu3=menu3;
        this.website=website;
        this.radio= radio;


    }

    protected food(Parcel in) {
        name = in.readString();
        tel = in.readString();
        menu1 = in.readString();
        menu2 = in.readString();
        menu3 = in.readString();
        website = in.readString();
        radio= in.readString();

    }

    public static final Creator<food> CREATOR = new Creator<food>() {
        @Override
        public food createFromParcel(Parcel in) {
            return new food(in);
        }

        @Override
        public food[] newArray(int size) {
            return new food[size];
        }
    };

    public String getname(){
        return name;
    }
    public String getMenu1() {return  menu1;}
    public String getMenu2() {return  menu2;}
    public String getMenu3() {return  menu3;}
    public String getWebsite() {return  website;}
    public String getTel(){ return tel;}
    public String getRadio() {return radio; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(menu1);
        dest.writeString(menu2);
        dest.writeString(menu3);
        dest.writeString(website);
        dest.writeString(tel);
        dest.writeString(radio);

    }

    @Override
    public String toString() {
        return "food{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", menu1='" + menu1 + '\'' +
                ", menu2='" + menu2 + '\'' +
                ", menu3='" + menu3 + '\'' +
                ", website='" + website + '\'' +
                ", radio='" + radio + '\'' +
                '}';
    }
}
