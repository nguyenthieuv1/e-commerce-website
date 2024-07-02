<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>

<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Đơn hàng - xử lý</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item active">Thông tin đơn hàng khách hàng</li>
            </ol>

            <div class="row mt-3 mb-3">
                <form action="/demo10/admin-xulydonhang" class="form-group">
                    <div class="col-md-6 ">
                        <label for="trangthai">Chọn trạng thái đơn hàng</label>
                        <select name="trangthai" id="trangthai" class="form-control">
                            <option value="đã đặt">đã đặt</option>
                            <option value="hoàn thành">hoàn thành</option>
                            <option value="hủy">hủy</option>

                        </select>
                        <button type="submit" class="btn btn-primary mt-2">Tìm</button>
                    </div>
                </form>

            </div>

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
                                <th>số điện thoại</th>
                                <th>ngày đặt</th>
                                <th>số sản phẩm</th>
                                <th>tổng tiền</th>
                                <th>link</th>

                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>họ tên</th>
                                <th>số điện thoại</th>
                                <th>ngày đặt</th>
                                <th>số sản phẩm</th>
                                <th>tổng tiền</th>
                                <th>link</th>

                            </tr>
                        </tfoot>
                        <tbody id="dssanpham">
                            <c:forEach items="${dsdonhang}" var="donhang" >
                                <tr>
                                    <td>${donhang.tenKhach}</td>
                                    <td>${donhang.sdt}</td> 
                                    <td>${donhang.ngayDat}</td>
                                    <td>${donhang.sosanpham}</td>
                                    <td><fmt:formatNumber value="${donhang.tongTien}" /> <span>đ</span></td>
                                    <td><a href="/demo10/admin-chitietdonhang?id=${donhang.id}">chi tiết</a></td>
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

<!--<script>
 $(document).ready(function () {
       
        $('#trangthai').click(function () {
                var trangthai = $('#trangthai').val();
                $.ajax({
                    url: `/demo10/admin-xulydonhang?trangthai=${trangthai}`,
                    type: "get",
                   
                })
           
        });
    });

</script>-->

<%@include file="footer.jsp" %>
