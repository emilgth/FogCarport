<%--
  Created by IntelliJ IDEA.
  User: karlf
  Date: 09-05-2019
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>QuickByg</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css.css">
    <link rel="icon" type="image/png" href="img/favicon-16x16.png" sizes="16x16" />

</head>
<body>
<%@include file="WEB-INF/include/header.jsp"%>
<div class="container mt-5 mb-5">
    <h1>Opret konto</h1>
</div>

<div class="container-fluid background">
    <div class="container background pt-5 pb-5">
        <h1>Fog Register formular</h1>
        <form name="register" action="FrontController" method="POST">
            <input type="hidden" name="command" value="register">
            <table style="with: 50%">
                <tr>
                    <td>E-mail</td>
                    <td><input type="text" name="email" /></td>
                </tr>
                <tr>
                    <td>Kodeord</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td>Fornavn</td>
                    <td><input type="text" name="surname" /></td>
                </tr>
                <tr>
                    <td>Efternavn</td>
                    <td><input type="text" name="lastname" /></td>
                </tr>
                <tr>
                    <td>Telefonnummer</td>
                    <td><input type="text" name="phone" /></td>
                </tr>
                </table>
            <input type="submit" value="Submit">
        </form>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<%@include file="WEB-INF/include/footer.jsp" %>
</body>
</html>
