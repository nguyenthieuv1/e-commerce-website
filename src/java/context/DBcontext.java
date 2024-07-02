/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class DBcontext {
    protected Connection con;
    public DBcontext() {
        if (con==null) {
             String DB_URL = "jdbc:mysql://localhost:3306/web_ban_hang_6_day";
             try {
                // Ensure MySQL JDBC driver is loaded
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(DB_URL, "root", "");
                System.out.println("ket noi thanh cong");
            } catch (ClassNotFoundException ex) {
                System.out.println("MySQL JDBC Driver not found");
                Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                System.out.println("ket noi that bai");
                Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
  
}
