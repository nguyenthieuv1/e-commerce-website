/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class SanPhamGioHang {
    private String ten;
    private Float gia;
    private  int soLuong;
    private float tongCong;
    private String img1;
    private int id;
    private int iddonhang;

    public int getIddonhang() {
        return iddonhang;
    }

    public void setIddonhang(int iddonhang) {
        this.iddonhang = iddonhang;
    }
    @Override
    public String toString() {
        return "SanPhamGioHang{" + "ten=" + ten + ", gia=" + gia + ", soLuong=" + soLuong + ", tongCong=" + tongCong + ", img1=" + img1 + ", id=" + id + '}';
    }

    
    
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Float getGia() {
        return gia;
    }

    public void setGia(Float gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongCong() {
        return tongCong;
    }

    public void setTongCong(float tongCong) {
        this.tongCong = tongCong;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
