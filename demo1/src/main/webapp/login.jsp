<%@page import="com.example.demo1.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">

</head>
<body>
<div id="login">
    <div class="container">
        <div id="login-row" class="justify-content-center align-items-center d-flex mt-auto min-vh-100">
            <div id="login-column" class="col-md-6 bg-light d-flex justify-content-center p-0">
                <div id="login-box" class="col-md-12 border rounded">
                    <form id="login-form" class="form" action="<%=request.getContextPath()%>/login" method="post">
                        <h4 class="header pt-3 border-bottom">Please Sign In</h4>
                        <div class="form-group mt-3">
                            <p id="validate-username" class="text-danger pb-0 mb-0"></p>
                            <input type="text" name="username" id="username" class="form-control" placeholder="E-mail" onblur="validateUsername()" oninput="alertUsernameChange()">
                        </div>
                        <div class="form-group">
                            <p id="validate-password" class="text-danger pb-0 mb-0"></p>
                            <input type="password" name="password" id="password" class="form-control" placeholder="Password" onblur="validatePassword()" oninput="alertPasswordChange()">
                        </div>
                        <div class="form-check form-group">
                            <input id="remember-me" class="form-check-input" name="remember-me" type="checkbox"></input>
                            <label for="remember-me" class="text-info form-check-label">Remember me</label>
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" class="btn btn-success btn-md col" value="Login">
                        </div>
                        <div id="register-link" class="text-left">
                            <a href="register.jsp" class="text-info">Click here to register</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="javascript/login.js"></script>
</body>
</html>
