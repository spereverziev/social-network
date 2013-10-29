<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-theme.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"/>
    <script src="<%=request.getContextPath()%>/js/jquery-1.10.2.min.js"></script>
</head>
<body>

<div class="navbar navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">be my guest</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav nav-pills navbar-left">
                <li><a href="/Controller"><input type="hidden" name="action" value="redirect">Home</a></li>
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

    <c:forEach var="foundAccount" items="${accounts}">
        <div class="panel-collapse">
            <form method="POST" action="Controller">
                <c:set var="friendsRequestAccount" value="${foundAccount}" scope="session"/>
                <h3><c:out value="${foundAccount.firstName} ${foundAccount.lastName}"/></h3>
                <button id="add-friend-button" class="btn btn-success" type="submit" name="action" value="sendFriendsRequest">Add to Friends</button>
                <button class="btn btn-info" type="submit" name="action" value="sendMessage">Send Message</button>
            </form>
        </div>
    </c:forEach>

</div><!-- /.container -->

<script src="<%=request.getContextPath()%>js/bootstrap.min.js"></script>
</body>
</html>