<%@ page import="java.sql.*" %>

<html>
<head>
    <title>Registration</title>
</head>

<body>

<h2>Registration Form</h2>

<form method="post">

Name:
<input type="text" name="name"><br><br>

Username:
<input type="text" name="username"><br><br>

Password:
<input type="password" name="password"><br><br>

Email:
<input type="text" name="email"><br><br>

<input type="submit" value="Register">

</form>

<%
if (request.getMethod().equalsIgnoreCase("POST")) {

    String name = request.getParameter("name");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db",
            "root",
            "root"
        );

        String sql = "INSERT INTO users(name, username, password, email) VALUES(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, username);
        ps.setString(3, password);
        ps.setString(4, email);

        ps.executeUpdate();

        out.println("<h3>Registration Successful</h3>");

        con.close();

    } catch (Exception e) {
        out.println(e);
    }
}
%>

</body>
</html>
