<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>หน้าหลัก</title>
    <link href="${pageContext.request.contextPath}/assets/css/styleMon.css" rel="stylesheet">

</head>
<body style="font-family: Prompt; margin: 0px;">


    <div class="nav-shadow"></div>
    <jsp:include page="/WEB-INF/view/layouts/nav.jsp"/>
    <div class="big-box"></div>
        <h2 class="h_header">PharmarHome.</h2>

        <div class="area-box1"></div>
        <div class="area-box2">
            <img src="${pageContext.request.contextPath}/assets/image/home-1.jpg" style="height: 302px;">
        </div>

        <div class="area-box3">
            <p class="header-box">PharmarHome</p>
            <p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                The profession involves choosing, preparing, storing, compounding and dispensing medications for patients in a medical environment. Another important area is the provision of advice to both patients and other health professionals about the safe and effective use of medicines.</p>
        </div>

        <hr class="home-hr">
        <div class="square-box"></div>
        <div class="square-box1"></div>


    <div class="home-ft">
        <jsp:include page="/WEB-INF/view/layouts/footer.jsp"/>
    </div>


</body>
</html>
