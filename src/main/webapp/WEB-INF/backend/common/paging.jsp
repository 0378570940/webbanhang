<%@page pageEncoding="UTF-8" %><%--// đọc chữ tiếng việt--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:if test="${totalPage > 1}">
    <nav aria-label="Trang">
        <ul class="pagination">
            <li class="page-item <c:if test="${page == 1}">disabled</c:if>"><a class="page-link" href="/backend/${path}/list?page=${page - 1}&sort=${sort}">Trước</a></li>
            <c:forEach begin="1" end="${totalPage}" var="p" step="1">
                <li class="page-item <c:if test="${page == p}">active</c:if>"><a class="page-link" href="/backend/${path}/list?page=${p}">${p}</a></li>
            </c:forEach>
            <li class="page-item <c:if test="${page == totalPage}">disabled</c:if>"><a class="page-link" href="/backend/${path}/list?page=${page + 1}">Sau</a></li>
        </ul>
    </nav>
</c:if>
