<%@ page import="jakarta.servlet.http.Cookie" %>

<html>
<body>

<h2>Cookie Value</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals("username")) {
                out.println("User Name: " + c.getValue());
            }
        }
    }
%>

</body>
</html>
