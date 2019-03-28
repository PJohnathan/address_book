package com.example.zhku.classaddresslist;

import org.litepal.crud.DataSupport;

public class Student extends DataSupport {
    private String name;
    private int imageId;
    private String telephone;
    private String address;
    private String zhuanye;

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getZhuanye() {
        return zhuanye;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZhuanye(String zhuanye) {
        this.zhuanye = zhuanye;
    }
}
