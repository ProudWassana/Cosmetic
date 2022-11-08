<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head><title>${title}</title>
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
    <h1>${title}</h1>
    <div class="container">
      <input type="button" class="btn btn-primary" value="เพิ่มตารางยา"
             onclick="window.location.href='${pageContext.request.contextPath}/drug/create'; return false;"class="add-button"/>
      <table class="table table-hover">
        <thead>
        <tr>
          <th>รหัสยา</th>
          <th>ชื่อยา</th>
          <th>ปริมาณ</th>
          <th>ราคา</th>
          <th>สรรพคุณ</th>
          <th>คำไข้</th>
          <th></th>
          <th>แก้ไข</th>
        </tr>
        </thead>
        <tbody><c:forEach var="drug" items="${drugs}">
          <tr>
            <td>${drug.code}</td>
            <td>${drug.name}</td>
            <td>${drug.quantity}</td>
            <td>${drug.price}</td>
            <td>${drug.propertie}</td>
            <td>${fn:length(drug.forms)}</td>
            <td><input type="button" class="btn btn-outline-primary" value="คนไข้ทั้งหมด" onclick="window.location.href='${pageContext.request.contextPath}/drug/${drug.id}/view-form';return false;"/></td>
            <td><a href="${pageContext.request.contextPath}/drug/${drug.id}/update">${'แก้ไข'}</a></td>
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