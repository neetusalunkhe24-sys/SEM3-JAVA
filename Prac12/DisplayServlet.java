package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://localhost:3306/colleges";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url, username, password);

            Statement st = con.createStatement();

            String sql = "SELECT * FROM student";

            ResultSet rs = st.executeQuery(sql);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Student Records</title>");
            out.println("</head>");

            out.println("<body>");
            out.println("<h2>All Student Records</h2>");

            out.println("<table border='1'>");

            out.println("<tr>");
            out.println("<th>ID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Email</th>");
            out.println("<th>Course</th>");
            out.println("</tr>");

            while (rs.next()) {

                out.println("<tr>");

                out.println("<td>" +
                    rs.getInt("id") +
                    "</td>");

                out.println("<td>" +
                    rs.getString("name") +
                    "</td>");

                out.println("<td>" +
                    rs.getString("email") +
                    "</td>");

                out.println("<td>" +
                    rs.getString("course") +
                    "</td>");

                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

            rs.close();
            st.close();

        } catch (Exception e) {

            out.println("<h3>Error: "
                    + e.getMessage()
                    + "</h3>");
        }
    }
}
