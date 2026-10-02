<%@ page import="jakarta.servlet.http.Cookie" %>

<%
    String username = request.getParameter("username");

    Cookie cookie = new Cookie("username", username);
    response.addCookie(cookie);
%>

<html>
<body>

<h2>Cookie Stored Successfully</h2>

<a href="getCookie.jsp">View Cookie</a>

</body>
</html>
