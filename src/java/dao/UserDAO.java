/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBcontext;
import model.ChiTietSanPham;
import model.DonHang;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import utils.ChuanHoa;

/**
 *
 * @author Admin
 */
public class UserDAO extends DBcontext {

    public List<User> selectAllUser() throws SQLException {
        String sql = "select * from user";
        List<User> users = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setTen(rs.getString("ten"));
            user.setUserName(rs.getString("username"));
            user.setPassWord(rs.getString("password"));
            user.setDiaChi(rs.getString("diachi"));
            user.setDob(rs.getDate("dob"));
            user.setIsAdmin(rs.getInt("isadmin"));
            user.setSdt(rs.getString("sdt"));
            users.add(user);
        }
        return users;

    }

    public List<ChiTietSanPham> selectAllProductOfCustomer(int idUser) throws SQLException {
        String sql = "SELECT sp.ten, ct.soluong, sp.khuyenmai as giaban, donhang.ngaytao as ngaymua,donhang.trangthai, \n"
                + "sp.img1, ct.soluong*sp.khuyenmai AS tongtien\n"
                + "FROM \n"
                + "chitietsanpham as ct\n"
                + "INNER JOIN sanpham  as sp ON sp.id = ct.idsanpham\n"
                + "INNER JOIN user  ON user.id = ct.iduser\n"
                + "INNER JOIN donhang ON donhang.id = ct.iddonhang\n"
                + "WHERE user.id = ? \n"
                + "order by  ngaymua desc";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idUser);
        ResultSet rs = ps.executeQuery();
        List<ChiTietSanPham> res = new ArrayList<>();
        while (rs.next()) {
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();

            chiTietSanPham.setTen(rs.getString("ten"));
            chiTietSanPham.setGia(rs.getFloat("giaban"));
//            chiTietSanPham.setNgayMua(rs.getDate("ngaymua"));

            java.sql.Timestamp timestamp = rs.getTimestamp("ngaymua");
            if (timestamp != null) {
                LocalDateTime localDateTime = timestamp.toLocalDateTime();
                chiTietSanPham.setNgayMua(localDateTime); // Hoặc sử dụng rs.getDate("ngaytao") nếu dùng java.util.Date
            }
            chiTietSanPham.setSoLuong(rs.getInt("soluong"));
            chiTietSanPham.setTongTien(rs.getFloat("tongtien"));
            chiTietSanPham.setImg1(rs.getString("img1"));
            chiTietSanPham.setTrangThai(rs.getString("trangthai"));
            System.out.println(chiTietSanPham);
            res.add(chiTietSanPham);
        }
        return res;
    }

    public User selectUserById(int idUser) throws SQLException {
        String sql = "select * from user where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idUser);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setId(idUser);
            user.setTen(rs.getString("ten"));
            user.setUserName(rs.getString("username"));
            user.setPassWord(rs.getString("password"));
            user.setDiaChi(rs.getString("diachi"));
            user.setDob(rs.getDate("dob"));
            user.setIsAdmin(rs.getInt("isadmin"));
            user.setSdt(rs.getString("sdt"));
            return user;
        }
        return null;
    }

    public boolean updateUserById(User user) throws SQLException {
        String sql = "update user set username=?, password=?, sdt=?, diachi=?, ten=?, dob=?"
                + "where id =?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassWord());
        ps.setString(3, user.getSdt());
        ps.setString(4, user.getDiaChi());
        ps.setString(5, user.getTen());
        ps.setDate(6, ChuanHoa.toSQLdate(user.getDob()));
        ps.setInt(7, user.getId());
        int res = ps.executeUpdate();

        return res > 0;
    }

    public boolean deleteUserById(int id) throws SQLException {
        String sql = "delete from user where id =?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        int res = ps.executeUpdate();

        return res > 0;
    }

    public User checkLogIn(User user) throws SQLException {
        String sql = "select u.id, u.isadmin, u.ten "
                + "from user as u "
                + "where u.username =? and u.password =? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassWord());

        ResultSet rs = ps.executeQuery();
        User auUser = new User();
        if (rs.next()) {
            auUser.setId(rs.getInt("id"));
            auUser.setIsAdmin(rs.getInt("isadmin"));
            auUser.setTen(rs.getString("ten"));

            return auUser;
        }

        return null;
    }

    public int insertDonHang(int idUser) throws SQLException {

        String insertNewDonHang = "INSERT INTO donhang(trangthai, iduser) VALUES('0', ?)";
        String selectDonHang = "select * from donhang where iduser =? and trangthai ='0' ";
        try (PreparedStatement ps1 = con.prepareStatement(selectDonHang); PreparedStatement ps2 = con.prepareStatement(insertNewDonHang)) {
            
            ps1.setInt(1, idUser);
            ps2.setInt(1, idUser);
            int rs2 = ps2.executeUpdate();
            if (rs2 > 0) {
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    return rs1.getInt("id");
                }
                
            }
        } catch (SQLException e) {
            // Rollback transaction in case of error
            
            throw e;
        }
        return 0;
    }
    public boolean insertNewUser(User user) throws SQLException{
        String sql = "insert into user(username, password, sdt, diachi, ten, dob) "
                +" values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getPassWord());
        ps.setString(3, user.getSdt());
        ps.setString(4, user.getDiaChi());
        ps.setString(5, user.getTen());
        ps.setDate(6, ChuanHoa.toSQLdate(user.getDob()));
        
        int rs = ps.executeUpdate();
        return rs>0;
    }
}
