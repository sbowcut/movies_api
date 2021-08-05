import com.google.gson.Gson;
import data.DaoFactory;
import data.Movie;
import data.MoviesDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MoviesServlet", urlPatterns = "/movies")
public class MoviesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("application/json");
        try {
            //get object which can write to the response
            PrintWriter out = response.getWriter();


//            Movie movie = new Movie(2, "King King", "1942", "Harry Carey",
//                    "Elsa Banks", "234234234", "there aint one", "cheap",
//                    "Big Chungus Monkey");

            //get movies from the database
            MoviesDao moviesDao = DaoFactory.getMoviesDao(DaoFactory.ImplType.IN_MEMORY);
            //turn into json string
            String movieString = new Gson().toJson(moviesDao.all());

            //object into response
            out.println(movieString);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

      response.setContentType("application/json");

      PrintWriter out = null;
      try{
          out = response.getWriter();

          //get the stream of characters from the request
          BufferedReader reader = request.getReader();
          Movie[] movies = new Gson().fromJson(reader, Movie[].class);
          //turn stream into an array of movies
          DaoFactory.getMoviesDao(DaoFactory.ImplType.IN_MEMORY).insertAll(movies);

          //sout out properties for each movie so we know they made it
          for(Movie movie : movies){
              System.out.println(movie.getId());;
              System.out.println(movie.getTitle());
              System.out.println(movie.getDirector());
              System.out.println(movie.getActors());
              System.out.println(movie.getGenre());
              System.out.println(movie.getImdbID());
              System.out.println(movie.getPlot());
              System.out.println(movie.getPoster());
              System.out.println("******************************************");
          }


      }catch(Exception ex){
          System.out.println(ex.getMessage());
      }

      //write a meaningful response and set status code to 200
      out.println(new Gson().toJson("{message: \"Movies Post was successful\"}"));
      response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response){

        response.setContentType("application/json");

        PrintWriter out = null;

        try{
            out = response.getWriter();

            //get the stream of characters from the request
            BufferedReader reader = request.getReader();

            //turn stream into an array of movies
            Movie[] movies = new Gson().fromJson(reader, Movie[].class);

            //sout out properties for each movie so we know they made it
            for(Movie movie : movies){
                System.out.println(movie.getId());;
                System.out.println(movie.getTitle());
                System.out.println(movie.getDirector());
                System.out.println(movie.getActors());
                System.out.println(movie.getGenre());
                System.out.println(movie.getImdbID());
                System.out.println(movie.getPlot());
                System.out.println(movie.getPoster());
                System.out.println("******************************************");
            }


        }catch (IOException e) {
            out.println(new Gson().toJson(e.getLocalizedMessage()));
            response.setStatus(500);
            e.printStackTrace();
            return;
        }

        //write a meaningful response and set status code to 200
        out.println(new Gson().toJson("{message: \"Movies PUT was successful\"}"));
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("application/json");

        PrintWriter out = null;

        try{
            out = response.getWriter();

            BufferedReader reader = request.getReader();

            int id = new Gson().fromJson(reader, int.class);

            System.out.println("The movie id to delete: " + id);

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        out.println(new Gson().toJson("{message: \"Movies DELETE was successful\"}"));
        response.setStatus(200);
    }

}
