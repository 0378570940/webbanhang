<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <jsp:include page="/WEB-INF/backend/common/head.jsp"/>
    <title>Tạo mới thể loại!</title>
</head>
<body>
<jsp:include page="/WEB-INF/backend/common/nav.jsp"/>

<div class="container">
    <div class="bg-light p-5 rounded">
        <div class="col-sm-8 mx-auto">
            <br>
            <h1>Tạo mới Thể loại</h1>
            <form:form class="row g-3 needs-validation"  action="/backend/category/save" method="post" modelAttribute="categoryDto">
                <div class="col-md-4">
                    <label for="validationCustom01" class="form-label">Tên thể loại</label>
                    <form:input type="text" path="name" class="form-control"  id="validationCustom01" value="" required="required" />
                    <div class="invalid-feedback">
                        Vui lòng điền tên thể loại.
                    </div>
                </div>
                <div class="col-md-8">
                    <label for="validationCustom03" class="form-label">Mô tả</label>
                    <form:input type="text" path="description" class="form-control" id="validationCustom03" />
                </div>
                <%--<div class="col-md-6">
                    <label for="validationCustom05" class="form-label">Tải file</label>
                    <input type="file"   name="file" class="form-control" id="validationCustom05" >
                    <div class="gallery"></div>
                    <div class="invalid-feedback">
                        Vui lòng chọn file.
                    </div>
                </div>--%>
                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Tạo mới</button>
                </div>
            </form:form>
        </div>
    </div>

</div>
<jsp:include page="/WEB-INF/backend/common/foot.jsp"/>
<script src="https://code.jquery.com/jquery-3.5.1.js" ></script>

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
                    } else {

                        // không lỗi nhập
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()

    var Upload = function (file) {
        this.file = file;
    };

    Upload.prototype.getType = function() {
        return this.file.type;
    };
    Upload.prototype.getSize = function() {
        return this.file.size;
    };
    Upload.prototype.getName = function() {
        return this.file.name;
    };
    Upload.prototype.doUpload = function () {
        var that = this;
        var formData = new FormData();

        // add assoc key values, this will be posts values
        formData.append("file", this.file, this.getName());
        formData.append("upload_file", true);

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/backend/category/save",
            xhr: function () {
                var myXhr = $.ajaxSettings.xhr();
                if (myXhr.upload) {
                    myXhr.upload.addEventListener('progress', that.progressHandling, false);
                }
                return myXhr;
            },
            success: function (data) {
                // your callback here
            },
            error: function (error) {
                // handle error
            },
            async: true,
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            timeout: 60000
        });
    };

    Upload.prototype.progressHandling = function (event) {
        // var percent = 0;
        // var position = event.loaded || event.position;
        // var total = event.total;
        // var progress_bar_id = "#progress-wrp";
        // if (event.lengthComputable) {
        //     percent = Math.ceil(position / total * 100);
        // }
        // // update progressbars classes so it fits your code
        // $(progress_bar_id + " .progress-bar").css("width", +percent + "%");
        // $(progress_bar_id + " .status").text(percent + "%");
    };

    $("#validationCustom05").on("change", function (e) {
        var file = $(this)[0].files[0];
        var upload = new Upload(file);

        // maby check size or type here with upload.getSize() and upload.getType()

        // execute upload
        upload.doUpload();
    });
    $(function() {
        // Multiple images preview in browser
        var imagesPreview = function(input, placeToInsertImagePreview) {

            if (input.files) {
                var filesAmount = input.files.length;

                for (i = 0; i < filesAmount; i++) {
                    var reader = new FileReader();

                    reader.onload = function(event) {
                        $($.parseHTML('<img>')).attr('src', event.target.result).appendTo(placeToInsertImagePreview);
                    }

                    reader.readAsDataURL(input.files[i]);
                }
            }

        };

        $('#validationCustom05').on('change', function() {
            imagesPreview(this, 'div.gallery');
        });
    });
</script>


