<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    .updatebody{
        background-color: #bfbfbf;
        margin: 0 auto;
        width: 30%;
        text-align: center;
        border: 6px solid #0090a3;
        height: 38em;
    }
    html{
        height: 100%;
        width: 100%;
    }
    body{
        background-color: #bfbfbf !important;
    }
    .container{
        text-align: center;
    }
</style>
<head>
    <title>Update</title>
    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>
</head>
<body class="container">
<div class = updatebody>
    <form:form name="animation" action="/updateAnimation" method="post">
        <input type="hidden" name="id" value="${animation.id}"><p>
        Name:<br>
        <input type="text" name="name" value="${animation.genre}"><p>
        genre:<br>
        <input type="text" name="genre" value="${animation.genre}"><p>
        Age:<br>
        <input type="text" name="year" value="${animation.year}"><p>
        Group:<br>
        <select name="groups" value="${animation.groups}">
            <option selected="selected" value="Genre">Genre</option>
            <option value="Action">Action</option>
            <option value="Comedy">Comedy</option>
            <option value="Drama">Drama</option>
        </select><br><br>
        <input type="submit" value="Update">
</div>
    </form:form>
</body>

</html>
