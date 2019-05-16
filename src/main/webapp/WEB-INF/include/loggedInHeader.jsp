<link rel="stylesheet" type="text/css" href="css.css">

<div class="container">
    <nav class="navbar navbar-expand">
        <div class="nav navbar-nav">
            <form name="loggedInIndex" action="FrontController" method="post">
                <input type="hidden" name="command" value="loggedInIndex">
                <a class="navbar-brand" href="FrontController?name=command&value=loggedInIndex"><img
                        src="img/logo.png" class="img-fluid " alt="logo"></a>
            </form>

            <form class="form-inline btn-group" name="customerPage" action="FrontController" method="POST">
                <input type="hidden" name="command" value="customerPage">
                <button class="btn btn-link" type="submit" value="Se mine ordrer ordrer">Min side</button>
                <button class="btn btn-link" data-toggle="modal" data-target=".bs-example-modal-sm">Log ud
                </button>
            </form>

            <!-- Small modal -->
            <div class="modal bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                        <div class="modal-header"><h4>Logout <i class="fa fa-lock"></i></h4></div>
                        <div class="modal-body"><i class="fa fa-question-circle"></i> Are you sure you want to
                            log-off?
                        </div>
                        <div class="modal-footer"><a href="javascript:"
                                                     class="btn btn-primary btn-block">Logout</a></div>
                    </div>
                </div>
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



