import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StoreCookie")
public class StoreCookie extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");

        Cookie cookie = new Cookie("username", username);
        response.addCookie(cookie);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Cookie Stored Successfully</h2>");
        out.println("<a href='ReadCookie'>Read Cookie</a>");
    }
}
