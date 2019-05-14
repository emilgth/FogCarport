<div class="container">
    <nav class="navbar navbar-expand">
        <div class="nav navbar-nav">
            <a class="navbar-brand" href="index.jsp"><img src="img/logo.png" class="img-fluid " alt="logo"></a>
            <table>

            </table>

            <form class="form-inline">
                <button type="button" class="btn btn-primary mr-1" data-toggle="modal" data-target="#login">
                    Log ind
                </button>
                <a href="register.jsp" class="btn btn-primary" role="button">Opret konto</a>
            </form>
        </div>
    </nav>
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
                    <input type="text" name="email" value="anders@email.com">
                    <br>
                    <p>Password:</p>
                    <input type="password" name="password" value="1234">
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