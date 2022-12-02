<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add game</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1>Add game</h1>
<form method="post" action="/games/add">
    <label for="gameName">Name :</label>
    <input id="gameName" type="text" name="gameName">

    <label for="gameDescription">Description :</label>
    <textarea id="gameDescription" name="gameDescription"></textarea>

    <button>Add</button>
</form>

</body>
</html>
