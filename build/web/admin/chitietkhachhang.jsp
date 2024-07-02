<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>

<c:set var="sanphamGiaInt" value="${(sanpham.gia).intValue()}" />
<c:set var="sanphamKhuyenMaiInt" value="${(sanpham.khuyenMai).intValue()}" />

<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h2>Thông tin khách hàng</h2>
            <div class="container">
                <form action="/demo10/admin-chitietkhachhang?id=${user.id}" method="post">
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

                    <button type="submit" class="btn btn-primary">Cập nhật</button>
                    <button class="btn btn-danger" id="xoa" type="button">Xóa tài khoản</button>
            </div>


            <div class="card mb-4 mt-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    Danh sách sản phẩm đã mua
                </div>
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                            <tr>
                                <th>tên mặt hàng</th>
                                <th>số lượng</th>
                                <th>giá</th>
                                <th>ngày mua</th>
                                <th>hình ảnh</th>
                                <th>tổng tiền</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>tên mặt hàng</th>
                                <th>số lượng</th>
                                <th>giá</th>
                                <th>ngày mua</th>
                                <th>hình ảnh</th>
                                <th>tổng tiền</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${dschitietsanpham}" var="ctsanpham">
                                <tr>
                                    <td>${ctsanpham.ten}</td>
                                    <td>${ctsanpham.soLuong}</td>
                                    <td><fmt:formatNumber value="${ctsanpham.gia}" /> <span>đ</span></td>
                                    <td>${ctsanpham.ngayMua}</td>                                   
                                    <td><img src="${ctsanpham.img1}" alt="alt" style="max-height: 80px; max-width: 100px;"/></td>
                                    <td><fmt:formatNumber value="${ctsanpham.tongTien}" /> <span>đ</span></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>


    </main>
</div>

<script>

    $(document).ready(function () {
       
        $('#xoa').click(function () {
            if (confirm('Bạn có chắc chắn muốn xóa user này không?')) {
                $.ajax({
                    url: "/demo10/admin-chitietkhachhang?id=${user.id}",
                    type: "delete",
                    success: function (data) {
                        alert("da xoa user");
                        window.location.href = "/demo10/admin-khachhang";
                    },
                    error: function () {
                        alert("da xoa that bai");
                    }
                })
            }
        });
    });


</script>

<%@include file="footer.jsp" %>
