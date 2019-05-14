<%--
  Created by IntelliJ IDEA.
  User: karlf
  Date: 13-05-2019
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>


</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand">
        <div class="nav navbar-nav">
            <a class="navbar-brand" href="index.jsp"><img src="img/logo.png" class="img-fluid " alt="logo"></a>
            <table>

            </table>

            <form class="form-inline">
                <button type="button" class="btn btn-primary mr-1" data-toggle="modal" data-target="#login">
                    Log ind </button>
                <a href="../register.jsp" class="btn btn-primary" role="button">Opret konto</a>
                <a href="../customerPage.jsp" class="btn btn-primary" role="button">Min side</a>

                <!-- Small modal -->
                <button class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Log ud</button>

                <div class="modal bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content">
                            <div class="modal-header"><h4>Logout <i class="fa fa-lock"></i></h4></div>
                        </div>
                    </div>
                </div>

            </form>



        </div>
    </nav>



</div>
</body>
</html>
