package data;

public class Movie {

    public int id;
    public String title;
    public String year;
    public String director;
    public String actors;
    public String rating;
    public String poster;
    public String genre;
    public String plot;

    public Movie() {
    }

    public Movie(int id, String title, String year, String director, String actors, String imdbID,
                 String poster, String genre, String plot) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.director = director;
        this.actors = actors;
        this.rating = imdbID;
        this.poster = poster;
        this.genre = genre;
        this.plot = plot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
}
