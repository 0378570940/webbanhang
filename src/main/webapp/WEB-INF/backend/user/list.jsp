<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <jsp:include page="/WEB-INF/backend/common/head.jsp"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css" rel="stylesheet" >
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css" rel="stylesheet" >
<%--    https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.0.1/css/bootstrap.min.css--%>
<%--    https://cdn.datatables.net/1.11.4/css/dataTables.bootstrap5.min.css--%>
    <title>Danh sách loại sản phẩm</title>
</head>
<body>
<jsp:include page="/WEB-INF/backend/common/nav.jsp"/>

<div class="container">
    <div class="bg-light p-5 rounded">
        <div class="col-sm-8 mx-auto">
            <br>
            <h1>Danh sách Loại sản phẩm</h1>
            <h2 style="color: red">${message}</h2>
            <table  id="example" class="table table-striped" style="width:100%">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">email</th>
                    <th scope="col">phone</th>
                    <th scope="col">Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="stt" value="1"></c:set>
                <c:forEach items="${data.data}" var="product">
                    <tr>
                        <th scope="row">${stt}</th>
                        <td>${product.email}</td>
                        <td>${product.phone}</td>
                        <td><a href="/backend/user/edit/${product.id}">Sửa</a>
                            <a href="/backend/user/delete/${product.id}">Xóa</a></td>
                    </tr>
                    <c:set var="stt" value="${stt + 1}"></c:set>
                </c:forEach>

                </tbody>
            </table>

        </div>
    </div>

</div>

<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js" ></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap5.min.js" ></script>

<jsp:include page="/WEB-INF/backend/common/foot.jsp"/>
<script>
    $(document).ready(function() {
        $('#example').DataTable({
            "language": {
                "paginate": {
                    "first": "Đầu",
                    "last": "Cuối",
                    "next": "Sau",
                    "previous": "Trước"
                },
                "search": "Tìm kiếm:",
                "lengthMenu": "Hiển thị _MENU_ dự liệu trên trang",
                "zeroRecords": "Không tìm thấy dữ liệu",
                "info": "Hiển thị _PAGE_ trên tổng số _PAGES_ kết quả",
                "infoEmpty": "Không có dữ liệu",
                "infoFiltered": "(Lọc từ _MAX_ trên tổng số dữ liệu)"
            }
        });
    } );
</script>


