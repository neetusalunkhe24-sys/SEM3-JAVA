<%@ page language="java" %>

<!DOCTYPE html>
<html>

<head>
    <title>Session Value</title>
</head>

<body>

    <h2>Session Variable</h2>

    <%
        String username =
            (String) session.getAttribute("username");
    %>

    <p>Username: <%= username %></p>

</body>

</html>
