<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPEhtml><html><head><title>${title}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
</head>
<body>

<header>
    <h2>เว็บไซต์คลินิกรักษาไช้</h2>
</header>

<section>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
    <article>
        <div id="header"><h1>${title}</h1></div><div class="container">
        <security:authorize access="hasRole('ADMIN')">
            <input type="button" class="btn btn-primary" value="เพิ่มยา"onclick="window.location.href='${pageContext.request.contextPath}/form/${forms.id}/drug/add';return false;"class="add-button"/>
        </security:authorize>
        <table class="table table-hover">
            <thead>
            <tr>
                <security:authorize access="hasRole('ADMIN')"><th>รหัสยา</th></security:authorize>
                <security:authorize access="hasRole('MANAGER')"><th>รหัสยา</th></security:authorize>
                <th>ชื่อยา</th>
                <th>ราคา</th>
                <security:authorize access="hasRole('ADMIN')"><th>Action</th></security:authorize>
            </tr>
            </thead>
            <tbody><c:forEach var="drug" items="${drugs}">
                <tr>
                    <td>${drug.code}</td>
                    <td>${drug.name}</td>
                    <td>${drug.price}</td>
                    <security:authorize access="hasRole('ADMIN')">
                        <td class="center"><input type="button" class="btn btn-outline-danger" value="ลบ"onclick="window.location.href='${pageContext.request.contextPath}/form/${forms.id}/drug/${drug.id}/remove';return false;"class="add-button"/></td>
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

</body></html>