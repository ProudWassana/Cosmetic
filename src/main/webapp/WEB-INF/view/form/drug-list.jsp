<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPEhtml><html><head><title>${title}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet"></head>
<body>
<header>
    <h2>PharmarHome</h2>
</header>

<section>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
    <article>
        <div id="header"><h1>${title}</h1></div><div class="container">
        <form action="${pageContext.request.contextPath}/form/${form.id}/drug/add" method="post">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>รหัสยา</th>
                    <th>ชื่อยา</th>
                    <th>ราคา</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody><c:forEach var="drug" items="${drugs}">
                    <tr>
                        <td class="center">${drug.code}</td>
                        <td>${drug.name}</td>
                        <td>${drug.price}</td>
                        <td class="center">
                            <button type="submit" class="btn btn-outline-primary" name="drug" value="${drug.id}">เพิ่ม</button>
                        </td>
                    </tr>
                </c:forEach></tbody>
            </table>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
    </div>
    </article>
</section>
<footer>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</footer>


</body></html>