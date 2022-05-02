<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--Đây là file dùng làm navi(menu) cho trang backend--%>
<nav class="navbar navbar-expand-xxl navbar-dark bg-dark" aria-label="Seventh navbar example">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">BackendShop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExampleXxl"
                aria-controls="navbarsExampleXxl" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExampleXxl">
            <ul class="navbar-nav me-auto mb-2 mb-xl-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Trang chủ</a>
                </li>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link" href="#">Link</a>--%>
                <%--                </li>--%>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
                <%--                </li>--%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdownXxl" data-bs-toggle="dropdown"
                       aria-expanded="false">Sản phẩm</a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownXxl">
                        <li><a class="dropdown-item" href="/backend/product/create">Tạo mới</a></li>
                        <li><a class="dropdown-item" href="/backend/product/list">Danh sách</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdownXxl" data-bs-toggle="dropdown"
                       aria-expanded="false">Thể loại</a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownXxl">
                        <li><a class="dropdown-item" href="/backend/category/create">Tạo mới</a></li>
                        <li><a class="dropdown-item" href="/backend/category/list">Danh sách</a></li>
                    </ul>
                </li>
                <sec:authorize access="hasRole('ADMIN')">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdownXxl123" data-bs-toggle="dropdown"
                           aria-expanded="false">Tài khoản</a>
                        <ul class="dropdown-menu" aria-labelledby="dropdownXxl123">
                            <li><a class="dropdown-item" href="/backend/user/create">Tạo mới tài khoản</a></li>
                            <li><a class="dropdown-item" href="/backend/user/list">Danh sách tài khoản</a></li>
                        </ul>
                    </li>
                </sec:authorize>

            </ul>
            <!-- Right elements -->
            <div class="d-flex align-items-center" style=" margin-right: 50px;">
                <a class="text-reset me-3" href="#">
                    <i class="fas fa-shopping-cart"></i>
                </a>
                <div class="dropdown">
                    <a  class="nav-link dropdown-toggle" href="#" id="dropdownlogout" data-bs-toggle="dropdown"
                        aria-expanded="false" class="dropdown-toggle d-flex align-items-center hidden-arrow"
                            href="#"
                            id="navbarDropdownMenuAvatar"
                            role="button"
                            data-mdb-toggle="dropdown"
                            aria-expanded="false">
                        <img src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp"
                                class="rounded-circle"
                                height="25"
                                alt="Black and White Portrait of a Man"
                                loading="lazy"/>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownlogout">
                        <li><a class="dropdown-item" href="/logout">Đăng xuất</a></li>
                        <li><a class="dropdown-item" href="/backend/product/list">Đổi mật khẩu</a></li>
                        <li><a class="dropdown-item" ><sec:authentication property="principal.email"></sec:authentication></a></li>
                    </ul>
                </div>
            </div>
            <!-- Right elements -->
        </div>
    </div>
</nav>
