<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User login page</title>
</head>
<body>

<h3>Login page</h3>

    <from:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

        <c:if test="${param.error != null}">

            <i style="color: red">Sorry! You entered invalid username/password.</i>

        </c:if>

        <c:if test="${param.logout != null}">

            <i>You have been logged out.</i>

        </c:if>

        <p>
            User name: <input type="text" name="username">
        </p>

        <p>
            Password: <input type="password" name="password">
        </p>

        <input type="submit" value="Login">
    </from:form>

<a href="${pageContext.request.contextPath}/app/search">Back to search</a>

</body>
</html>
