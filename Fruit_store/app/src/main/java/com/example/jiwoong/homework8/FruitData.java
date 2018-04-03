package com.example.jiwoong.homework8;

/**
 * Created by jiwoong on 2017. 5. 3..
 */
public class FruitData {
    String fName;
    String fPrice;
    int fImage;

    public FruitData (String fName, String fPrice, int fImage){
        this.fName = fName;
        this.fPrice = fPrice;
        this.fImage = fImage;
    }

    public String getfPrice() {
        return fPrice;
    }

    public void setfPrice(String fPrice) {
        this.fPrice = fPrice;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getfImage() {
        return fImage;
    }

    public void setfImage(int fImage) {
        this.fImage = fImage;
    }


}