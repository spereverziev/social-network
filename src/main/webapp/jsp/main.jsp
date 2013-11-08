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

<jsp:include page="header.jsp"/>

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