<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Update game</h1>
<form method="post" action="/games/update">
  <label for="gameName">Name :</label>
  <input id="gameName" type="text" name="gameName" value="${game.name}">
  <input type="hidden" name="gameId" value="${game.id}">
  <label for="gameDescription">Description :</label>
  <textarea id="gameDescription" name="gameDescription">${game.description}</textarea>

  <button>Update</button>
</form>

</body>
</html>
