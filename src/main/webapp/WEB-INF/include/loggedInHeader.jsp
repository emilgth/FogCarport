<div class="container">
    <nav class="navbar navbar-expand navbar-collapse">
        <img src="img/logo.png" class="img-fluid navbar-brand" alt="logo">
        <div class="container">
            <div class="form-inline">
                <form name="customerPage" action="FrontController" method="POST">
                    <input type="hidden" name="command" value="customerPage">
                    <button class="btn btn-link" type="submit" value="Se mine ordrer ordrer">MIN SIDE</button>
                </form>
                <form name="logOut" action="FrontController" method="post">
                    <input type="hidden" name="command" value="logOut">
                    <button class="btn btn-link" type="submit">LOG UD</button>
                </form>
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



