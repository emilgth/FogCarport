<link rel="stylesheet" type="text/css" href="css.css">

<div class="container">
    <nav class="navbar navbar-expand">
        <div class="nav navbar-nav">
            <form name="loggedInIndex" action="FrontController" method="post">
                <input type="hidden" name="command" value="loggedInIndex">
                <a class="navbar-brand" href="FrontController?name=command&value=loggedInIndex"><img
                        src="img/logo.png" class="img-fluid " alt="logo"></a>
            </form>
            <div class="form-inline">
                <form name="customerPage" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="customerPage">
                    <button class="btn btn-link" type="submit" value="Se mine ordrer ordrer">Min side</button>
                </form>
                <form name="logOut" action="FrontController" method="post">
                    <input type="hidden" name="command" value="logOut">
                    <button class="btn btn-link" type="submit">Log ud</button>
                </form>
            </div>
        </div>
    </nav>
    <% String besked = (String) request.getAttribute("message");
        String status = (String) request.getAttribute("status");
        if (besked != null && status != null) {
            String alert = "";
            if (status.equals("ok")) {
                alert = "<div class=\"alert alert-success\">_message_</div>";
            } else {
                alert = "<div class=\"alert alert-danger\">_message_</div>";
            }
            alert = alert.replace("_message_", besked);
            out.println(alert);
        }
    %>
</div>



