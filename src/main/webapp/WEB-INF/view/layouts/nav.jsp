<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="${pageContext.request.contextPath}/logout" method="POST" name="frmLogout"></form:form>
<link href="${pageContext.request.contextPath}/assets/css/styleMon.css" rel="stylesheet">

<nav>
        <a href="${pageContext.request.contextPath}">${'หน้าหลัก'}</a>
        <security:authorize access="hasRole('MANAGER')">
            <a href="${pageContext.request.contextPath}/form/list">${'ใบแจ้งอาการ'}</a>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            <a href="${pageContext.request.contextPath}/form/list">${'ใบแจ้งอาการ'}</a>
        </security:authorize>

        <security:authorize access="hasRole('ADMIN')">
            <a href="${pageContext.request.contextPath}/drug/list">${'รายการยา'}</a>
        </security:authorize>

        <security:authorize access="!isAuthenticated()">
            <a href="${pageContext.request.contextPath}/login">${'เข้าสู่ระบบ'}</a>
        </security:authorize>

        <security:authorize access="isAuthenticated()">
            <b>User : </b><security:authentication property="principal.username" />
            <b>Role : </b><security:authentication property="principal.authorities" />
            <a href="#" onclick="javascript: frmLogout.submit();">${'ออกจากระบบ'}</a>
        </security:authorize>

</nav>
