<%-- 
    Document   : thongtinkhachhang
    Created on : Jul 1, 2024, 4:36:52 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>





<div class="container" style="margin-top: 100px;">
    <h3 class="text-center mb-">Thông tin khách hàng</h3>
    <form action="/demo10/khachhang-thongtin?id=${user.id}" method="post">
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="ten">Tên khách hàng</label>
                    <input type="text" class="form-control" id="ten" name="ten" value="${user.ten}">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="sdt">Số điện thoại</label>
                    <input type="text" class="form-control" id="sdt" name="sdt" value="${user.sdt}">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" name="username" value="${user.userName}">
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="text" class="form-control" id="password" name="password" value="${user.passWord}">
                </div>
            </div>
            <div class="col-md-4">
                <div class="form-group">
                    <label for="dob">Ngày sinh</label>
                    <input type="date" class="form-control" id="dob" name="dob" value="${user.dob}">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <label for="diachi">Địa chỉ</label>
                    <input type="text" name="diachi" id="diachi" class="form-control" value="${user.diaChi}"></input>
                </div>
            </div>
        </div>

        <button type="submit" class="btn btn-primary mt-4">Cập nhật</button>
        <button class="btn btn-danger mt-4" id="xoa" type="button">Xóa tài khoản</button>
        
        <hr>
        <h3 class="mt-4 mb-4 text-center">Danh sách sản phẩm đã mua</h3> 
        <table class="table table-bordered table-hover text-center">
            <thead class="thead-dark">
                <tr>

                    <th>Hình ảnh</th>
                    <th>Tên sản phẩm</th>
                    <th>Giá bán</th>
                    <th>Số lượng</th>
                    <th>Tổng cộng</th>
                    <th>Thời gian đặt</th>
                    <th>Trạng thái</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${dschitietsanpham}" var="sanpham" >
                    <tr>
                        <td>${sanpham.img1}</td>
                        <td>${sanpham.ten}</td> 
                        <td><fmt:formatNumber value="${sanpham.gia}" /> <span>đ</span></td>
                        <td>${sanpham.soLuong}</td>
                        <td><fmt:formatNumber value="${sanpham.tongTien}" /> <span>đ</span></td>
                        <td>${sanpham.ngayMua}</td>
                        <td>${sanpham.trangThai}</td>
                       
                    </tr>
                </c:forEach> 


            </tbody>
        </table>

</div>




<script>
    $(document).ready(function () {
          $('#xoa').click(function () {
            if (confirm('Bạn có chắc chắn muốn xóa tài khoản này không?')) {
                $.ajax({
                    url: "/demo10/khachhang-thongtin?id=${user.id}",
                    type: "delete",
                    success: function (data) {
                        alert("da xoa user");
                        window.location.href = "/demo10/home";
                    },
                    error: function () {
                        alert("da xoa that bai");
                    }
                })
            }
        });
    });
</script>