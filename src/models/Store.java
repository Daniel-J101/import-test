package models;

import java.util.ArrayList;

public class Store {

    private ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<>();
    }


    public Movie getMovie(int index) {
        return new Movie(movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        movies.set(index, movie);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void action(String name, String action) {
        if(movies.isEmpty())
            throw new IllegalStateException("action cannot be done with no movies");

        if(name == null || name.isEmpty() || !(action.equalsIgnoreCase("sell") || action.equalsIgnoreCase("rent") || action.equalsIgnoreCase("return")))
            throw new IllegalArgumentException("Incorrect parameters.");
        for (int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getName().equals(name)) {
                switch(action) {
                    case "sell":
                        if(!movies.get(i).isAvailable())
                            throw new IllegalStateException("You cannot sell a movie that is rented");
                        movies.remove(i);
                        break;
                    case "rent":
                        movies.get(i).setAvailable(false);
                        break;
                    case "return":
                        movies.get(i).setAvailable(true);
                        break;
                    default:
                        System.out.println("Something went wrong finding the action");
                }


            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < movies.size(); i++)
            temp += movies.get(i) + "\n\n";
        return temp;
    }

}
