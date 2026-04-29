<!DOCTYPE html>
<html>
<head>
    <title>GET vs POST Demo</title>
</head>
<body>
    <h2>GET Method Form</h2>
    <!-- Data will be visible in the URL -->
    <form action="MethodServlet" method="GET">
        Username (GET): <input type="text" name="username_get" /><br/>
        <input type="submit" value="Submit with GET" />
    </form>

    <h2>POST Method Form</h2>
    <!-- Data will be hidden in the request body (more secure) -->
    <form action="MethodServlet" method="POST">
        Username (POST): <input type="text" name="username_post" /><br/>
        <input type="submit" value="Submit with POST" />
    </form>
</body>
</html>

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MethodServlet")
public class MethodServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username_get");

        out.println("<html><body>");
        out.println("<h2>Handling with doGet() Method</h2>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p><b>Difference observed:</b> Data is visible in the browser's URL bar.</p>");
        out.println("</body></html>");
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
      
        String username = request.getParameter("username_post"); 

        out.println("<html><body>");
        out.println("<h2>Handling with doPost() Method</h2>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p><b>Difference observed:</b> Data is NOT visible in the browser's URL bar (sent in request body).</p>");
        out.println("</body></html>");
    }
}
