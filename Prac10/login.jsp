<%@ page import="java.sql.*" %>

<%
String username = request.getParameter("username");
String password = request.getParameter("password");

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/student_db",
        "root",
        "root"
    );

    String sql = "SELECT * FROM users WHERE username=? AND password=?";

    PreparedStatement ps = con.prepareStatement(sql);
    ps.setString(1, username);
    ps.setString(2, password);

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {
        out.println("<h2>Login Successful</h2>");
        out.println("<p>Welcome " + username + "</p>");
    } else {
        out.println("<h2>Invalid Username or Password</h2>");
    }

    con.close();

} catch (Exception e) {
    out.println(e);
}
%>
