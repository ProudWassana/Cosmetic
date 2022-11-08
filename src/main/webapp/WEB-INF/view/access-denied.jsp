<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPEhtml>
<html>
<head>
    <title>${title}</title>
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
        <h1>Access Denied</h1><hr>
        <div class="container">
            <h2 style="text-align: center;">คุณไม่ได้รับอนุญาตให้เข้าถึงหน้าเว็บนี้</h2>
            <div style="text-align:center"><a href="${pageContext.request.contextPath}/">กลับไปหน้าแรก</a></div>
        </div>
    </article>
</section>
<footer>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</footer>


</body></html>