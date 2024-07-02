<%-- 
    Document   : thongke
    Created on : Jun 28, 2024, 8:20:18 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="menu.jsp" %>


<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Doanh thu</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">Thống kê doanh thu</li>
            </ol>
            <div class="row">
                <!-- card -->
            </div>
            <div class="row">
                <!-- chart -->
<!--                <div class="col-lg-6">
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-chart-pie me-1"></i>
                            Pie Chart Example
                        </div>
                        <div class="card-body"><canvas id="myPieChart" width="100%" height="50"></canvas></div>
                        <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                    </div>
                </div>-->
                <div class="col-lg-6">
                    <h5>Chọn thời gian thống kê</h5>
                    <form action="/demo10/admin" method="get" id="formthongke">
                        <div class="form-group">
                            <label for="batdauthongke">Ngày bắt đầu</label>
                            <input type="date" id="batdauthongke" name="begin" class="form-control">
                        </div>
                        <div class="form-group mt-3">
                            <label for="ketthucthongke">Ngày kết thúc</label>
                            <input type="date" id="ketthucthongke" name="end" class="form-control">                                    
                        </div>

                        <label for="danhmuc">Danh mục sản phẩm</label>
                        <select name="iddanhmuc" class="custom-select mb-3" id="danhmuc">

                            <c:forEach items="${dsdanhmuc}" var="danhmuc">
                                <option value="${danhmuc.id}">${danhmuc.ten}</option>
                            </c:forEach>
                        </select>

                        <input type="submit" value="Thống kê" class="btn btn-primary mt-3 mb-2">
                    </form>
                </div>
            </div>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    Top sản phẩm có danh thu cao nhất
                </div>
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                            <tr>

                                <th>Tên</th>
                                <th>Giá</th>
                                <th>Khuyến mãi</th>
                                <th>Hình ảnh</th>
                                <th>Số lượng bán</th>
                                <th>Doanh thu</th>

                            </tr>
                        </thead>
                        <tfoot>
                            <tr>

                                <th>Tên</th>
                                <th>Giá</th>
                                <th>Khuyến mãi</th>
                                <th>Hình ảnh</th>
                                <th>Số lượng bán</th>
                                <th>Doanh thu</th>

                            </tr>
                        </tfoot>
                        <tbody id="table-sanphamthongke">
                                                   <c:forEach items="${sanphamthongkes}" var = "sanpham">
                                                       <tr>
                       
                                                          <td>${sanpham.ten}</td>
                                                           <td><fmt:formatNumber value="${sanpham.gia}" /> <span>đ</span></td>
                                                           
                                                           <td><fmt:formatNumber value="${sanpham.khuyenMai}" /> <span>đ</span></td>
                                                           <td><img src="${sanpham.img1}" style="max-height: 80px; max-width: 100px;" alt="anh"/></td>
                                                           <td>${sanpham.soLuongBan}</td>
                                                           <td><fmt:formatNumber value="${sanpham.doanhThu}" /> <span>đ</span></td>
                                                       </tr>
                                                   </c:forEach> 

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </main>
    <footer class="py-4 bg-light mt-auto">
        <div class="container-fluid px-4">
            <div class="d-flex align-items-center justify-content-between small">
                <div class="text-muted">Copyright &copy; Thieu Nguyen 2024</div>
                <div>
                    <a href="#">Privacy Policy</a>
                    &middot;
                    <a href="#">Terms &amp; Conditions</a>
                </div>
            </div>
        </div>
    </footer>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!--<script>
   $(document).ready(function (e) {
            $("#formthongke").click(function (e) {
                e.preventDefault();
                var formData = {
                    begin: $("batdauthongke").val();
                    end: $("ketthucthongke").val();
                    iddanhmuc: $("danhmuc").val();
                }
                $.ajax({
                    type: 'get',
                    url: '/demo10/admin',
                    data: formdata,
                    success: function (data) {
//                        var table = $("#table-sanphamthongke");
//                        var tmp = data.map(function (sanpham) {
//                            return `<tr>
//
//                                    <td>${sanpham.ten}</td>
//                                    <td>${sanpham.gia} <span>đ</span></td>                                   
//                                    <td>${sanpham.khuyenMai} /> <span>đ</span></td>
//                                    <td><img src="${sanpham.img1}" width="100px" height="60px" alt="anh"/></td>
//                                    <td>${sanpham.soLuongBan}</td>
//                                    <td>${sanpham.doanhThu}</td>
//                                    
//                                </tr>`;
//                        })
//                        table.innerHTML = tmp.join('');

                            $("#table-sanphamthongke").innerHTML(data);
                    },
                    error: function (xhr, status, error) {
                        // Xử lý lỗi
                        console.error('Error: ' + error);
                        $('#result').html('Có lỗi xảy ra.');
                    }
                })
            });
        });
</script>-->

<%@include file="footer.jsp" %>