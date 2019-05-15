<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Nye ordrer</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%@include file="include/loggedInHeader.jsp" %>
<div class="container" style="padding-bottom: 200px">
    <h1>Nye Ordrer</h1>
    <div class="container-fluid">
        <div class="container background pt-5 pb-5">
            <p>Alle mål er i millimeter</p>
            <table class='table table-condensed table-striped table-hover'>
                <tr>
                    <th>Name</th>
                    <th>Ordre ID</th>
                    <th>Pris</th>
                    <th>Tag</th>
                    <th>Tagvinkel</th>
                    <th>Længde</th>
                    <th>Bredde</th>
                    <th>Højde</th>
                    <th>Skurlængde</th>
                    <th>Skurbredde</th>
                    <th>Kommentar</th>
                    <th></th>
                </tr>
                <c:forEach items="${requestScope.orders}" var="orders">
                    <tr>
                        <td>${orders.getUser().getSurname()} ${orders.getUser().getLastname()}</td>
                        <td>${orders.getOrderId()}</td>
                        <td>${orders.getPrice()},-</td>
                        <td>${orders.getRoofId()}</td>
                        <td>${orders.getAngle()}</td>
                        <td>${orders.getLength()}</td>
                        <td>${orders.getWidth()}</td>
                        <td>${orders.getHeight()}</td>
                        <td>${orders.getShedLength()}</td>
                        <td>${orders.getShedWidth()}</td>
                        <td>${orders.getComment()}</td>
                        <td><form name="adminShowSingleOrder" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="adminShowSingleOrder">
                            <input type="hidden" name="orderId" value="${orders.getOrderId()}">
                            <button class="btn btn-primary" type="submit">Se ordre</button>
                        </form></td>
                    </tr>
                </c:forEach>
            </table>

        </div>
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
</body>
</html>
