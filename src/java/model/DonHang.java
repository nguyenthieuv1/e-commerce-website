/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class DonHang {
    private int id;
    private String tenKhach;
    private int sosanpham;
    private LocalDateTime ngayDat;
    private String sdt;
    private float tongTien;
    private String trangthai;

    @Override
    public String toString() {
        return "DonHang{" + "id=" + id + ", tenKhach=" + tenKhach + ", sosanpham=" + sosanpham + ", ngayDat=" + ngayDat + ", sdt=" + sdt + ", tongTien=" + tongTien + ", trangthai=" + trangthai + '}';
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public int getSosanpham() {
        return sosanpham;
    }

    public void setSosanpham(int sosanpham) {
        this.sosanpham = sosanpham;
    }

    public LocalDateTime getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(LocalDateTime ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    
  
}
