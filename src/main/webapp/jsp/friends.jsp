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
    <c:forEach var="friendsRequest" items="${account.friendsRequests}">
        <div class="panel-collapse">
            <form method="POST" action="Controller">
                <h3><c:out value="${friendsRequest.sender.account.firstName} ${friendsRequest.sender.account.lastName}"/></h3>
                <button id="add-friend-button" class="btn btn-success" type="submit" name="action" value="acceptFriendsRequest">Accept</button>
                <button class="btn btn-danger" type="submit" name="action" value="dismissFriendsRequest">Dismiss</button>
            </form>
        </div>
    </c:forEach>

</div>

<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>