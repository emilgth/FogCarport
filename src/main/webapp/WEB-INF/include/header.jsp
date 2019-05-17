<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <nav class="navbar navbar-expand navbar-collapse">
        <img src="img/logo.png" class="img-fluid navbar-brand" alt="logo">
        <div class="container">
            <form class="form-inline">
                <button type="button" class="btn btn-link mr-1" data-toggle="modal" data-target="#login">
                    LOG IND
                </button>
                <a href="register.jsp" class="btn btn-link" role="button">OPRET KONTO</a>
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
<div class="modal" id="login">
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
                    <p>Email:</p>
                    <input class="form-control" type="text" name="email" placeholder="email" value="anders@email.com"
                           required>
                    <br>
                    <p>Password:</p>
                    <input class="form-control" type="password" name="password" placeholder="password" value="1234"
                           required>
                    <br><br>
                    <input class="btn btn-primary" type="submit" value="Login">
                </form>
            </div>
            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>