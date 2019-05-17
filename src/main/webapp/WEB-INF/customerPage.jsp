<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Kundeside</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../css.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
          integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
</head>
<body>

<%@include file="include/loggedInHeader.jsp" %>


<div class="container mt-5 mb-5">
    <h1>Kundeside</h1>
    <h2>Velkommen ${sessionScope.user.surname}</h2>
</div>

<div class="container-fluid background mt-5 mb-5">
    <div class="container background  pt-5 pb-5">

        <p>Mine info: </p>
        <p><i class='far fa-address-book'></i> ${sessionScope.user.surname} ${sessionScope.user.lastname}</p>
        <p><i class='far fa-envelope'></i> ${sessionScope.user.email}</p>
        <p><i class='fas fa-mobile-alt'></i> ${sessionScope.user.phone}</p>

        <form name="showCustomerOrders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="showCustomerOrder">
            <button class="btn btn-primary" type="submit" value="Se mine ordrer ordrer">Se mine ordrer</button>
        </form>

        <br><br>

        <button type="button" class="btn btn-primary mr-1" data-toggle="modal" data-target="#updateUserInfo">
            Redigér mine info
        </button>
    </div>
</div>

<!-- The Modal -->
<div class="modal" id="updateUserInfo">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Indtast nye info her</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form name="updateUserData" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="updateUserData">
                    <p>E-mail:</p>
                    <input type="email" name="email" value="${sessionScope.user.email}">
                    <br>
                    <p>Telefon:</p>
                    <input type="tel" name="phone" value="${sessionScope.user.phone}">
                    <p>Fornavn:</p>
                    <input type="text" name="surname" value="${sessionScope.user.surname}">
                    <p>Efternavn:</p>
                    <input type="text" name="lastname" value="${sessionScope.user.lastname}">
                    <p>Password:</p>
                    <input type="password" name="password" value="${sessionScope.user.password}">
                    <br><br>
                    <input class="btn btn-primary" type="submit" value="Accepter">
                </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Afslut</button>
            </div>

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