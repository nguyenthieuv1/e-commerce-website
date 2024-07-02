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
@WebServlet(name = "AdminSanPhamMoi", urlPatterns = {"/sanphammoi"})
public class AdminSanPhamMoi extends HttpServlet {

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
            out.println("<title>Servlet AdminSanPhamMoi</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminSanPhamMoi at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("admin/sanphammoi.jsp").forward(request, response);
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
         String ten = request.getParameter("ten");
            
            String gia = ChuanHoa.removeComma(request.getParameter("gia"));
            if(gia== null || gia ==""){
                gia="0";
            }
            String soLuong = request.getParameter("soluong");
            if(soLuong== null || soLuong ==""){
                soLuong="0";
            }
            String khuyenMai = ChuanHoa.removeComma(request.getParameter("khuyenmai"));
            
            if(khuyenMai== null || khuyenMai ==""){
                khuyenMai="0";
            }
            String danhmuc = request.getParameter("danhmuc");
            String moTa = request.getParameter("mota");
            String img = "img/" + request.getParameter("hinhanh");
//        System.out.println(img);
            SanPham sanPham = new SanPham();
            
            sanPham.setTen(ten);
            sanPham.setGia(Float.parseFloat(gia));
            sanPham.setImg1(img);
            sanPham.setSoLuong(Integer.parseInt(soLuong));
            sanPham.setKhuyenMai(Float.parseFloat(khuyenMai));
            sanPham.setMoTa(moTa);
            System.out.println(sanPham);
            DanhMuc dm = new DanhMuc();
            dm.setId(Integer.parseInt(danhmuc));
            sanPham.setDanhMuc(dm);
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            if (sanPhamDAO.themSanPham(sanPham)) {
                  response.sendRedirect("/demo10/admin-sanpham");
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
