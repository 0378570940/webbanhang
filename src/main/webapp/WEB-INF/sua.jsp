<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 id="h1" style="font-weight: bold">Sửa khách hàng<h1>

<form method="POST" action="/edit" >
    <input name="id" placeholder="Điền id khách hàng" value="${khachhang.id}"/><br>
    <input name="makh" value="${khachhang.makh}"placeholder="Điền mã khách hàng"/>
    <button type="submit"> Sửa khách hàng</button>
</form>

