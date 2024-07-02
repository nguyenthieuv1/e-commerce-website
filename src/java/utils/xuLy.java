/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.List;
import model.ChiTietDonHang;
import model.SanPhamGioHang;

/**
 *
 * @author Admin
 */
public class xuLy {
    public static Float TinhTongDonHang(List<ChiTietDonHang> list){
        float sum=0;
        for(ChiTietDonHang ct :list){
            sum+=ct.getTongCong();
//            System.out.println(sum);
        }
        return sum;
    }
     public static Float tinhTongSanPhamGioHang(List<SanPhamGioHang> list){
        float sum=0;
        for(SanPhamGioHang ct :list){
            sum+=ct.getTongCong();
//            System.out.println(sum);
        }
        return sum;
    }
}
