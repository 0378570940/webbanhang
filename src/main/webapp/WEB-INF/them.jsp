<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 id="h1" style="font-weight: bold">Thêm khách hàng<h1>

<form method="post" action="/them2" >
    <input name="id" placeholder="Điền id khách hàng"/><br>
    <input name="makh" placeholder="Điền mã khách hàng"/>
    <button type="submit"> Thêm khách hàng</button>
</form>

