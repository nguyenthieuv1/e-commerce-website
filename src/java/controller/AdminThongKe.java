/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import model.SanPham;
import model.SanPhamThongKe;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "adminController", urlPatterns = {"/admin"})
public class AdminThongKe extends HttpServlet {

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
            out.println("<title>Servlet adminController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminController at " + request.getContextPath() + "</h1>");
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
        SanPhamDAO sanPhamDAO = new SanPhamDAO();

        try {
            // set danhmuc  
            request.setAttribute("dsdanhmuc", sanPhamDAO.selectAllDanhMuc());

            // lay param gui ve
            String begin = request.getParameter("begin");
            String end = request.getParameter("end");
            String iddm = request.getParameter("iddanhmuc");
            System.out.println(begin+" "+end+" "+iddm);
            if (iddm != "" && begin != "" && end != "" && iddm!=null && begin!=null && end!=null ) {
                int idDanhMuc = Integer.parseInt(iddm);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date beginDate = null;
                Date endDate = null;
                try {

                    beginDate = formatter.parse(begin);
                    endDate = formatter.parse(end);

                } catch (ParseException ex) {
                    Logger.getLogger(AdminThongKe.class.getName()).log(Level.SEVERE, null, ex);
                }
                List<SanPhamThongKe> sanPhamThongKes = sanPhamDAO.selectSanPhamThongKe(beginDate, endDate, idDanhMuc);
                request.setAttribute("sanphamthongkes", sanPhamThongKes);
            }

            request.getRequestDispatcher("admin/thongke.jsp").forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
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

//        try {
//
//            SanPhamDAO sanPhamDAO = new SanPhamDAO();
//            String begin = request.getParameter("begin");
//            String end = request.getParameter("end");
//            int idDanhMuc = Integer.parseInt(request.getParameter("iddanhmuc"));
//
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            Date beginDate = null;
//            Date endDate = null;
//            try {
//
//                beginDate = formatter.parse(begin);
//                endDate = formatter.parse(end);
//
//            } catch (ParseException ex) {
//                Logger.getLogger(adminHomeController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            List<SanPhamThongKe> sanPhamThongKes = sanPhamDAO.selectSanPhamThongKe(beginDate, endDate, idDanhMuc);
//            for (SanPhamThongKe item : sanPhamThongKes) {
//                out.println("<tr>\n"
//                        + "                       \n"
//                        + "                        <td>" + item.getTen() + "</td>\n"
//                        + "                        <td><fmt:formatNumber value=" + item.getGia() + " /> <span>đ</span></td>\n"
//                        + "                         <td><fmt:formatNumber value=" + item.getKhuyenMai() + " /> <span>đ</span></td>\n"
//                        + "                         <td><img src=" + item.getImg1() + " width=\"100px\" height=\"60px\" alt=\"anh\"/></td>\n"
//                        + "                          <td>" + item.getSoLuongBan() + "</td>\n"
//                        + "                          <td>" + item.getDoanhThu() + "</td>\n"
//                        + "                       \n"
//                        + "                        </tr>");
//            }
//
//            out.close();
////         request.getRequestDispatcher("admin/thongke.jsp").forward(request, response);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(adminHomeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
