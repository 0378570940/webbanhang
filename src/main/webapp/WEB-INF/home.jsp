<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 id="h1" style="font-weight: bold">Xin chào 123<h1>

${name}

    <% System.out.println("hello");
        int x = 1; x++;

    %>
    <c:set var="test" value="1"></c:set>
    <c:forEach items="${khachhangs}" var="k">
        id = ${k.id}, mã = ${k.makh}
        <c:set var="test" value="${test + 1}"></c:set>
    </c:forEach>
    <br>
    biến test = ${test}
    <br>
    biến x = <%=x %>
    <br>
    <a target="_blank" href="../khachhang/t3h">Link đến khachhang/t3h theo đường dẫn tương đối</a> <br>
    <a target="_blank" href="/khachhang/t3h">Link đến khachhang/t3h theo đường dẫn tuyệt đối</a>

    <script>
    var x = 1;
    console.log("hello 123");
    x ++;
    document.getElementById("h1").textContent = "t3h";
    </script>
