/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import model.DanhMuc;
import model.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.ChuanHoa;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AdminChiTietSanPham", urlPatterns = {"/chitietsanpham"})
public class AdminChiTietSanPham extends HttpServlet {

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
            out.println("<title>Servlet AdminChiTietSanPham</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminChiTietSanPham at " + request.getContextPath() + "</h1>");
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
            String idSanPham = request.getParameter("id");
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            request.setAttribute("sanpham", sanPhamDAO.getSanPhamByID(Integer.parseInt(idSanPham)));

            request.getRequestDispatcher("admin/chitietsanpham.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminChiTietSanPham.class.getName()).log(Level.SEVERE, null, ex);
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
            String ten = request.getParameter("ten");
            String id = request.getParameter("id");
            String gia = ChuanHoa.removeComma(request.getParameter("gia"));
            String soLuong = request.getParameter("soluong");
            String khuyenMai = ChuanHoa.removeComma(request.getParameter("khuyenmai"));
            String danhmuc = request.getParameter("danhmuc");
            String moTa = request.getParameter("mota");
            String img = "img/" + request.getParameter("hinhanh");
//        System.out.println(img);
            SanPham sanPham = new SanPham();
            sanPham.setId(Integer.parseInt(id));
            sanPham.setTen(ten);
            sanPham.setGia(Float.parseFloat(gia));
            sanPham.setImg1(img);
            sanPham.setSoLuong(Integer.parseInt(soLuong));
            sanPham.setKhuyenMai(Float.parseFloat(khuyenMai));
            sanPham.setMoTa(moTa);
            DanhMuc dm = new DanhMuc();
            dm.setId(Integer.parseInt(danhmuc));
            sanPham.setDanhMuc(dm);
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            System.out.println(sanPham);
            sanPhamDAO.updateSanPham(sanPham);

            response.sendRedirect("/demo10/admin-sanpham");
        } catch (SQLException ex) {
            Logger.getLogger(AdminChiTietSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        if (sanPhamDAO.xoaSanPham(Integer.parseInt(id))) {
            PrintWriter out = resp.getWriter();
            out.print("Xóa sản phẩm thành công");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    } // </editor-fold>

}
