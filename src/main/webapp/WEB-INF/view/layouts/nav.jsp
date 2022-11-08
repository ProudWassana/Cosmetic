<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<form:form action="${pageContext.request.contextPath}/logout" method="POST" name="frmLogout"></form:form>


<nav>
    <ul>

        <li><a href="${pageContext.request.contextPath}">${'หน้าหลัก'}</a></li>
        <security:authorize access="hasRole('MANAGER')">
            <li><a href="${pageContext.request.contextPath}/form/list">${'ใบแจ้งอาการ'}</a></li>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            <li><a href="${pageContext.request.contextPath}/form/list">${'ใบแจ้งอาการ'}</a></li>
        </security:authorize>

        <security:authorize access="hasRole('ADMIN')">
            <li><a href="${pageContext.request.contextPath}/drug/list">${'รายการยา'}</a></li>
        </security:authorize>
        <hr>
        <security:authorize access="!isAuthenticated()">
            <li><a href="${pageContext.request.contextPath}/login">${'เข้าสู่ระบบ'}</a></li>
        </security:authorize>


        <security:authorize access="isAuthenticated()">
            <li><b>User : </b><security:authentication property="principal.username" /></li>
            <li><b>Role : </b><security:authentication property="principal.authorities" /></li>
            <li><a href="#" onclick="javascript: frmLogout.submit();">${'ออกจากระบบ'}</a></li>
        </security:authorize>

    </ul>
</nav>
<hr>
