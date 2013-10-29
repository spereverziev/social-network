<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <li class="active"><a href="#" name="action" value="redirect">Home</a></li>
                <li><a href="#about"> Friends </a></li>
                <li><a href="#contact"> Messages </a></li>
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
        </div><!--/.nav-collapse -->
    </div>
</div>

<div class="container">

    <div class="jumbotron">
        <h1>
            <img src="/img/no_avatar.jpg" class="img-thumbnail">
            <c:out value="${sessionScope.account.firstName} ${sessionScope.account.lastName}"/>
        </h1>
        <p> <c:out value="${sessionScope.account.age} years old"/> </p>
        <p> <c:out value="e-mail: ${sessionScope.account.email}"/> </p>

    </div>


</div><!-- /.container -->


<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>