/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DonHangDAO;
import dao.GioHangDAO;
import dao.UserDAO;
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
import javax.servlet.http.HttpSession;
import model.SanPhamGioHang;
import model.User;
import utils.xuLy;

/**
 *
 * @author Admin
 */
@WebServlet(name = "GioHang", urlPatterns = {"/giohang"})
public class GioHang extends HttpServlet {

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
            out.println("<title>Servlet GioHang</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GioHang at " + request.getContextPath() + "</h1>");
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
            HttpSession session = request.getSession();
            int id = 0;
            User user = (User) session.getAttribute("user");
            if (user != null) {
                id = user.getId();
            }
            GioHangDAO gioHangDAO = new GioHangDAO();
            List<SanPhamGioHang> list = gioHangDAO.selectSanPhamGioHang(id);
            request.setAttribute("tongtien", xuLy.tinhTongSanPhamGioHang(list));
            request.setAttribute("dssanpham", list);
            request.setAttribute("idUser", id);
            request.getRequestDispatcher("web/giohang.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
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
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int idSP = Integer.parseInt(request.getParameter("idsp"));
            String soLuongString = request.getParameter("soluong");
            int soLuong=1;
            if (soLuongString!="" && soLuongString!= null) {
                soLuong = Integer.parseInt(soLuongString);
            }
            System.out.println(user+"; "+idSP+"; "+soLuong);
            GioHangDAO ghdao = new GioHangDAO();
            if (ghdao.themVaoGioHang(user, idSP, soLuong)) {
                response.sendRedirect("/demo10/giohang");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            String idString = req.getParameter("id");
            int id = 0;
            System.out.println("idString: " + idString);
            if (idString != null && idString != "") {
                id = Integer.parseInt(idString);
            }
            System.out.println(id);
            GioHangDAO ghdao = new GioHangDAO();
            if (ghdao.deleteSanPhamGioHang(id)) {

                out.print("xoa thanh cong");
            }
        } catch (SQLException ex) {
            out.print("Xóa sản phẩm that bai");
            Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    // dat hang
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            GioHangDAO ghdao = new GioHangDAO();
            String idString = req.getParameter("id");
            int id = 0;
            System.out.println("idString: " + idString);
            if (idString != null && idString != "") {
                id = Integer.parseInt(idString);
            }
            if (ghdao.datHang(id)) {
                out.print("thanh cong");
            }
        } catch (SQLException ex) {
            out.print("that bai");
            Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
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
