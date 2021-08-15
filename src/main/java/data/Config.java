package data;

public class Config {

    public String getUrl(){
        return "jdbc:mysql://localhost:3306/movies_db?serverTimezone=UTC&useSSL=false";
    }

    public String getUser(){
        return "root";
    }

    public String getPassword(){
        return "codeup";
    }
}