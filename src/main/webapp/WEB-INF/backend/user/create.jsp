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
            <h1>Tạo mới User</h1>
            <form:form class="row g-3 needs-validation"  action="/backend/user/save" method="post" modelAttribute="userDto">
                <div class="col-md-4">
                    <label for="validationCustom01" class="form-label">Tên đăng nhập</label>
                    <form:input type="text" path="username" class="form-control"  id="validationCustom01" value=""/>
                    <form:errors path="username" cssClass="error"/>
                </div>
                <div class="col-md-4">
                    <label  class="form-label">Mật khẩu</label>
                    <form:input type="password" path="password" class="form-control" id="password" />
                    <form:errors path="password" cssClass="error"/>
                </div>
                <div class="col-md-4">
                    <label  class="form-label">Nhập lại mật khẩu</label>
                    <form:input type="password" path="repassword" class="form-control" id="repassword" />
                    <form:errors path="" cssClass="error"/>
                </div>

                <div class="col-md-4">
                    <label  class="form-label">Email</label>
                    <form:input type="text" path="email" class="form-control" />
                </div>
                <div class="col-md-4">
                    <label class="form-label">Phone</label>
                    <form:input type="text" path="phone" class="form-control"  />
                </div>

                <div class="col-md-4">
                    <label class="form-label">Chọn quyền</label>
                    <form:select type="text" path="role" class="form-control"  >
                        <form:option value="">Chọn quyền</form:option>
                        <c:forEach items="${roles}" var="role">
                            <form:option value="${role}">${role}</form:option>
                        </c:forEach>
                    </form:select>
                    <form:errors path="role" cssClass="error"/>
                </div>
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


