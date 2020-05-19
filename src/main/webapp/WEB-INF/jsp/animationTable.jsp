
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    table th, td{
        text-align: center;
        border: 4px solid #0090a3;
    }
    .container{
        background-color: #bfbfbf;
    }
</style>
<head>
    <title>AnimationTable</title>
    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>
</head>
<body class="container">
<h1>Animation List</h1>
    <div class="table-responsive">
        <table class="table table-striped">
            <tr>
                <th>Name</th>
                <th>Genre</th>
                <th>Year</th>
                <th>Group</th>
                <th>Actions</th>
            </tr>

            <c:forEach var="animatio" items="${animationTable}">

                <c:url var="updateAnimation" value="/updateAnimation">
                        <c:param name="id" value="${updateAnimation.id}"/>
                </c:url>

                <c:url var="deleting" value="/deleting">
                    <c:param name="id" value="${animation.id}"/>
                </c:url>

                <c:url var="show" value="/show">
                    <c:param name="id" value="${animation.id}"/>
                </c:url>

                <tr>
                    <td>${animation.name}</td>
                    <td>${animation.genre}</td>
                    <td>${animation.year}</td>
                    <td>${animation.groups}</td>

                    <td>
                        <a href="${updateAnimation}">Update</a>
                        <a href="${deleting}"onclick="if (!(confirm('Do you want to delete?'))) return false"
                           >Delete</a>
                        <a href="${show}">Show</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
