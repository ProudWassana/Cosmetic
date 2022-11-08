<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>${title}</title>
    <link href="${pageContext.request.contextPath}/assets/css/login.css" rel="stylesheet">
</head>
<body>
<div class="container">
        <div class="row">
            <h2 style="text-align:center">${title}</h2>
            <div class="vl">
                <span class="vl-innertext">or</span>
            </div>

            <div class="col">
                <a href="#" class="fb btn">
                    <i class="fa fa-facebook fa-fw"></i> Login with Facebook
                </a>
                <a href="#" class="twitter btn">
                    <i class="fa fa-twitter fa-fw"></i> Login with Twitter
                </a>
                <a href="#" class="google btn"><i class="fa fa-google fa-fw">
                </i> Login with Google+
                </a>
            </div>

            <div class="col">
                <div class="hide-md-lg">
                    <p>Or sign in manually:</p>
                </div>
                <form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
                    <input type="text" name="username" placeholder="Username" required>
                    <input type="password" name="password" placeholder="Password" required>
                    <input type="submit" value="Login">
                </form:form>
                <c:if test="${param.error != null}">ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง</c:if><c:if
                    test="${param.logout != null}">คุณออกจากระบบแล้ว</c:if>
            </div>

        </div>
</div>
<jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</body>
</html>