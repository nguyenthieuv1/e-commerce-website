<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>

<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Mặt hàng</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">Danh sách sản phẩm của cửa hàng</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    Tất cả sản phẩm
                </div>
                <div class="card-body">
                    <table id="datatablesSimple">
                        <thead>
                            <tr>
                                <th>Tên</th>
                                <th>Giá</th>
                                <th>Khuyến mãi</th>
                                <th>Số lượng</th>
                                <th>Danh mục</th>
                                <th>Link</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Tên</th>
                                <th>Giá</th>
                                <th>Khuyến mãi</th>
                                <th>Số lượng</th>
                                <th>Danh mục</th>  
                                <th>Link</th>
                            </tr>
                        </tfoot>
                        <tbody id="dssanpham">
                            <c:forEach items="${dssanpham}" var="sanpham">
                                <tr>
                                    <td>${sanpham.ten}</td>
                                    <td><fmt:formatNumber value="${sanpham.gia}" /> <span>đ</span></td> 
                                    <td><fmt:formatNumber value="${sanpham.khuyenMai}" /> <span>đ</span></td>
                                    <td>${sanpham.soLuong}</td>
                                    <td>${sanpham.danhMuc.ten}</td>
                                    <td><a href="/demo10/chitietsanpham?id=${sanpham.id}">Chi tiết</a></td>
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
