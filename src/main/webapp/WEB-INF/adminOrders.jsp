<%--
  Created by IntelliJ IDEA.
  User: karlf
  Date: 13-05-2019
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../WEB-INF/include/header.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container" style="padding-bottom: 200px">
    <h1>Alle Ordre</h1>
    <div class="container-fluid">
        <div class="container background pt-5 pb-5">
            <p>Alle mål er i millimeter</p>
            <c:forEach items="${requestScope.orders}" var="orders">
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
                </table>
            </c:forEach>
        </div>
    </div>
</div>

</body>
</html>
