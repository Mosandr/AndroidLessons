package com.example.recyclerview;

public class RecycleViewItem {

    private int imageRecource;
    private String text1;
    private String text2;

    public RecycleViewItem(int imageRecource, String text1, String text2) {
        this.imageRecource = imageRecource;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getImageRecource() {
        return imageRecource;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }
}
