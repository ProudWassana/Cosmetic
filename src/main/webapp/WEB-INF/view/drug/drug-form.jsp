<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPEhtml><html><head><title>${title}</title>
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
        <div id="header"><h1>${title}</h1></div><div class="container">
        <div id="container"><i>กรอกข้อมูลยา</i><br><br><form:form action="${pageContext.request.contextPath}/drug/save"
                                                                                                             modelAttribute="drug"
                                                                                                             method="POST"><form:hidden
                path="id"/>
            <table class="table table-hover">
                <colgroup>
                    <col style="width: 160px;">
                    <col style="width: auto;">
                </colgroup>
                <tbody>
                <tr>
                    <td><label>รหัสยา :</label></td>
                    <td><form:input class="form-control" path="code"/><form:errors path="code" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>ชื่อยา :</label></td>
                    <td><form:input class="form-control" path="name"/><form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>ปริมาณ :</label></td>
                    <td><form:input class="form-control" path="quantity"/><form:errors path="quantity" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>ราคา :</label></td>
                    <td><form:input class="form-control" path="price"/><form:errors path="price" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>สรรพคุณ :</label></td>
                    <td><form:input class="form-control" path="propertie"/><form:errors path="propertie" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>รายละเอียด :</label></td>
                    <td><form:input class="form-control" path="detail"/><form:errors path="detail" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" class="btn btn-success" value="บันทึก"/>
                        <input type="button" class="btn btn-outline-danger" value="ลบ" onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบข้อมูลยานี้?'))) { window.location.href='${pageContext.request.contextPath}/drug/${drug.id}/delete'; return false; }"class="cancel-button"/>
                        <!--<input type="button" value="ยกเลิก" onclick="window.location.href='${pageContext.request.contextPath}/drug/list'; return false;" class="cancel-button"/>-->
                    </td>
                </tr>
                </tbody>
            </table>
        </form:form></div>
    </div>
    </article>
</section>
<footer>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</footer>

</body></html>