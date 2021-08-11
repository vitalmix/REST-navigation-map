<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Place search</title>
</head>
    <header>
            <form class="search-form" action="${pageContext.request.contextPath}/api/searchCity">

                <p>Search your place: </p>
                <input type="text" placeholder="Search address" name="searchedPlace">
                <input type="submit" value="Search">
            </form>
    </header>
<body>

<security:authorize access="hasRole('ROLE_REGISTERED')">
    <hr>
    User: <security:authentication property="principal.username" />
    <hr>
</security:authorize>

<a href="${pageContext.request.contextPath}/profile/user">Profile page</a>

</body>
</html>
