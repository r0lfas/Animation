
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Animation</title>
    <jsp:include page="header.jsp"/>
    <jsp:include page="menu.jsp"/>
    <style>
        h2 {
            color: #0090a3;
        }

        .container {
            background-color: #80ff80;

        }

        .anketa {
            margin: 0 auto;
            width: 50%;
            text-align: center;
            border: 6px solid #80ff80;

        input {
            background-color: #0090a3 !important;
        }


        .vardas {
            background-color: #bfbfbf;

        }

        .error {
            color: red
        }
    </style>
</head>
<body class="container">
<div class="anketa">
    <h2>Animation watching List</h2>
    <table class="table table-striped">
        <form:form method="post" action="animationShow" modelAttribute="number">

            <form:input type="text" path="name" placeholder="Name"/>
            <form:errors path="name" cssClass="error"/><br><br>
            <form:input type="text" path="genre" placeholder="Genre"/>
            <form:errors path="genre" cssClass="error"/><br><br>
            <form:input type="text" path="year"  placeholder="Year"/>
            <form:errors path="year" cssClass="error"/><br><br>

        <select name="groups">
            <option selected="selected" value="Genre">Genre</option>
            <option value="Action">Action</option>
            <option value="Comedy">Comedy</option>
            <option value="Drama">Drama</option>
        </select><br><br>

        <input type="submit" value="Confirm">
</div>
</form:form>
</body>
</html>
