<%-- 
    Document   : header
    Created on : Jun 28, 2024, 8:06:01 AM
    Author     : Admin
--%>

<%@page import="model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>siêu thị điện máy hc</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>  


        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="./css/styles.css" rel="stylesheet" />



        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark fixed-top">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">sieuthidienmay.com</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/demo10/home">Trang chủ</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">Giới thiệu</a></li>
<!--                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Danh mục sản phẩm</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">All Products</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li>-->
                    </ul>

                    <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0" action="/demo10/home">
                        <div class="input-group">
                            <input name="timkiem" class="form-control" type="text" placeholder="Tìm kiếm..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                            <button class="btn btn-primary" id="btnNavbarSearch" type="submit"><i class="fas fa-search"></i></button>
                        </div>
                    </form>


                    <form class="d-flex">
                        <a class="btn btn-outline-light" href="/demo10/giohang">
                            <i class="bi-cart-fill me-1"></i>
                            Giỏ hàng

                        </a>
                    </form>

                    <ul class="navbar-nav ms-auto ms-md-0 me-lg-4 ml-4">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
                               aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                <li>
                                    <%
                                        User user = (User) session.getAttribute("user");
                                        if (user != null) {
                                    %>
                                    <p class="dropdown-item">Welcome, <%= user.getTen()%>!</p>
                                    <%
                                    } else {
                                    %>
                                    <p class="dropdown-item">No user logged in.</p>
                                    <%
                                        }
                                    %>

                                </li>
                                <li>
                                    <hr class="dropdown-divider" />
                                </li>
                                <li><a class="dropdown-item" href="/demo10/login">Đăng nhập</a></li>

                                <li><a class="dropdown-item" href="/demo10/logout">Đăng xuất</a></li>
                                <li><a class="dropdown-item" href="/demo10/dangki">Đăng kí</a></li>
                                <li><a class="dropdown-item" href="/demo10/khachhang-thongtin">Thông tin tài khoản</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
