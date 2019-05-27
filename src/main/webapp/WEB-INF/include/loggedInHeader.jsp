<div class="container">
    <nav class="navbar navbar-expand navbar-collapse">
        <a class="navbar-brand" href="FrontController?command=loggedInIndex"><img src="img/logo.png" class="img-fluid" alt="logo"></a>
        <div class="container">
            <div class="form-inline">
                <form name="customerPage" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="customerPage">
                    <button class="btn btn-link" type="submit" value="Se mine ordrer ordrer">MIN SIDE</button>
                </form>
                <button type="button" class="btn btn-link" data-toggle="modal" data-target="#logout">
                    LOG UD
                </button>
            </div>
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

<!-- Button trigger modal -->
<form name="logOut" action="FrontController" method="post">
    <input type="hidden" name="command" value="logOut">
    <button class="btn btn-link" type="submit">LOG UD</button>
</form>

<!-- Modal -->
<div class="modal fade" id="logout">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title">Er du sikker?</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">Fortryd</button>
                <form name="logOut" action="FrontController" method="post">
                    <input type="hidden" name="command" value="logOut">
                    <button class="btn btn-danger" type="submit">Log ud</button>
                </form>
            </div>
        </div>
    </div>
</div>



