<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>หน้าหลัก</title>
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
        <h1>London</h1>
        <p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
        <p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>
    </article>
</section>
<footer>
    <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
</footer>
</body>
</html>
