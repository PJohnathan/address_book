package com.example.zhku.classaddresslist;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class Student extends DataSupport implements Serializable {
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

    public Student(){
    }
    public Student(int imageId,String name,String telephone,String address,String zhuanye){
        this.imageId = imageId;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.zhuanye = zhuanye;
    }
}