<%-- 
    Document   : homepage
    Created on : Jun 27, 2024, 6:46:49 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- header -->
<%@ include file="header.jsp" %>
<!-- /header -->

<!-- Header homepage-->
<header class="bg-dark py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Siêu thị điện máy HC</h1>
            <p class="lead fw-normal text-white-50 mb-0">mua tất cả tại điện máy HC</p>
        </div>
    </div>
</header>


<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

            <c:forEach items="${dssanpham}" var="sanpham">


                <div class="col mb-5">
                    <a href="/demo10/item?id=${sanpham.id}"  style="display: block; text-decoration: none; color: inherit;">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="${sanpham.img1}" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">${sanpham.ten}</h5>

                                    <!-- Product price-->
                                    <span class="text-decoration-line-through"><fmt:formatNumber value="${sanpham.gia}" />  <span>đ</span> </span>
                                    <fmt:formatNumber value="${sanpham.khuyenMai}" /> <span>đ</span>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto themsanpham" data-id="${sanpham.id}"  href="#">Thêm vào giỏ hàng</a></div>
                            </div>
                        </div>
                    </a>
                </div>


            </c:forEach>

        </div>
        <ul class="pagination justify-content-center">
            <%-- Kiểm tra nếu page lớn hơn 1 --%>
            <c:if test="${page > 1}">
                <li class="page-item"><a class="page-link" href="/demo10/home?page=${page-1}">Previous</a></li>
                </c:if>
                <%-- Nếu page bằng 1 hoặc nhỏ hơn, không tạo liên kết "Previous" --%>
                <c:if test="${page <= 1}">
                <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
                </c:if>


            <c:forEach begin="1" end="${endPoint}" var ="i">
                <c:if test="${i == page}">
                    <li class="page-item active"><a class="page-link" href="/demo10/home?page=${i}">${i}</a></li>
                    </c:if>


                <c:if test="${i != page}">
                    <li class="page-item "><a class="page-link" href="/demo10/home?page=${i}">${i}</a></li>
                    </c:if>

            </c:forEach>                                    


            <%-- Kiểm tra nếu page lớn hơn 1 --%>
            <c:if test="${page < endPoint}">
                <li class="page-item"><a class="page-link" href="/demo10/home?page=${page+1}">Next</a></li>
                </c:if>
                <%-- Nếu page bằng 1 hoặc nhỏ hơn, không tạo liên kết "next" --%>

            <c:if test="${page >= endPoint}">
                <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
                </c:if>
        </ul>
    </div>
</section>




<script>

    $(document).ready(function () {

        $('.themsanpham').click(function () {
            var idsp = this.getAttribute('data-id');
            $.ajax({
                url: "/demo10/giohang?idsp=" + idsp,
                type: "post",
                success: function (data) {
//                        alert("da xoa user");
                    window.location.href = "/demo10/giohang";
                },
                error: function () {
//                        alert("da xoa that bai");
                }
            })

        });
    });


</script>


<!-- Footer-->
<%@include file="footer.jsp" %>
