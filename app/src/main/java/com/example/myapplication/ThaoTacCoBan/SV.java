package com.example.myapplication.ThaoTacCoBan;

public class SV {
    private String maSinhVien;
    private String tenSinhVien;
    private String gioiTinh;
    private int namSinh;

    public SV() {
    }

    public SV(String maSinhVien, String tenSinhVien, String gioiTinh, int namSinh) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    @Override
    public String toString() {
        return maSinhVien + " | " + tenSinhVien + " | " + gioiTinh + " | " + namSinh;
    }
}
