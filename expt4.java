<!DOCTYPE html>
<html>
<head>
    <title>User Information Form</title>
</head>
<body>
    <h2>Enter Your Details</h2>
    <form method="POST" action="DataProcessor">
        <label for="userName">Name:</label>
        <input type="text" id="userName" name="userName" required><br><br>

        <label for="userAge">Age:</label>
        <input type="number" id="userAge" name="userAge" required><br><br>

        <input type="submit" value="Submit">
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

@WebServlet("/DataProcessor")
public class DataProcessor extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException {
        

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        String name = request.getParameter("userName");
        String age = request.getParameter("userAge");


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Form Data Processed</title></head>");
        out.println("<body>");
        out.println("<h2>Thank you for your submission!</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Age: " + age + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
