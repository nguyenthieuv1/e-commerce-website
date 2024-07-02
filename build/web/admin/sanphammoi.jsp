<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>



<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h2>Tạo sản phẩm mới</h2>
            <div class="container">
                <form action="/demo10/sanphammoi" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="ten">Tên sản phẩm</label>
                                <input type="text" class="form-control" id="ten" name="ten" >
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="gia">Giá</label>
                                <input type="number" class="form-control" id="gia" name="gia" >
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="soluong">Số lượng</label>
                                <input type="number" class="form-control" id="soluong" name="soluong" >
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="khuyenmai">Khuyến Mãi</label>
                                <input type="number" class="form-control" id="khuyenmai" name="khuyenmai" >
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label for="danhmuc">Danh mục</label>
                                <select class="form-control" id="danhmuc" name="danhmuc">
                                     
                                    
                                    <option  value="1">Điều hòa</option>
                                    <option value="2">Máy giặt</option>
                                    <option value="3">Tủ lạnh</option>
                                    <option value="4">Ti vi</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="mota">Mô tả</label>
                                <textarea name="mota" id="mota" class="form-control" ></textarea>
                            </div>
                        </div>
                    </div>



                    <div class="row mt-3 mb-3">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="hinhanh">Hình ảnh</label>
                                <input type="file" class="form-control-file" id="hinhanh" name="hinhanh">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div id="motaanh"></div>
                        </div>
                    </div>


                    <button type="submit" class="btn btn-primary">Tạo mới</button>
                   
                </form>
            </div>
        </div>

    </main>
</div>

<script>
    
    $(document).ready(function () {
        $('#hinhanh').change(function () {
            var file = $(this)[0].files[0];
            var fileReader = new FileReader();
            fileReader.onload = function (e) {
                $('#motaanh').after('<img src="' + e.target.result + '" class="img-fluid"  style="max-height: 400px; max-width: 400px;"  > ');
            }
            fileReader.readAsDataURL(file);
        });


        $('#xoa').click(function () {
            if (confirm('Bạn có chắc chắn muốn xóa sản phẩm này không?')) {
                        $.ajax({
                            url:"/demo10/chitietsanpham?id=${sanpham.id}",
                            type:"delete",
                            success: function (data){
                                alert("da xoa san pham");
                                window.location.href="/demo10/admin-sanpham";
                            },
                            error: function (){
                                alert("da xoa that bai");
                            }
                        })
            }
        });
    });

     
</script>

<%@include file="footer.jsp" %>
