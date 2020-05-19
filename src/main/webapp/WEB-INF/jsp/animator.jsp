
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>
    html{
        height: 100%;
        width: 100%;
    }
    body{
        background-color: #bfbfbf !important;
    }
    table th, td{
        text-align: center;
        border: 4px solid #0090a3;
    }
</style>
<head>
    <title>Animation</title>
    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>
</head>
<body class="container">
    <div class="table-responsive">
        <caption>Animation information</caption>
        <table class="table table-striped">
            <tr>
                <td><b>Id:</b></td>
                <td>${animation.id}</td>
            </tr>
            <tr>
                <td><b>Name:</b></td>
                <td>${animation.name}</td>
            </tr>
            <tr>
                <td><b>Genre:</b></td>
                <td>${animation.genre}</td>
            </tr>
            <tr>
                <td><b>year:</b></td>
                <td>${animation.year}</td>
            </tr>
            <tr>
                <td><b>Group:</b></td>
                <td>${animation.groups}</td>
            </tr>
        </table>
    </div>
<br>
<a type="button" href="/animationTable" class="button">Back</a>
</body>
</html>
