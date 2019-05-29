<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <nav class="navbar navbar-expand navbar-collapse">
        <a class="navbar-brand" href="index.jsp"><img src="img/logo.png" class="img-fluid" alt="logo"></a>
        <div class="container">
            <form class="form-inline">
                <button type="button" class="btn btn-link mr-1" data-toggle="modal" data-target="#login">
                    LOG IND
                </button>
                <button type="button" class="btn btn-link mr-1" data-toggle="modal" data-target="#register">
                    OPRET BRUGER
                </button>
            </form>
        </div>
    </nav>
    <% String besked = (String) request.getAttribute("message");
        String status = (String) request.getAttribute("status");
        if (besked != null && status != null) {
            String alert = "";
            if (status.equals("ok")) {
                alert = "<div class=\"alert alert-success mt-1\">_message_</div>";
            } else {
                alert = "<div class=\"alert alert-danger mt-1\">_message_</div>";
            }
            alert = alert.replace("_message_", besked);
            out.println(alert);
        }
    %>
</div>


<!-- The Modal -->
<div class="modal fade" id="login">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Log ind</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form name="login" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="login">
                    <label> E-mail:
                        <input class="form-control" type="text" name="email" placeholder="email"
                               value=""
                               required>
                    </label>
                    <br>
                    <label> Password:
                        <input class="form-control" type="password" name="password" placeholder="password" value=""
                               required>
                    </label>
                    <br><br>
                    <input class="btn btn-primary" type="submit" value="Login">
                </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer background">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>
<div class="modal fade" id="register">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Registrering</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form name="register" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="register">
                    <label>
                        E-mail
                        <input class="form-control" type="email" name="email" required/>
                    </label>
                    <label>
                        Kodeord
                        <input class="form-control" type="password" name="password" required/>
                    </label>

                    <label>
                        Fornavn
                        <input class="form-control" type="text" name="surname" required/>
                    </label>

                    <label>
                        Efternavn
                        <input class="form-control" type="text" name="lastname" required/>
                    </label>

                    <label>
                        Telefonnummer
                        <input class="form-control" type="number" name="phone" required/>
                    </label>
                    <br>
                    <input class="btn btn-primary" type="submit" value="Submit">
                </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer background">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>