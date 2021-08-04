import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name="Baby'sFirstServlet", urlPatterns = "/baby's_first_servlet")
public class BabiesFirstServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        try {
            PrintWriter out = response.getWriter();
            out.println("Welcome to baby's first servlet.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}