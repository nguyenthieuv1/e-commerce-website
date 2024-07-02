/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class User {
    private int id;
    private String ten;
    private String userName;
    private String passWord;
    private String sdt;
    private int isAdmin;
    private String diaChi;
    private Date dob;
    private int idDonhang;

    public Integer getIdDonhang() {
        return idDonhang;
    }

    public void setIdDonhang(int idDonhang) {
        this.idDonhang = idDonhang;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", ten=" + ten + ", userName=" + userName + ", passWord=" + passWord + ", sdt=" + sdt + ", isAdmin=" + isAdmin + ", diaChi=" + diaChi + ", dob=" + dob + ", idDonhang=" + idDonhang + '}';
    }

   

   
   
    
}
