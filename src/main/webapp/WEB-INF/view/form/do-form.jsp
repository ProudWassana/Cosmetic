<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPEhtml><html><head><title>${title}</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet">
</head><body>

<header>
    <h2>เว็บไซต์คลินิกรักษาไช้</h2>
</header>

<section>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
    <article>
        <div id="header"><h1>${title}</h1></div><div class="container">
        <security:authorize access="hasRole('MANAGER')">
            <div id="container"><i>กรอกข้อมูลอาการ</i><br><br><form:form
                    action="${pageContext.request.contextPath}/form/save"
                    modelAttribute="form"
                    method="POST"><form:hidden
                    path="id"/>
                <table class="table table-hover">
                    <colgroup>
                        <col style="width: 160px;">
                        <col style="width: auto;">
                    </colgroup>
                    <tbody>
                    <tr>
                        <td><label>รหัสการรักษา :</label></td>
                        <td><form:input class="form-control" path="code"/><form:errors path="code" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label>ชื่อ - นามสกุล :</label></td>
                        <td><form:input class="form-control" path="name"/><form:errors path="name" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label>เบอร์โทร :</label></td>
                        <td><form:input class="form-control" path="tel" /><form:errors path="tel" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label>ช่วงอายุ</label></td>
                        <td>
                            <form:select class="form-control" path="category.code">
                                <form:option value="" label="--กรุณาเลือกช่วงอายุ--"/>
                                <form:options items="${categories}" itemLabel="name" itemValue="code"/>
                            </form:select><form:errors path="category.code" cssClass="error"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>รายละเอียดอาการ:</label></td>
                        <td><form:textarea class="form-control" path="description" cols="50" rows="5"></form:textarea><form:errors path="description"
                                                                                                              cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="บันทึก" class="btn btn-success"/>
                            <input type="button" value="ลบ" class="btn btn-danger"
                                   onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบข้อมูลอาการนี้?'))) { window.location.href='${pageContext.request.contextPath}/form/${form.id}/delete'; return false; }"
                                   />
                            <security:authorize access="hasRole('ADMIN')">
                                <c:if test="${form.id > 0}"><input type="button" value="เพิ่ม" onclick="window.location.href='${pageContext.request.contextPath}/form/${form.id}/view-drugs';return false;"class="btn btn-info"/></c:if>
                            </security:authorize>
                            <input type="button" value="ยกเลิก"
                                   onclick="window.location.href='${pageContext.request.contextPath}/form/list'; return false;"
                                   class="btn btn-warning"/>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form:form></div>
        </security:authorize>

        <security:authorize access="hasRole('ADMIN')">
            <div id="container"><i>ข้อมูลแบบฟอร์ม</i><br><br><form:form
                    action="${pageContext.request.contextPath}/form/save"
                    modelAttribute="form"
                    method="POST"><form:hidden
                    path="id"/>
                <table class="table table-hover">
                    <colgroup>
                        <col style="width: 160px;">
                        <col style="width: auto;">
                    </colgroup>
                    <tbody>
                    <tr>
                        <td><label>รหัสแบบฟอร์ม :</label></td>
                        <td><form:input class="form-control" path="code" disabled="true"/><form:errors path="code" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label>ชื่อ - นามสกุล :</label></td>
                        <td><form:input class="form-control" path="name" disabled="true"/><form:errors path="name" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label>เบอร์โทร :</label></td>
                        <td><form:input class="form-control" path="tel"  disabled="true"/><form:errors path="tel" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label>ประเภทการร้องเรียน</label></td>
                        <td>
                            <form:select class="form-control" path="category.code" disabled="true">
                                <form:option value="" label="--กรุณาเลือกรายการ--"/>
                                <form:options items="${categories}" itemLabel="name" itemValue="code"/>
                            </form:select><form:errors path="category.code" cssClass="error" disabled="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>รายละเอียด :</label></td>
                        <td><form:textarea class="form-control" path="description" cols="50" rows="5" disabled="true"></form:textarea><form:errors path="description"
                                                                                                                              cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td>
                            <c:if test="${form.id > 0}"><input type="button" class="btn btn-info" value="เพิ่ม" onclick="window.location.href='${pageContext.request.contextPath}/form/${form.id}/view-drugs';return false;"class="add-button"/></c:if>
                            <input type="button" class="btn btn-danger" value="ลบ"
                                   onclick="if((confirm('คุณแน่ใจหรือว่าต้องการลบข้อมูลแบบฟอร์มนี้?'))) { window.location.href='${pageContext.request.contextPath}/form/${form.id}/delete'; return false; }"
                                   class="cancel-button"/>
                            <input type="button" class="btn btn-warning" value="ย้อนกลับ"
                                   onclick="window.location.href='${pageContext.request.contextPath}/form/list'; return false;"
                                   class="cancel-button"/>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form:form></div>
        </security:authorize>
    </div>
    </article>
</section>
<footer>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</footer>
</body></html>