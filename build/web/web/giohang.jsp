<%-- 
    Document   : giohang
    Created on : Jun 30, 2024, 9:50:26 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<div class="container 100-vh" style="margin-top: 100px;">
    <h3 class="text-center" >Giỏ hàng</h3>
    <table class="table table-bordered table-hover text-center">
        <thead class="thead-dark">
            <tr>

                <th>Hình ảnh</th>
                <th>Tên sản phẩm</th>
                <th>Giá bán</th>
                <th>Số lượng</th>
                <th>Tổng cộng</th>
                <th>Chức năng</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${dssanpham}" var="sanpham" >
                <tr>
                    <td>${sanpham.img1}</td>
                    <td>${sanpham.ten}</td> 
                    <td><fmt:formatNumber value="${sanpham.gia}" /> <span>đ</span></td>
                    <td>${sanpham.soLuong}</td>
                    <td><fmt:formatNumber value="${sanpham.tongCong}" /> <span>đ</span></td>
                    
                    <td><button class="btn btn-danger xoa" data-id="${sanpham.id}">Xóa</button></td>
                </tr>
            </c:forEach> 


        </tbody>
    </table>
    <h4>Tổng tiền:  <fmt:formatNumber value="${tongtien}" /> <span>đ</span></h4>

    <button class="btn btn-primary mt-4" id="dathang">Đặt hàng</button>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<script>



    $(document).ready(function () {
        $('.xoa').click(function () {
            if (confirm('Bạn có chắc chắn muốn xóa tài khoản không?')) {
                var idd = this.getAttribute('data-id');
//                alert(id);
//                console.log(idd);
                $.ajax({
                    url: "/demo10/giohang?id="+idd,
                    type: "delete",
                    success: function (data) {
                        location.reload();
//                        console.log(data);
                    },
                    error: function () {
                        alert("da xoa that bai");
                    }
                })
            }
        });
        
         $('#dathang').click(function () {
            if (confirm('Xác nhận đặt hàng')) {
               
                $.ajax({
                    url: "/demo10/giohang?id="+${idUser},
                    type: "put",
                    success: function (data) {
//                        if(confirm('Đặt hàng thành công')){
                            window.location.href = '/demo10/home';
//                        }
                    },
                    error: function () {
                        alert("Đặt hàng that bai");
                    }
                })
            }
        });
        
    });

</script>


