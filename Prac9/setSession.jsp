<%
    String username = request.getParameter("username");
    session.setAttribute("username", username);
%>

<html>
<body>

<h2>Session Variable Stored Successfully</h2>

<a href="getSession.jsp">View Session Value</a>

</body>
</html>
