<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>Login</h1>

<c:if test="${loginFail}">
    <div class="alert alert-danger" role="alert">Bad credentials</div>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/login">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="Login">
</form>


</body>
</html>