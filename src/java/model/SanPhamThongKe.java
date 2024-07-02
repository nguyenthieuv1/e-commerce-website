/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class SanPhamThongKe {
     private int id;
    private String ten;
    private float gia;
    private int soLuongBan;
    private float doanhThu;
    private float khuyenMai;
    private int iddanhMuc;
    private String img1;
    private String danhMuc;

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public float getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(float doanhThu) {
        this.doanhThu = doanhThu;
    }

    public float getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(float khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public int getIddanhMuc() {
        return iddanhMuc;
    }

    public void setIddanhMuc(int iddanhMuc) {
        this.iddanhMuc = iddanhMuc;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    @Override
    public String toString() {
        return "SanPhamThongKe{" + "id=" + id + ", ten=" + ten + ", gia=" + gia + ", soLuongBan=" + soLuongBan + ", doanhThu=" + doanhThu + ", khuyenMai=" + khuyenMai + ", iddanhMuc=" + iddanhMuc + ", img1=" + img1 + '}';
    }
    
    
}
