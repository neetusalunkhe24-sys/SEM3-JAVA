<%@ page import="jakarta.servlet.http.Cookie" %>

<html>
<body>

<h2>Cookies Stored on Client</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
            if (c.getName().equals("username")) {
                out.println("Cookie Name: " + c.getName() + "<br>");
                out.println("Cookie Value: " + c.getValue());
            }
        }
    }
%>

</body>
</html>
