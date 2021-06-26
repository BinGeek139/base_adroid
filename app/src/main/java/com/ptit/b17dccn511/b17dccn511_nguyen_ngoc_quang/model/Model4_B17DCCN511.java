package com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.model;

public class Model4_B17DCCN511 {
    private Integer id;
    private String text1;
    private String text2;
    private String text3;
    private String text4;

    public Model4_B17DCCN511(Integer id, String text1, String text2, String text3, String text4) {
        this.id = id;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
    }

    public Model4_B17DCCN511(String text1, String text2, String text3, String text4) {
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }
    @Override
    public String toString() {
        return text1 + " "+ text2+" "+text3+" "+text4;
    }
}
