<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Carport med fladt tag</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon-16x16.png" sizes="16x16" />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../css.css">
</head>
<%@include file="include/loggedInHeader.jsp" %>

<body>
<div class="container mt-5 mb-5">
    <h1>CARPORT MED FLADT TAG</h1>
</div>
<div class="container-fluid background">
    <div class="container background pt-5 pb-5">
        <div class="row">
            <div class="col">
                <div class="list-group list-group-flush background">
                    <form action="FrontController?command=loggedInIndex" method="post">
                        <button class="list-group-item list-group-item-action font-weight-bold">QUICKBYG</button>
                    </form>
                    <form action="FrontController?command=flatRoofCheck" method="post">
                        <button class="list-group-item list-group-item-action">CARPORT MED FLADT TAG</button>
                    </form>
                    <form action="FrontController?command=withRoofCheck" method="post">
                        <button class="list-group-item list-group-item-action active">CARPORT MED REJSNING</button>
                    </form>
                </div>
            </div>
            <div class="col-6">
                <h3>QUICK-BYG TILBUD - CARPORT MED FLADT TAG</h3>
                <p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning
                    på en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.<br>

                    Tilbud og skitsetegning fremsendes med post hurtigst muligt.
                    Ved bestilling medfølger standardbyggevejledning.</p>
                <b>Udfyld nedenstående omhyggeligt og klik på "Bestil tilbud"</b>
                <p>Felter markeret * SKAL udfyldes!</p>
            </div>
            <div class="col">
                <img class="mx-auto d-block img-fluid rounded" src="../img/quickurejs.gif" alt="fladt tag">
            </div>
        </div>

        <!-- select table-->
        <form action="FrontController" method="post" class="">
            <input type="hidden" name="command" value="customerOrder">
            <div id="table" class="form-horizontal">
                <div class="form-group">
                                    <span>
                                    Ønskede carport mål:
                                    </span>
                </div>
                <div class="form-group">
                    <label title="Carport bredde" for="carport_bredde">Carport bredde</label>
                    <select class="form-control" id="carport_bredde" name="Carport_bredde" title="Carport bredde" required>
                        <option selected="selected" value="" disabled>Vælg bredde</option>
                        <option value="2400">240 cm</option>
                        <option value="2700">270 cm</option>
                        <option value="3000">300 cm</option>
                        <option value="3300">330 cm</option>
                        <option value="3600">360 cm</option>
                        <option value="3900">390 cm</option>
                        <option value="4200">420 cm</option>
                        <option value="4500">450 cm</option>
                        <option value="4800">480 cm</option>
                        <option value="5100">510 cm</option>
                        <option value="5400">540 cm</option>
                        <option value="5700">570 cm</option>
                        <option value="6000">600 cm</option>
                        <option value="6300">630 cm</option>
                        <option value="6600">660 cm</option>
                        <option value="6900">690 cm</option>
                        <option value="7200">720 cm</option>
                        <option value="7500">750 cm</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label title="Carport længde" for="carport_laengde">Carport længde</label>
                <select class="form-control" id="carport_laengde" name="Carport_laengde" title="Carport længde" required>
                    <option selected="selected" value="" disabled>Vælg længde</option>
                    <option value="2400">240 cm</option>
                    <option value="2700">270 cm</option>
                    <option value="3000">300 cm</option>
                    <option value="3300">330 cm</option>
                    <option value="3600">360 cm</option>
                    <option value="3900">390 cm</option>
                    <option value="4200">420 cm</option>
                    <option value="4500">450 cm</option>
                    <option value="4800">480 cm</option>
                    <option value="5100">510 cm</option>
                    <option value="5400">540 cm</option>
                    <option value="5700">570 cm</option>
                    <option value="6000">600 cm</option>
                    <option value="6300">630 cm</option>
                    <option value="6600">660 cm</option>
                    <option value="6900">690 cm</option>
                    <option value="7200">720 cm</option>
                    <option value="7500">750 cm</option>
                    <option value="7800">780 cm</option>
                </select>
            </div>
            <div class="form-group">
                <label title="Tag" for="tag">
                    <span>
                        <b>Tag</b>
                    </span>
                </label>
                <select class="form-control" id="tag" name="Tag" title="Tagtype/farve" required>
                    <option selected="selected" value="" disabled>Vælg tagtype/farve</option>
                    <option value="Betontagsten - Rød">Betontagsten - Rød</option>
                    <option value="Betontagsten - Teglrød">Betontagsten - Teglrød</option>
                    <option value="Betontagsten - Brun">Betontagsten - Brun</option>
                    <option value="Betontagsten - Sort">Betontagsten - Sort</option>
                    <option value="Eternittag B6 - Grå">Eternittag B6 - Grå</option>
                    <option value="Eternittag B6 - Sort">Eternittag B6 - Sort</option>
                    <option value="Eternittag B6 - Mokka (brun)">Eternittag B6 - Mokka (brun)</option>
                    <option value="Eternittag B6 - Rødbrun">Eternittag B6 - Rødbrun</option>
                    <option value="Eternittag B6 - Teglrød">Eternittag B6 - Teglrød</option>
                    <option value="Eternittag B7 - Grå">Eternittag B7 - Grå</option>
                    <option value="Eternittag B7 - Sort">Eternittag B7 - Sort</option>
                    <option value="Eternittag B7 - Mokka (brun)">Eternittag B7 - Mokka (brun)</option>
                    <option value="Eternittag B7 - Rødbrun">Eternittag B7 - Rødbrun</option>
                    <option value="Eternittag B7 - Teglrød">Eternittag B7 - Teglrød</option>
                    <option value="Eternittag B7 - Rødflammet">Eternittag B7 - Rødflammet</option>
                </select>
            </div>
            <div class="form-group">
                <label title="Taghældning" for="taghaeldning">
                    Taghældning
                </label>
                <select class="form-control" id="taghaeldning" name="Taghaeldning" title="Taghældning">
                    <option value="15">15 grader</option>
                    <option value="20">20 grader</option>
                    <option selected="selected" value="25">25 grader</option>
                    <option value="30">30 grader</option>
                    <option value="35">35 grader</option>
                    <option value="40">40 grader</option>
                    <option value="45">45 grader</option>
                </select>
            </div>
            <div class="form-group">
                <span><b>Redskabsrum:</b><br>NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet*</span>
            </div>
            <div class="form-group">
                <label title="Redskabsrum bredde" for="redskabsrum_bredde">Redskabsrum bredde</label>
                <select class="form-control" id="redskabsrum_bredde" name="Redskabsrum_bredde"
                        title="Redskabsrum bredde">
                    <option selected="selected" value="0">Ønsker ikke redskabsrum</option>
                    <option value="2100">210 cm</option>
                    <option value="2400">240 cm</option>
                    <option value="2700">270 cm</option>
                    <option value="3000">300 cm</option>
                    <option value="3300">330 cm</option>
                    <option value="3600">360 cm</option>
                    <option value="3900">390 cm</option>
                    <option value="4200">420 cm</option>
                    <option value="4500">450 cm</option>
                    <option value="4800">480 cm</option>
                    <option value="5100">510 cm</option>
                    <option value="5400">540 cm</option>
                    <option value="5700">570 cm</option>
                    <option value="6000">600 cm</option>
                    <option value="6300">630 cm</option>
                    <option value="6600">660 cm</option>
                    <option value="6900">690 cm</option>
                    <option value="7200">720 cm</option>
                </select>
            </div>

            <div class="form-group">
                <label title="Redskabsrum længde" for="redskabsrum_laengde">Redskabsrum længde</label>
                <select class="form-control" id="redskabsrum_laengde" name="Redskabsrum_laengde"
                        title="Redskabsrum længde">
                    <option selected="selected" value="0">Ønsker ikke redskabsrum</option>
                    <option value="1500">150 cm</option>
                    <option value="1800">180 cm</option>
                    <option value="2100">210 cm</option>
                    <option value="2400">240 cm</option>
                    <option value="2700">270 cm</option>
                    <option value="3000">300 cm</option>
                    <option value="3300">330 cm</option>
                    <option value="3600">360 cm</option>
                    <option value="3900">390 cm</option>
                    <option value="4200">420 cm</option>
                    <option value="4500">450 cm</option>
                    <option value="4800">480 cm</option>
                    <option value="5100">510 cm</option>
                    <option value="5400">540 cm</option>
                    <option value="5700">570 cm</option>
                    <option value="6000">600 cm</option>
                    <option value="6300">630 cm</option>
                    <option value="6600">660 cm</option>
                    <option value="6900">690 cm</option>
                </select>
            </div>
            <div class="form-group">
                <hr>
            </div>
            <div class="form-group">
                <label title="Evt. bemærkninger" for="bemaerkninger">Evt. bemærkninger</label>
                <textarea class="form-control" cols="20" id="bemaerkninger" name="bemaerkninger"
                          rows="2" placeholder="Indtast kommentar"></textarea>
            </div>
            <div class="form-group">
                <input type="submit" name="Submit" title="Send forespørgsel" value="Bestil tilbud"
                       class="btn btn-primary">
            </div>
        </form>

        <p>* Hvis du f.eks. har valgt en carport med målene 240x360 cm kan redskabsrummet maksimalt måle 210x330 cm.</p>
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
