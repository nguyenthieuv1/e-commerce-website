/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DonHangDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ChiTietDonHang;
import utils.xuLy;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ChiTietDonHang", urlPatterns = {"/admin-chitietdonhang"})
public class AdminChiTietDonHang extends HttpServlet {

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
            out.println("<title>Servlet ChiTietDonHang</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChiTietDonHang at " + request.getContextPath() + "</h1>");
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
            DonHangDAO donHangDAO = new DonHangDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            List<ChiTietDonHang> list = donHangDAO.selectChiTietDonHang(id);
            request.setAttribute("dsctdonhang", list);
            request.setAttribute("tongtien", xuLy.TinhTongDonHang(list));
            request.setAttribute("id", id);
            System.out.println("tong tien: "+xuLy.TinhTongDonHang(list));
            
            request.getRequestDispatcher("admin/chitietdonhang.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminChiTietDonHang.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int numberTrangThai = Integer.parseInt(request.getParameter("trangthai"));
            String trangthString ="";
            if(numberTrangThai==1){
                trangthString="chờ xử lý";
            }
            else if (numberTrangThai == 2) {
                trangthString ="hoàn thành";
            }
            else {
                trangthString ="hủy";
            }
           PrintWriter out = response.getWriter();
           
            DonHangDAO dAO = new DonHangDAO();
            if (dAO.updateTrangThaiDonHang(id, trangthString)) {
                 out.print("cap nhat thanh cong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminChiTietDonHang.class.getName()).log(Level.SEVERE, null, ex);
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
