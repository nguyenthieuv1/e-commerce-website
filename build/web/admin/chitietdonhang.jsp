<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>

<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Chi tiết đơn hàng</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">Danh sách sản phẩm của đơn hàng</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    danh sách
                </div>
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                            <tr>
                                <th>Tên</th>
                                <th>Giá bán</th>
                                <th>Số lượng</th>
                                <th>Danh mục</th>
                                <th>Hình ảnh</th>
                                <th>Tổng tiền</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Tên</th>
                                <th>Giá bán</th>
                                <th>Số lượng</th>
                                <th>Danh mục</th>
                                <th>Hình ảnh</th>
                                <th>Tổng tiền</th>
                            </tr>
                        </tfoot>
                        <tbody id="dssanpham">
                            <c:forEach items="${dsctdonhang}" var="sanpham">
                                <tr>
                                    <td>${sanpham.ten}</td>
                                    <td><fmt:formatNumber value="${sanpham.giaBan}" /> <span>đ</span></td> 
                                    <td>${sanpham.soLuong}</td>
                                    <td>${sanpham.danhMuc}</td>
                                    <td><img src="${sanpham.img1}" style="max-height: 80px; max-width: 100px;" alt="anh"/></td>
                                    <td><fmt:formatNumber value="${sanpham.tongCong}" /> <span>đ</span></td>

                                </tr>
                            </c:forEach> 
                        </tbody>
                    </table>
                </div>
                <h3>Tổng Cộng: <fmt:formatNumber value="${tongtien}" /> <span>đ</span></h3>
            </div>
            <form action="/demo10/admin-chitietdonhang?id=${id}" method="post"> 
                <div class="form-group">
                    <label for="trangthai">Tùy chọn</label>
                    <select class="form-control" id="trangthai" name="trangthai">
                        <option value="1">Tiếp nhận</option>
                        <option value="3">Hủy Bỏ</option>
                        <option value="2">Hoàn thành</option>
                    </select>
                    <button type="submit" class="btn btn-primary mt-2">Cập nhật</button>
                </div>
            </form>
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

<script>
//$(document).ready(function() {
//    // Sử dụng sự kiện on để gán sự kiện nhấp chuột
//    $('#dssanpham').on('click', 'tr[data-href]', function() {
//        var link = $(this).attr('data-href');
//        if (link) {
//            window.location.href = link;
//        }
//        console.log("Navigating to: " + link); // Kiểm tra xem sự kiện có thực thi không
//    });
//});


</script>

<%@include file="footer.jsp" %>
