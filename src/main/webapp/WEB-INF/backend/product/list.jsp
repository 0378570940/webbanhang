<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <jsp:include page="/WEB-INF/backend/common/head.jsp"/>
    <title>Danh sách sản phẩm!</title>
</head>
<body>
<jsp:include page="/WEB-INF/backend/common/nav.jsp"/>

<div class="container">
    <div class="bg-light p-5 rounded">
        <div class="col-sm-8 mx-auto">
            <br>
            <h1>Danh sách sản phẩm</h1>
            <h2 style="color: red">${message}</h2>

            <input id="search" placeholder=" tìm kiếm"/>
            <button id="btn">Tìm kiếm</button>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">
                        <a href="/backend/${path}/list?page=${page}&sort=desc&field=name">Giảm</input></a>
                        <a href="/backend/${path}/list?page=${page}&sort=asc&field=name">Tăng</i></a>
                        <a href="/backend/${path}/list?page=${page}&sort=${sort}&field=name">
                            Tên sảm phẩm
                        </a>
                    </th>
                    <th scope="col"><a href="/backend/${path}/list?page=${page}&sort=${sort}&field=price">Giá</a></th>
                    <th scope="col">Thương hiệu</th>
                    <th scope="col">Image</th>
                    <th scope="col">User</th>
                    <th scope="col">Hành động</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="stt" value="1"></c:set>
                <c:forEach items="${data}" var="product">
                    <tr>
                        <th scope="row">${stt}</th>
                        <td>${product.name}</td>
                        <td>${product.price}</td>
                        <td>${product.brand}</td>
                        <td><img width="50px" src="/api/product-image/${product.image}"></td>
                        <td>${product.user.username}</td>
                        <td><a href="/backend/product/edit/${product.id}">Sửa</a>
                            <a href="/backend/product/delete/${product.id}">Xóa</a></td>
                    </tr>
                    <c:set var="stt" value="${stt + 1}"></c:set>
                </c:forEach>

                </tbody>
            </table>


            <jsp:include page="/WEB-INF/backend/common/paging.jsp"/>

        </div>
    </div>

</div>
<jsp:include page="/WEB-INF/backend/common/foot.jsp"/>
</body>
</html>
<script>
    $("#btn").click(function () {
        window.location.href = '/backend/${path}/list?page=${page}&sort=${sort}&field=${field}&keyWord=' + $('#search').val()
    })

        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict'

            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.querySelectorAll('.needs-validation')

            // Loop over them and prevent submission
            Array.prototype.slice.call(forms)
                .forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            // nếu form bị lỗi nhập
                            event.preventDefault()
                            event.stopPropagation()
                        } else {

                            // không lỗi nhập
                        }

                        form.classList.add('was-validated')
                    }, false)
                })
        })()
</script>


