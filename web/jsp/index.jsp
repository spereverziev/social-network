<%-- Created by IntelliJ IDEA. --%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Be my guest</title>
    <link rel="stylesheet" href="/css/index.css"/>
    <link rel="stylesheet" href="/css/bootstrap.css"/>
</head>
<body>
<div id="login">
    <form class="form-signin" method="POST" action="Controller">
        <input type="hidden" name="action" value ="login"/>
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" name="login" class="input-block-level" placeholder="Login">
        <input type="password" name="password" class="input-block-level" placeholder="Password">
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
        <button class="btn btn-large btn-success" type="submit">Registration</button>
    </form>
</div>
</body>
</html>