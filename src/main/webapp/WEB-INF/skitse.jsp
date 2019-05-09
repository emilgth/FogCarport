<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
    <link rel="stylesheet" href="../css.css">
</head>
<body>

<div class="container-fluid background pt-5 pb-5">
    <div class="container">
        <h1>Tak for din forespørgsel!</h1>
        <p>Din forespørgsel er modtaget, vi vender tilbage snarest muligt med et tilbud. <br>
            Herunder kan du se en skitse af hvordan din carport vil se ud:</p>
        <p>Dette er en demo version!</p>
        <c:forEach items="${sessionScope.orderList}" var="order">
            <tr>
                <td>Email: ${order.getUser().getEmail()}</td>
                <br>
                <td>Navn: ${order.getUser().getSurname()}</td>
                <td> ${order.getUser().getLastname()}</td>
            </tr>
            <table class='table table-condensed table-striped table-hover'>
                <tr>
                    <th>Materiale</th>
                    <th>Længde</th>
                    <th>Antal</th>
                    <th>Enhed</th>
                    <th>Beskrivelse</th>
                </tr>
                <c:forEach items="${sessionScope.orderLineList}" var="orderLine">
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
        </c:forEach>
        <hr>

        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
             height="80%"
             viewBox="0 0 830 650"
             preserveAspectRatio="xMinYMin">

            <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                 x="50"
                 y="0"
                 width="780" height="600"
                 viewBox="0 0 780 600"
                 preserveAspectRatio="xMinYMin">

                <!-- Ramme -->
                <rect x="0" y="0" height="600" width="780" style="stroke:black; fill:white;"/>

                <!-- Remme -->
                <rect x="0" y="35" height="4.5" width="780" style="stroke:black; fill:white;"/>
                <rect x="0" y="560.5" height="4.5" width="780" style="stroke:black; fill:white;"/>

                <!-- Vindkryds -->
                <line x1="52.5" y1="35" x2="552.5" y2="565" style="stroke:black; stroke-dasharray:5 5;"/>
                <line x1="57.5" y1="35" x2="557.5" y2="565" style="stroke:black; stroke-dasharray:5 5; stroke-dashoffset:3.8"/>
                <line x1="52.5" y1="565" x2="552.5" y2="35" style="stroke:black; stroke-dasharray:5 5;"/>
                <line x1="57.5" y1="565" x2="557.5" y2="35" style="stroke:black; stroke-dasharray:5 5; stroke-dashoffset:3.8"/>

                <!-- Spær -->
                <rect x="0" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="55" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="110" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="165" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="220" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="275" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="330" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="385" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="440" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="495" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="550" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="605" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="660" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="715" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>
                <rect x="770" y="0" height="600" width="4.5" style="stroke:black; fill:white;"/>

            </svg>

            <!-- Arrow definition -->
            <defs>
                <marker id="beginArrow"
                        markerWidth="9" markerHeight="9"
                        refX="0" refY="4"
                        orient="auto">
                    <path d="M0,4 L8,0 L8,8 L0,4" style="fill: #000000s;" />
                </marker>
                <marker id="endArrow"
                        markerWidth="9" markerHeight="9"
                        refX="8" refY="4"
                        orient="auto">
                    <path d="M0,0 L8,4 L0,8 L0,0" style="fill: #000000;" />
                </marker>
            </defs>

            <line x1="10"  y1="0" x2="10"   y2="600"
                  style="stroke:black;
	marker-start: url(#beginArrow);
   marker-end: url(#endArrow);"/>

            <text transform="rotate(-90 23,300)" x="23" y="300">600cm</text>

            <line x1="30"  y1="35" x2="30"   y2="565"
                  style="stroke:black;
	marker-start: url(#beginArrow);
   marker-end: url(#endArrow);"/>

            <text transform="rotate(-90 44,282.5)" x="44" y="282.5">530cm</text>

            <line x1="50"  y1="630" x2="830"   y2="630"
                  style="stroke:black;
	marker-start: url(#beginArrow);
   marker-end: url(#endArrow);"/>

            <text x="430" y="626">780cm</text>

        </svg>
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
