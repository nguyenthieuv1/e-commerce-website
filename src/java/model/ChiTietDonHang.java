/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ChiTietDonHang {
    private String ten;
    private Float giaBan;
    private int soLuong;
    private String danhMuc;
    private String img1;
    private Float tongCong;

    @Override
    public String toString() {
        return "ChiTietDonHang{" + "ten=" + ten + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", danhMuc=" + danhMuc + ", img1=" + img1 + ", tongCong=" + tongCong + '}';
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Float giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public Float getTongCong() {
        return tongCong;
    }

    public void setTongCong(Float tongCong) {
        this.tongCong = tongCong;
    }
    
}
