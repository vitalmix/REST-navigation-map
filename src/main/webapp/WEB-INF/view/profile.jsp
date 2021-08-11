<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
   <h2>Challenge home page</h2>
   <hr>

   <p>Welcome to challenge home page</p>
   <hr>

   <p>
       <!-- Display username and role -->
       User: <security:authentication property="principal.username" />
       <br><br>
       Role(s): <security:authentication property="principal.authorities" />
   </p>

   <hr>
   <p>
       <a href="${pageContext.request.contextPath}/search">Search addresses</a>
   </p>


   <p>
       <a href="${pageContext.request.contextPath}/api/historyOfSearch">Search history</a>
   </p>

   <from:form action="${pageContext.request.contextPath}/logout" method="POST">

       <input type="submit" value="logout">

   </from:form>

</body>
</html>