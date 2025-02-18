/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.SanPhamDAO;
import model.SanPham;
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

/**
 *
 * @author Admin
 */
@WebServlet(name = "webController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet webController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet webController at " + request.getContextPath() + "</h1>");
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

            String pageNumString = request.getParameter("page");
            int pageNum = 1;
            int endPoint = 1;
            int num = 1;
            if (pageNumString != null && !pageNumString.equals("")) {
                pageNum = Integer.parseInt(pageNumString);
            }

            String searchKey = request.getParameter("timkiem");
            if (searchKey != null && !searchKey.equals("")) {
                
                
                System.out.println(searchKey);
                
                List<SanPham> sanPhams = sanPhamDAO.selectProductByName(pageNum,searchKey);
                num = sanPhamDAO.numberOfProductByName(searchKey); //
                request.setAttribute("dssanpham", sanPhams);//
            } else {
                List<SanPham> sanPhams = sanPhamDAO.selectProductByPage(pageNum); //
                num = sanPhamDAO.numberOfProduct(); //
                request.setAttribute("dssanpham", sanPhams);//
            }

            endPoint = num / 12;
            if (num % 12 != 0) {
                endPoint++;
            }

            request.setAttribute("page", pageNum);
            request.setAttribute("endPoint", endPoint);

            request.getRequestDispatcher("/web/homepage.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
//        request.getRequestDispatcher("web/homepage.jsp").forward(request, response);
//        request.getRequestDispatcher("web/homepage.jsp").forward(request, response);
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
        processRequest(request, response);
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
