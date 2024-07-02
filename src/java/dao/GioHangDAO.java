/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.protocol.Resultset;
import context.DBcontext;
import java.security.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
import model.SanPhamGioHang;
import model.User;

/**
 *
 * @author Admin
 */
public class GioHangDAO extends DBcontext {

    public List<SanPhamGioHang> selectSanPhamGioHang(int id) throws SQLException {
        String sql = "SELECT sp.img1, sp.ten, sp.khuyenmai AS gia, ct.soluong, \n"
                + "sp.khuyenmai*ct.soluong AS tongcong, ct.id, dh.id as iddonhang\n"
                + "FROM\n"
                + "donhang AS dh\n"
                + "INNER JOIN chitietsanpham AS ct ON ct.iddonhang = dh.id\n"
                + "INNER JOIN user ON ct.iduser = user.id\n"
                + "INNER JOIN sanpham AS sp ON sp.id = ct.idsanpham\n"
                + "WHERE user.id =? AND dh.trangthai ='0'\n"
                + "ORDER BY dh.id DESC\n";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        List<SanPhamGioHang> res = new ArrayList<>();
        while (rs.next()) {
            SanPhamGioHang spgh = new SanPhamGioHang();
            spgh.setId(rs.getInt("id"));
            spgh.setIddonhang(rs.getInt("iddonhang"));
            spgh.setTen(rs.getString("ten"));
            spgh.setGia(rs.getFloat("gia"));
            spgh.setImg1(rs.getString("img1"));
            spgh.setTongCong(rs.getFloat("tongcong"));
            spgh.setSoLuong(rs.getInt("soluong"));
            res.add(spgh);
        }
        return res;
    }

    public boolean deleteSanPhamGioHang(int id) throws SQLException {
        String sql = "delete from chitietsanpham where id =?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        int rs = ps.executeUpdate();

        return rs > 0;
    }

    public boolean datHang(int idUser) throws SQLException {
        String updateOrderSQL = "UPDATE donhang SET trangthai = 'đã đặt', ngaytao = ? WHERE iduser = ? AND trangthai = '0'";
        String insertOrderSQL = "INSERT INTO donhang(trangthai, iduser) VALUES('0', ?)";

        try (PreparedStatement updateOrderStmt = con.prepareStatement(updateOrderSQL); PreparedStatement insertOrderStmt = con.prepareStatement(insertOrderSQL)) {

            // Start transaction
            con.setAutoCommit(false);

            // Current timestamp
            // Current timestamp
            LocalDateTime currentDateTime = LocalDateTime.now();

            // Update existing order
            updateOrderStmt.setObject(1, currentDateTime);
            updateOrderStmt.setInt(2, idUser);
            int updateResult = updateOrderStmt.executeUpdate();

            // Insert new order
            insertOrderStmt.setInt(1, idUser);
            int insertResult = insertOrderStmt.executeUpdate();

            // Commit transaction if both updates are successful
            if (updateResult > 0 && insertResult > 0) {
                con.commit();
                return true;
            } else {
                con.rollback();
                return false;
            }

        } catch (SQLException e) {
            // Rollback transaction in case of error
            con.rollback();
            throw e;
        } finally {
            // Reset auto-commit to true
            con.setAutoCommit(true);
        }
    }

    public boolean themVaoGioHang(User user, int idSP,int soLuong) throws SQLException {
        String sql = "INSERT INTO \n"
                + "chitietsanpham(iduser, iddonhang, idsanpham, soluong)\n"
                + "VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,user.getId());
        ps.setInt(2, user.getIdDonhang());
        ps.setInt(3, idSP);
        ps.setInt(4, soLuong);
        
        int rs = ps.executeUpdate();
        return rs>0;
    }

}
