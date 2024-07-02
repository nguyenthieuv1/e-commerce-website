/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import utils.ChuanHoa;

/**
 *
 * @author Admin
 */
@WebServlet(name = "KhachHangInfor", urlPatterns = {"/khachhang-thongtin"})
public class ThongTinKhachHang extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet KhachHangInfor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet KhachHangInfor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserDAO userDAO = new UserDAO();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int idUser = user.getId();

            request.setAttribute("user", userDAO.selectUserById(idUser));
            request.setAttribute("dschitietsanpham", userDAO.selectAllProductOfCustomer(idUser));
            request.getRequestDispatcher("web/thongtinkhachhang.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ThongTinKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            User user = new User();
            user.setId(Integer.parseInt(request.getParameter("id")));
            user.setTen(request.getParameter("ten"));
            user.setSdt(request.getParameter("sdt"));
            user.setUserName(request.getParameter("username"));
            user.setPassWord(request.getParameter("password"));
            user.setDiaChi(request.getParameter("diachi"));
            user.setDob(ChuanHoa.stringToDate(request.getParameter("dob")));
            UserDAO userDAO = new UserDAO();

            if (userDAO.updateUserById(user)) {
                out.print("cập nhật thành công");
                response.sendRedirect("/demo10/home");
            } 

        } catch (ParseException ex) {
            out.print("cap nhat that bai");
           
            Logger.getLogger(AdminChiTietKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            out.print("cap nhat that bai");
            Logger.getLogger(AdminChiTietKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
