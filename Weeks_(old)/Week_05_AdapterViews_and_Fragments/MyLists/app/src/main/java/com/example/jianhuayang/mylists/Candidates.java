package com.example.jianhuayang.mylists;

/**
 * Created by jianhuayang on 22/10/15.
 */
public class Candidates {

    private String name;
    private String detail;
    private int photo;

    public Candidates(String name, String detail, int photo) {
        this.name = name;
        this.detail = detail;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public int getPhoto() {
        return photo;
    }

    @Override
    public String toString() {
        return detail;
    }
}
