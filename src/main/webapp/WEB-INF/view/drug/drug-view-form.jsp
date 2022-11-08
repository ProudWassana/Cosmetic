<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPEhtml><html><head><title>${title}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet"></head>
<body>
<header>
  <h2>เว็บไซต์คลินิกรักษาไช้</h2>
</header>

<section>
  <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
  <article>
    <div id="header"><h1>${title}</h1></div><div class="container">
    <input type="button" class="btn btn-primary" value="เพิ่มงาน"onclick="window.location.href='${pageContext.request.contextPath}/drug/${drugs.id}/form/add';return false;"class="add-button"/>
    <table class="table table-hover">
      <thead>
      <tr>
        <th>รหัสการรักษา</th>
        <th>ชื่อ - นามสกุล</th>
        <th>เบอร์โทร</th>
        <th>Action</th>
      </tr>
      </thead>
      <tbody><c:forEach var="form" items="${forms}">
        <tr>
          <td class="center">${form.code}</td>
          <td>${form.name}</td>
          <td>${form.tel}</td>
          <td class="center"><input type="button" class="btn btn-outline-danger" value="ลบ"onclick="window.location.href='${pageContext.request.contextPath}/drug/${drugs.id}/form/${form.id}/remove';return false;"class="add-button"/></td>
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