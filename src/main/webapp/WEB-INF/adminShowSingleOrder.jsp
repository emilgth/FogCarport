<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Ordre ${requestScope.order.orderId}</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon-16x16.png" sizes="16x16" />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
          integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
</head>
<body>
<%@include file="include/loggedInHeader.jsp" %>
<div class="container-fluid background pt-5 pb-5">
    <div class="container">

        <p>
            <i class='far fa-address-book'></i> ${requestScope.order.getUser().getSurname()} ${requestScope.order.getUser().getLastname()}
        </p>
        <p><i class='far fa-envelope'></i> ${requestScope.order.getUser().getEmail()}</p>
        <p><i class='fas fa-mobile-alt'></i> ${requestScope.order.getUser().getPhone()}</p>

        <div class="table-responsive">
            <table class='table table-condensed table-striped table-hover'>
                <tr>
                    <th>Materiale</th>
                    <th>Længde</th>
                    <th>Antal</th>
                    <th>Enhed</th>
                    <th>Beskrivelse</th>
                </tr>
                <c:forEach items="${requestScope.orderLineList}" var="orderLine">
                    <tr>
                        <td>
                                ${orderLine.getMaterial().getWidth()}x${orderLine.getMaterial().getHeight()}mm.
                                ${orderLine.getMaterial().getName()}
                        </td>
                        <td>${orderLine.getMaterial().getLength()}</td>
                        <td>${orderLine.getAmount()}</td>
                        <td>${orderLine.getMaterial().getUnit()}</td>
                        <td>${orderLine.getDescription()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="container">
            <div class="row">
                <div class="col">
                    <c:forEach items="${requestScope.svgTopList}" var="svgTopList">
                        ${svgTopList.getModel()}
                    </c:forEach>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <c:forEach items="${requestScope.svgSideList}" var="svgSideList">
                        ${svgSideList.getModel()}
                    </c:forEach>
                </div>
            </div>
        </div>
        <hr>

        <div class="row">
            <div class="col">
                <p>Materialepris pris: ${requestScope.order.price}</p>
                <p>Materialepris + 25%: ${requestScope.suggestedPrice}</p>
                <div class="form-group">
                    <form name="confirmOrder" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="confirmOrder">
                        <input type="hidden" name="orderId" value="${requestScope.order.orderId}">
                        <label for="newPrice">Indtast ønsket salgspris:</label>
                        <input type="text" class="form-control" id="newPrice"
                               placeholder="${requestScope.suggestedPrice}"
                               name="newPrice" value="" required>
                        <button class="btn btn-primary mt-1" type="submit">Bekræft</button>
                    </form>
                </div>
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
<%@include file="include/footer.jsp" %>
</body>
</html>