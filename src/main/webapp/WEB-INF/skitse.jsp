<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<html>
<head>
    <title>Demo</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css.css">
</head>
<body>
<%@include file="include/loggedInHeader.jsp"%>
<div class="container-fluid background pt-5 pb-5">
    <div class="container">
        <p>Herunder kan du se en skitse af hvordan din carport vil se ud:</p>

        <div class="container" style="max-width: 60%">
            <c:forEach items="${sessionScope.svgTopList}" var="svgTopList">
                ${svgTopList.getModel()}
            </c:forEach>
            <c:forEach items="${sessionScope.svgSideList}" var="svgSideList">
                ${svgSideList.getModel()}
            </c:forEach>
        </div>
        <hr>

        <form action="FrontController?command=customerOrderRequest" method="post">
            <button class="btn btn-primary">Bestil</button>
        </form>
            <button onclick="goBack()" class="btn btn-danger">Fortryd</button>
    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>
