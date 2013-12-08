<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-theme.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css"/>
    <script src="<%=request.getContextPath()%>/js/jquery-1.10.2.min.js"></script>
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="container">

    <div class="MessageTable">
        <c:forEach var="message" items="${account.messages}">
            <div class="MessageSender">
                <c:out value="${message.sender.account.firstName} ${message.sender.account.lastName}"/> <br/>
                <c:out value="${message.date}"/>
            </div>
           <div class="MessageText">
               <c:out value="${message.text}"/>
           </div>
        </c:forEach>
    </div>

</div>

<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>