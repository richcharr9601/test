<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="javascript/register.js"></script>
</head>
<body>
<div id="register">
    <div class="container">
        <div id="login-row" class="justify-content-center align-items-center d-flex mt-auto vh-100">
            <div id="login-column" class="col-md-6 bg-light d-flex justify-content-center p-0">
                <div id="login-box" class="col-md-12 border rounded">
                    <form id="login-form" class="form" action="<%=request.getContextPath()%>/register" method="post">
                        <h4 class="header pt-3 border-bottom">Register</h4>
                        <div class="form-group">
                            <p id="validate-username" class="text-danger pb-0 mb-0 mt-3"></p>
                            <input type="text" name="username" id="username" class="form-control" placeholder="Username" onblur="validateUsername()" onkeypress="alertUsernameChange()">
                        </div>
                        <div class="form-group">
                            <p id="validate-email" class="text-danger pb-0 mb-0 mt-3"></p>
                            <input type="text" name="email" id="email" class="form-control" placeholder="E-mail" onblur="validateEmail()" onkeypress="alertEmailChange()">
                        </div>
                        <div class="form-group">
                            <p id="validate-password" class="text-danger pb-0 mb-0"></p>
                            <input type="password" name="password" id="password" class="form-control" placeholder="Password" onblur="validatePassword()" onkeypress="alertPasswordChange()">
                        </div>
                        <div class="form-group">
                            <p id="validate-rePassword" class="text-danger pb-0 mb-0"></p>
                            <input type="password" name="rePassword" id="rePassword" class="form-control" placeholder="Re-Password" onblur="validateRePassword()" onkeypress="alertRePasswordChange()">
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" class="btn btn-success btn-md col" value="Register" >
                        </div>
                        <div id="register-link" class="text-left">
                            <a href="login.jsp" class="text-info">Click here to login</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
