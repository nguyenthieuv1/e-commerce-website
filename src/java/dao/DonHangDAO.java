/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBcontext;
import java.security.Timestamp;
import model.DonHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietDonHang;

/**
 *
 * @author Admin
 */
public class DonHangDAO extends DBcontext {

    public List<DonHang> selectDonHangChoXuLy(String trangThai) throws SQLException {
        String sql = "SELECT user.ten, user.sdt, SUM(ct.soluong) AS soluongsanpham,\n"
                + "dh.ngaytao, SUM(sanpham.khuyenmai*ct.soluong) AS tongtien,dh.id\n"
                + "FROM donhang AS dh\n"
                + "INNER JOIN chitietsanpham as ct ON dh.id = ct.iddonhang\n"
                + "INNER JOIN user ON user.id = ct.iduser\n"
                + "INNER JOIN sanpham ON sanpham.id = ct.idsanpham\n"
                + "WHERE dh.trangthai =?\n"
                + "GROUP BY user.ten, user.sdt,dh.ngaytao,dh.id";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, trangThai);
        ResultSet rs = ps.executeQuery();
        
        List<DonHang> donHangs = new ArrayList<>();
        while (rs.next()) {

            DonHang donhang = new DonHang();
            donhang.setId(rs.getInt("id"));
            donhang.setTenKhach(rs.getString("ten"));
            donhang.setSosanpham(rs.getInt("soluongsanpham"));
            donhang.setSdt(rs.getString("sdt"));
            java.sql.Timestamp timestamp = rs.getTimestamp("ngaytao");
            if (timestamp != null) {
                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                donhang.setNgayDat(localDateTime); // Hoặc sử dụng rs.getDate("ngaytao") nếu dùng java.util.Date
            }

            donhang.setTongTien(rs.getFloat("tongtien"));

            donHangs.add(donhang);
        }
        return donHangs;
    }

    public List<ChiTietDonHang> selectChiTietDonHang(int id) throws SQLException {
        List<ChiTietDonHang> chiTietDonHangs = new ArrayList<>();
        String sql = "SELECT sp.ten, sp.khuyenmai as giaban, ct.soluong, dm.ten AS danhmuc, \n"
                + "sp.img1, sp.khuyenmai*ct.soluong AS tongcong\n"
                + "FROM chitietsanpham AS ct\n"
                + "INNER JOIN sanpham AS sp ON sp.id = ct.idsanpham\n"
                + "INNER JOIN donhang AS dh ON ct.iddonhang = dh.id\n"
                + "INNER JOIN danhmuc AS dm ON sp.iddanhmuc = dm.id\n"
                + "WHERE dh.id =?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ChiTietDonHang ctdh = new ChiTietDonHang();
            ctdh.setTen(rs.getString("ten"));
            ctdh.setDanhMuc(rs.getString("danhmuc"));
            ctdh.setGiaBan(rs.getFloat("giaban"));
            ctdh.setImg1(rs.getString("img1"));
            ctdh.setSoLuong(rs.getInt("soluong"));
            ctdh.setTongCong(rs.getFloat("tongcong"));
            chiTietDonHangs.add(ctdh);
        }
        return chiTietDonHangs;
    }

    public boolean updateTrangThaiDonHang(int id, String trangThai) throws SQLException {
        String sql = "update donhang set trangthai=? where id =?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, trangThai);
        ps.setInt(2, id);
        int rs = ps.executeUpdate();

        return rs > 0;
    }
}
