<%--
  Created by IntelliJ IDEA.
  User: karlf
  Date: 13-05-2019
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon-16x16.png" sizes="16x16" />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css.css">
</head>
<%@include file="include/loggedInHeader.jsp" %>
<body>
<div class="container" style="padding-bottom: 200px">
    <h1>Alle Ordre</h1>
    <div class="container-fluid background">
        <div class="container background pt-5 pb-5">
            <p>Alle mål er i millimeter</p>
            <div class="table-responsive">
                <table class='table table-condensed table-striped table-hover'>
                    <tr>
                        <th>Name</th>
                        <th>Ordre ID</th>
                        <th>Status</th>
                        <th>Pris</th>
                        <th>Tag</th>
                        <th>Tagvinkel</th>
                        <th>Længde</th>
                        <th>Bredde</th>
                        <th>Højde</th>
                        <th>Skurlængde</th>
                        <th>Skurbredde</th>
                        <th>Kommentar</th>
                    </tr>
                    <c:forEach items="${requestScope.orders}" var="orders">
                        <tr>
                            <td>${orders.getUser().getSurname()} ${orders.getUser().getLastname()}</td>
                            <td>${orders.getOrderId()}</td>
                            <td>${orders.getStatus()}</td>
                            <td>${orders.getPrice()}</td>
                            <td>${orders.getRoofId()}</td>
                            <td>${orders.getAngle()}</td>
                            <td>${orders.getLength()}</td>
                            <td>${orders.getWidth()}</td>
                            <td>${orders.getHeight()}</td>
                            <td>${orders.getShedLength()}</td>
                            <td>${orders.getShedWidth()}</td>
                            <td>${orders.getComment()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
    </div>
</div>
<%@include file="include/footer.jsp" %>
</body>
</html>
