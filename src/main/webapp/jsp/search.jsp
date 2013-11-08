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

<jsp:include page="header.jsp"/>

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