/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBcontext;
import model.DanhMuc;
import model.SanPham;
import model.SanPhamThongKe;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SanPhamDAO extends DBcontext {

    public List<SanPham> selectAllProduct() throws SQLException {
        String sql = "SELECT sanpham.id, sanpham.ten, sanpham.gia,sanpham.soluong, sanpham.khuyenmai,\n"
                + "sanpham.img1, danhmuc.ten AS danhmuc \n"
                + "FROM sanpham\n"
                + "left JOIN danhmuc ON sanpham.iddanhmuc = danhmuc.id";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<SanPham> sanPhams = new ArrayList<>();
        while (rs.next()) {
            SanPham sanPham = new SanPham();
            sanPham.setId(rs.getInt("id"));
            sanPham.setTen(rs.getString("ten"));
            sanPham.setGia(rs.getFloat("gia"));
            sanPham.setSoLuong(rs.getInt("soluong"));
            sanPham.setKhuyenMai(rs.getFloat("khuyenmai"));
            sanPham.setImg1(rs.getString("img1"));

            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setTen(rs.getString("danhmuc"));
            sanPham.setDanhMuc(danhMuc);
            sanPhams.add(sanPham);
        }
        return sanPhams;
    }

    public int numberOfProduct() throws SQLException {
        String sql = "select count(id) as count from sanpham";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("count");
        }
        return 0;
    }

    public List<SanPham> selectProductByPage(int beginNum) throws SQLException {
        String sql = "SELECT sanpham.id, sanpham.ten, sanpham.gia,sanpham.soluong, sanpham.khuyenmai,\n"
                + "sanpham.img1, danhmuc.ten AS danhmuc \n"
                + "FROM sanpham\n"
                + "left JOIN danhmuc ON sanpham.iddanhmuc = danhmuc.id "
                + " LIMIT 12 OFFSET ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, (beginNum - 1) * 12);
        ResultSet rs = ps.executeQuery();
        List<SanPham> sanPhams = new ArrayList<>();
        while (rs.next()) {
            SanPham sanPham = new SanPham();
            sanPham.setId(rs.getInt("id"));
            sanPham.setTen(rs.getString("ten"));
            sanPham.setGia(rs.getFloat("gia"));
            sanPham.setSoLuong(rs.getInt("soluong"));
            sanPham.setKhuyenMai(rs.getFloat("khuyenmai"));
            sanPham.setImg1(rs.getString("img1"));

            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setTen(rs.getString("danhmuc"));
            sanPham.setDanhMuc(danhMuc);
            sanPhams.add(sanPham);
        }
        return sanPhams;
    }

    public int numberOfProductByName(String ten) throws SQLException {
        String sql = "select count(id) as count from sanpham where ten like ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "%"+ten+"%");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("count");
        }
        return 0;
    }

    public List<SanPham> selectProductByName(int beginNum, String ten) throws SQLException {
        String sql = "SELECT sanpham.id, sanpham.ten, sanpham.gia, sanpham.soluong, sanpham.khuyenmai, "
                + "sanpham.img1, danhmuc.ten AS danhmuc "
                + "FROM sanpham "
                + "LEFT JOIN danhmuc ON sanpham.iddanhmuc = danhmuc.id "
                + "WHERE sanpham.ten LIKE ? "
                + "LIMIT 12 OFFSET ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, "%" + ten + "%");
        ps.setInt(2, (beginNum - 1) * 12);
        
        ResultSet rs = ps.executeQuery();
        List<SanPham> sanPhams = new ArrayList<>();
        while (rs.next()) {
            SanPham sanPham = new SanPham();
            sanPham.setId(rs.getInt("id"));
            sanPham.setTen(rs.getString("ten"));
            sanPham.setGia(rs.getFloat("gia"));
            sanPham.setSoLuong(rs.getInt("soluong"));
            sanPham.setKhuyenMai(rs.getFloat("khuyenmai"));
            sanPham.setImg1(rs.getString("img1"));

            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setTen(rs.getString("danhmuc"));
            sanPham.setDanhMuc(danhMuc);
            sanPhams.add(sanPham);
        }
        return sanPhams;
    }

    public SanPham getSanPhamByID(int id) throws SQLException {
        String sql = "SELECT sanpham.id, sanpham.ten,sanpham.gia,sanpham.soluong,\n"
                + "sanpham.khuyenmai,sanpham.img1, sanpham.mota,  danhmuc.ten AS danhmuc\n"
                + "FROM sanpham \n"
                + "left JOIN danhmuc ON sanpham.iddanhmuc = danhmuc.id\n"
                + "where sanpham.id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        SanPham sanPham = new SanPham();
        if (rs.next()) {

            sanPham.setId(rs.getInt("id"));
            sanPham.setTen(rs.getString("ten"));
            sanPham.setGia(rs.getFloat("gia"));
            sanPham.setSoLuong(rs.getInt("soluong"));
            sanPham.setKhuyenMai(rs.getFloat("khuyenmai"));
            sanPham.setImg1(rs.getString("img1"));

            sanPham.setMoTa(rs.getString("mota"));
            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setTen(rs.getString("danhmuc"));
            sanPham.setDanhMuc(danhMuc);
        }
        return sanPham;
    }

    public List<DanhMuc> selectAllDanhMuc() throws SQLException {
        List<DanhMuc> danhMucs = new ArrayList<>();
        String sql = "SELECT * FROM danhmuc";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            DanhMuc danhMuc = new DanhMuc();
            danhMuc.setId(rs.getInt("id"));
            danhMuc.setTen(rs.getString("ten"));
            danhMucs.add(danhMuc);
        }
        return danhMucs;
    }

    public List<SanPhamThongKe> selectSanPhamThongKe(Date begin, Date end, int idDdanhmuc) throws SQLException {
        String sql = "SELECT sanpham.id, sanpham.ten, sanpham.gia,sanpham.khuyenmai ,\n"
                + "sanpham.img1, sum(chitietsanpham.soluong) AS soluongban, \n"
                + "sum(chitietsanpham.soluong)*khuyenmai AS doanhthu\n"
                + "FROM chitietsanpham\n"
                + "inner JOIN sanpham ON chitietsanpham.idsanpham = sanpham.id\n"
                + "inner JOIN donhang ON chitietsanpham.iddonhang = donhang.id\n"
                + "WHERE donhang.trangthai = 'hoàn thành' AND\n"
                + " donhang.ngaytao BETWEEN ? AND ? \n"
                + " AND sanpham.iddanhmuc =? \n"
                + "GROUP BY sanpham.id,sanpham.ten,sanpham.gia,sanpham.khuyenmai,\n"
                + "sanpham.img1";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, new java.sql.Date(begin.getTime()));
        ps.setDate(2, new java.sql.Date(end.getTime()));
        ps.setInt(3, idDdanhmuc);
        ResultSet rs = ps.executeQuery();
        List<SanPhamThongKe> sanPhamThongKesks = new ArrayList<>();

        while (rs.next()) {
            SanPhamThongKe sanPhamThongKe = new SanPhamThongKe();
            sanPhamThongKe.setId(rs.getInt("id"));
            sanPhamThongKe.setTen(rs.getString("ten"));
            sanPhamThongKe.setGia(rs.getFloat("gia"));
            sanPhamThongKe.setSoLuongBan(rs.getInt("soluongban"));
            sanPhamThongKe.setKhuyenMai(rs.getFloat("khuyenmai"));

            sanPhamThongKe.setImg1(rs.getString("img1"));
            sanPhamThongKe.setDoanhThu(rs.getFloat("doanhthu"));
            sanPhamThongKesks.add(sanPhamThongKe);
        }
        return sanPhamThongKesks;
    }

    public void updateSanPham(SanPham sanPham) throws SQLException {
        String sql = "UPDATE sanpham\n"
                + "SET soluong = ?, khuyenmai =? , gia=? , ten =?, iddanhmuc =?, img1=?, mota=?\n"
                + "WHERE id = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, sanPham.getSoLuong());
        ps.setFloat(2, sanPham.getKhuyenMai());
        ps.setFloat(3, sanPham.getGia());
        ps.setString(4, sanPham.getTen());
        int iddanhmuc = sanPham.getDanhMuc().getId();
        if (iddanhmuc == 0) {
            ps.setNull(5, java.sql.Types.INTEGER);
        } else {
            ps.setInt(5, iddanhmuc);
        }
        ps.setString(6, sanPham.getImg1());
        ps.setString(7, sanPham.getMoTa());
        ps.setInt(8, sanPham.getId());
        ps.executeUpdate();

    }

    public boolean xoaSanPham(int id) {
        try {
            String sql = "DELETE FROM sanpham\n"
                    + "WHERE id= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rowDel = ps.executeUpdate();
            return rowDel > 1;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean themSanPham(SanPham sanPham) {
        try {
            String sql = "insert into sanpham(ten, gia, soluong, iddanhmuc, khuyenmai, img1, mota)"
                    + " values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sanPham.getTen());
            ps.setFloat(2, sanPham.getGia());
            ps.setInt(3, sanPham.getSoLuong());
            ps.setInt(4, sanPham.getDanhMuc().getId());
            ps.setFloat(5, sanPham.getKhuyenMai());
            ps.setString(6, sanPham.getImg1());
            ps.setString(7, sanPham.getMoTa());

            int res = ps.executeUpdate();

            return res > 0; // Trả về true nếu có ít nhất một hàng bị ảnh hưởng

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
