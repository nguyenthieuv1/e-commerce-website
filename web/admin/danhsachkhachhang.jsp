<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>

<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Khách hàng</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">Danh sách tài khoản đã lưu của cửa hàng</li>
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
                                <th>họ tên</th>
                                <th>username</th>
                                <th>password</th>
                                <th>số điện thoại</th>
                                <th>năm sinh</th>
                                <th>link</th>

                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>họ tên</th>
                                <th>username</th>
                                <th>password</th>
                                <th>số điện thoại</th>
                                <th>năm sinh</th>
                                <th>link</th>

                            </tr>
                        </tfoot>
                        <tbody id="dssanpham">
                            <c:forEach items="${dsuser}" var="user" >
                                <tr>
                                    <td>${user.ten}</td>
                                    <td>${user.userName}</td> 
                                    <td>${user.passWord}</td>
                                    <td>${user.sdt}</td>
                                    <td>${user.dob}</td>
                                    <td><a href="/demo10/admin-chitietkhachhang?id=${user.id}">chi tiết</a></td>
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
