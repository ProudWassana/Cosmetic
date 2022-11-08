<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head><title>${title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
</head>
<body>
<header>
    <h2>PharmarHome</h2>
</header>

<section>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
    <article>
        <h1>${title}</h1>
        <div class="container">
            <security:authorize access="hasRole('MANAGER')">
                <input type="button" class="btn btn-primary" value="แจ้งอาการ"
                       onclick="window.location.href='${pageContext.request.contextPath}/form/create'; return false;"class="add-button"/>
            </security:authorize>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>รหัส</th>
                    <th>ชื่อ-นามสกุล</th>
                    <th>เบอร์โทร</th>
                    <security:authorize access="hasRole('ADMIN')"><th>Status</th></security:authorize>
                    <security:authorize access="hasRole('MANAGER')"><th>Status</th></security:authorize>
                    <security:authorize access="hasRole('MANAGER')"><th>รายละเอียด</th></security:authorize>
                    <security:authorize access="hasRole('ADMIN')"><th>รายละเอียด</th></security:authorize>
                </tr>
                </thead>
                <tbody><c:forEach var="form" items="${forms}">
                    <tr>

                        <td>
                                ${form.code}
                        </td>
                        <td>${form.name}</td>
                        <td class="number">${form.tel}</td>
                        <security:authorize access="hasRole('ADMIN')">
                            <td><c:if test="${form.id > 0}"><input type="button" class="btn btn-outline-success" value="จ่ายยา" onclick="window.location.href='${pageContext.request.contextPath}/form/${form.id}/view-drugs';return false;"class="add-button"/></c:if></td>
                        </security:authorize>
                        <security:authorize access="hasRole('MANAGER')">
                            <td><c:if test="${form.id > 0}"><input type="button" class="btn btn-outline-primary" value="ดูยา" onclick="window.location.href='${pageContext.request.contextPath}/form/${form.id}/view-drugs';return false;"class="add-button"/></c:if></td>
                        </security:authorize>
                        <security:authorize access="hasRole('MANAGER')">
                            <td><input type="button" value="แก้ไขข้อมูล" class="btn btn-outline-warning" onclick="window.location.href='${pageContext.request.contextPath}/form/${form.id}/update';return false;"class="add-button"/></td>
                        </security:authorize>
                        <security:authorize access="hasRole('ADMIN')">
                            <td><input type="button" class="btn btn-outline-primary" value="ดูรายละเอียด" onclick="window.location.href='${pageContext.request.contextPath}/form/${form.id}/update';return false;"class="add-button"/></td>
                        </security:authorize>
                    </tr>
                </c:forEach></tbody>
            </table>
        </div>
    </article>
</section>
<footer>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</footer>


</body>
</html>