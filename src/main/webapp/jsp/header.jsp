<%--
  Created by IntelliJ IDEA.
  User: Stas
  Date: 11/8/13
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-theme.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"/>
</head>
<body>

<div class="navbar navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">be my guest</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav nav-pills navbar-left">
                <li class="active"><a href="?action=goHome">Home</a></li>
                <li><a href="?action=showFriends"> Friends </a></li>
                <li><a href="?action=showMessages"> Messages </a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <input type="hidden" name="action" value ="search"/>
                <div class="form-group">
                    <input type="text" name="name" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default"> Go! </button>
            </form>

            <ul class="nav nav-pills navbar-right">
                <li><a href="./">Logout</a></li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>