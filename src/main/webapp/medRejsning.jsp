<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Carport med rejsning</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" href="img/favicon-16x16.png" sizes="16x16" />

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css.css">
</head>

<%@include file="WEB-INF/include/header.jsp" %>
<body>
<div class="container mt-5 mb-5">
    <h1>CARPORT MED REJSNING</h1>
    <p class="lead">Bemærk at det er nødvændigt at være logget ind for at bestille en carport - log ind eller registrer
        Dem venligst i toppen af siden</p>

</div>
<div class="container-fluid background">
    <div class="container background pt-5 pb-5">
        <div class="row">
            <div class="col">
                <div class="list-group list-group-flush background">
                    <button class="list-group-item list-group-item-action font-weight-bold">QUICKBYG</button>
                    <button class="list-group-item list-group-item-action">CARPORT MED FLADT TAG</button>
                    <button class="list-group-item list-group-item-action active">CARPORT MED REJSNING</button>
                </div>
            </div>
            <div class="col-6">
                <h3>QUICK-BYG TILBUD - CARPORT MED REJSNING</h3>
                <p>Med et specialudviklet computerprogram kan vi lynhurtigt beregne prisen og udskrive en skitsetegning
                    på<br>
                    en carport indenfor vores standardprogram, der tilpasses dine specifikke ønsker.<br><br>

                    Tilbud og skitsetegning fremsendes med post hurtigst muligt.<br>
                    Ved bestilling medfølger standardbyggevejledning.</p><br>
                <b>Udfyld nedenstående omhyggeligt og klik på "Bestil tilbud"</b>
                <p>Felter markeret * SKAL udfyldes!</p>
            </div>
            <div class="col">
                <img class="mx-auto d-block img-fluid rounded" src="img/quickmrejs.gif" alt="fladt tag">
            </div>
        </div>

        <!-- select table-->
        <form action="success.jsp" method="post" class="">
            <div id="table" class="form-horizontal">
                <div class="form-group">
                                    <span>
                                    Ønskede carport mål:
                                    </span>
                </div>
                <div class="form-group">
                    <label title="Carport bredde" for="carport_bredde">Carport bredde</label>
                    <select class="form-control" id="carport_bredde" name="Carport_bredde" title="Carport bredde">
                        <option selected="selected" value="">Vælg bredde</option>
                        <option value="240 cm">240 cm</option>
                        <option value="270 cm">270 cm</option>
                        <option value="300 cm">300 cm</option>
                        <option value="330 cm">330 cm</option>
                        <option value="360 cm">360 cm</option>
                        <option value="390 cm">390 cm</option>
                        <option value="420 cm">420 cm</option>
                        <option value="450 cm">450 cm</option>
                        <option value="480 cm">480 cm</option>
                        <option value="510 cm">510 cm</option>
                        <option value="540 cm">540 cm</option>
                        <option value="570 cm">570 cm</option>
                        <option value="600 cm">600 cm</option>
                        <option value="630 cm">630 cm</option>
                        <option value="660 cm">660 cm</option>
                        <option value="690 cm">690 cm</option>
                        <option value="720 cm">720 cm</option>
                        <option value="750 cm">750 cm</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label title="Carport længde" for="carport_laengde">Carport længde</label>
                <select class="form-control" id="carport_laengde" name="Carport_laengde" title="Carport længde">
                    <option selected="selected" value="">Vælg længde</option>
                    <option value="240 cm">240 cm</option>
                    <option value="270 cm">270 cm</option>
                    <option value="300 cm">300 cm</option>
                    <option value="330 cm">330 cm</option>
                    <option value="360 cm">360 cm</option>
                    <option value="390 cm">390 cm</option>
                    <option value="420 cm">420 cm</option>
                    <option value="450 cm">450 cm</option>
                    <option value="480 cm">480 cm</option>
                    <option value="510 cm">510 cm</option>
                    <option value="540 cm">540 cm</option>
                    <option value="570 cm">570 cm</option>
                    <option value="600 cm">600 cm</option>
                    <option value="630 cm">630 cm</option>
                    <option value="660 cm">660 cm</option>
                    <option value="690 cm">690 cm</option>
                    <option value="720 cm">720 cm</option>
                    <option value="750 cm">750 cm</option>
                    <option value="780 cm">780 cm</option>
                </select>
            </div>
            <div class="form-group">
                <label title="Tag" for="tag">
                    <span>
                        <b>Tag</b>
                    </span>
                </label>
                <select class="form-control" id="tag" name="Tag" title="Tagtype/farve">
                    <option selected="selected" value="">Vælg tagtype/farve</option>
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
                    <option value="15 grader">15 grader</option>
                    <option value="20 grader">20 grader</option>
                    <option selected="selected" value="25 grader">25 grader</option>
                    <option value="30 grader">30 grader</option>
                    <option value="35 grader">35 grader</option>
                    <option value="40 grader">40 grader</option>
                    <option value="45 grader">45 grader</option>
                </select>
            </div>

            <div class="form-group">
                <span><b>Redskabsrum:</b><br>NB! Der skal beregnes 15 cm tagudhæng på hver side af redskabsrummet*</span>
            </div>
            <div class="form-group">
                <label title="Redskabsrum bredde" for="Redskabsrum bredde">Redskabsrum bredde</label>
                <select class="form-control" id="Redskabsrum bredde" name="Redskabsrum_bredde"
                        title="Redskabsrum bredde">
                    <option selected="selected" value="Ønsker ikke redskabsrum">Ønsker ikke redskabsrum</option>
                    <option value="210 cm">210 cm</option>
                    <option value="240 cm">240 cm</option>
                    <option value="270 cm">270 cm</option>
                    <option value="300 cm">300 cm</option>
                    <option value="330 cm">330 cm</option>
                    <option value="360 cm">360 cm</option>
                    <option value="390 cm">390 cm</option>
                    <option value="420 cm">420 cm</option>
                    <option value="450 cm">450 cm</option>
                    <option value="480 cm">480 cm</option>
                    <option value="510 cm">510 cm</option>
                    <option value="540 cm">540 cm</option>
                    <option value="570 cm">570 cm</option>
                    <option value="600 cm">600 cm</option>
                    <option value="630 cm">630 cm</option>
                    <option value="660 cm">660 cm</option>
                    <option value="690 cm">690 cm</option>
                    <option value="720 cm">720 cm</option>
                </select>
            </div>

            <div class="form-group">
                <label title="Redskabsrum længde" for="redskabsrum_laengde">Redskabsrum længde</label>
                <select class="form-control" id="redskabsrum_laengde" name="Redskabsrum_laengde"
                        title="Redskabsrum længde">
                    <option selected="selected" value="Ønsker ikke redskabsrum">Ønsker ikke redskabsrum</option>
                    <option value="150 cm">150 cm</option>
                    <option value="180 cm">180 cm</option>
                    <option value="210 cm">210 cm</option>
                    <option value="240 cm">240 cm</option>
                    <option value="270 cm">270 cm</option>
                    <option value="300 cm">300 cm</option>
                    <option value="330 cm">330 cm</option>
                    <option value="360 cm">360 cm</option>
                    <option value="390 cm">390 cm</option>
                    <option value="420 cm">420 cm</option>
                    <option value="450 cm">450 cm</option>
                    <option value="480 cm">480 cm</option>
                    <option value="510 cm">510 cm</option>
                    <option value="540 cm">540 cm</option>
                    <option value="570 cm">570 cm</option>
                    <option value="600 cm">600 cm</option>
                    <option value="630 cm">630 cm</option>
                    <option value="660 cm">660 cm</option>
                    <option value="690 cm">690 cm</option>
                </select>
            </div>
            <div class="form-group">
                <hr>
            </div>
            <div class="form-group">
                <label title="Evt. bemærkninger" for="bemaerkninger">Evt. bemærkninger</label>
                <textarea class="form-control" cols="20" id="bemaerkninger" name="bemaerkninger" rows="2"></textarea>
            </div>

            <div class="form-group">
                <input type="submit" name="Submit" title="Send forespørgsel" value="Bestil tilbud"
                       class="btn btn-primary" disabled>
                Log ind for at bestille
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
<%@include file="WEB-INF/include/footer.jsp" %>
</body>
</html>