package com.example.myapplication.module;

public class sinhvien {
    private int hinh;
    private String ten;

    public sinhvien() {
    }

    public sinhvien(int hinh, String ten) {
        this.hinh = hinh;
        this.ten = ten;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
