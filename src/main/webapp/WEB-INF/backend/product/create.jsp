<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <jsp:include page="/WEB-INF/backend/common/head.jsp"/>
    <title>Tạo mới sản phẩm!</title>
</head>
<body>
<jsp:include page="/WEB-INF/backend/common/nav.jsp"/>

<div class="container">
    <div class="bg-light p-5 rounded">
        <div class="col-sm-8 mx-auto">
            <br>
            <h1>Tạo mới sản phẩm</h1>
            <form class="row g-3 needs-validation" novalidate action="/backend/product/save" method="post">
                <div class="col-md-4">
                    <label for="validationCustom01" class="form-label">Tên sản phẩm</label>
                    <input type="text" name="name" class="form-control" id="validationCustom01" value="" required>
                    <div class="invalid-feedback">
                        Vui lòng điền tên sản phẩm.
                    </div>
                </div>
                <div class="col-md-4">
                    <label for="validationCustom02" class="form-label">Nhãn hiệu</label>
                    <input type="text" class="form-control" name="brand" id="validationCustom02" value="" required>
                    <div class="valid-feedback">
                        Vui lòng điền tên nhãn hiệu.
                    </div>
                </div>
                <div class="col-md-4">
                    <label for="validationCustomUsername" class="form-label">Giá</label>
                    <div class="input-group has-validation">
                        <input type="number" class="form-control" name="price" id="validationCustomUsername"
                               aria-describedby="inputGroupPrepend" required>
                        <div class="invalid-feedback">
                            Vui lòng điền giá.
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="validationCustom03" class="form-label">Mô tả</label>
                    <input type="text" name="description" class="form-control" id="validationCustom03">
                </div>
                <div class="col-md-3">
                    <label for="validationCustom04" class="form-label">Thể loại</label>
                    <select name="category" class="form-select" id="validationCustom04" required>
                        <option selected disabled value="">Chọn thể loại</option>
                        <c:forEach var="c" items="${categories}">
                            <option value="${c.id}">${c.name}</option>
                        </c:forEach>

                    </select>
                    <div class="invalid-feedback">
                        Vui lòng chọn loại sản phẩm
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="fileUploadId" class="form-label">Tải file</label>
                    <input type="file" class="form-control" id="fileUploadId">
                    <input type="text" name="image" hidden class="form-control" id="fileUploadName" required>
                    <div class="invalid-feedback">
                        Vui lòng chọn file.
                    </div>
                </div>
                <div class="col-md-6">
                    <img id="outputImage" width="100px"/>
                </div>
                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Tạo mới</button>
                </div>
            </form>
        </div>
    </div>

</div>
<jsp:include page="/WEB-INF/backend/common/foot.jsp"/>
<jsp:include page="/WEB-INF/backend/common/upload-file.jsp"/>

</body>
</html>
<script>


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
                    }
                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>


