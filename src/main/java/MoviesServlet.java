import com.google.gson.Gson;
import data.Movie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet(name = "MoviesServlet", urlPatterns = "/movies")
public class MoviesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("application/json");
        try {
            PrintWriter out = response.getWriter();

            Movie movie = new Movie(2, "King King", "1942", "Harry Carey",
                    "Elsa Banks", "234234234", "there aint one", "cheap",
                    "Big Chungus Monkey");
            String movieString = new Gson().toJson(movie);

            out.println(movieString);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
