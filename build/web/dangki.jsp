<%-- 
    Document   : dangki
    Created on : Jul 2, 2024, 3:17:08 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>
    <div class="container" style="margin-top: 150px;">

    </div>


    <div class="container" style="margin-top: 100px;">
        <h3 class="text-center mb-">Đăng kí tài khoản</h3>
        <form action="/demo10/dangki" method="post">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="ten">Tên khách hàng</label>
                        <input type="text" class="form-control" id="ten" name="ten" ">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="sdt">Số điện thoại</label>
                        <input type="text" class="form-control" id="sdt" name="sdt"">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" id="username" name="username" ">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="text" class="form-control" id="password" name="password"">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="dob">Ngày sinh</label>
                        <input type="date" class="form-control" id="dob" name="dob" ">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="diachi">Địa chỉ</label>
                        <input type="text" name="diachi" id="diachi" class="form-control" ></input>
                           
                    </div>
                </div>
            </div>

            <button type="submit" class="btn btn-primary mt-4">Đăng kí</button>
            

            

    </div>


<!--    <script>
        $(document).ready(function () {
            $('.xoa').click(function () {
                if (confirm('Bạn có chắc chắn muốn xóa tài khoản không?')) {
                    var id = this.getAttribute('data-id');
                    alert(id);
                    console
                }
            });
        });
    </script>-->
</body>

</html>