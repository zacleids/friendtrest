package com.friendtrest.rest;

import com.friendtrest.Movie_old;
import com.friendtrest.Review;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("/")
public class Leids_MovieSearchService {
    ArrayList<Movie_old> movies = new ArrayList<Movie_old>();
    ArrayList<Review> reviews = new ArrayList<Review>();

    public Leids_MovieSearchService(){
        ArrayList<String> cast = new ArrayList<String>();
        ArrayList<String> tags = new ArrayList<String>();

        //the matrix
        cast.add("Keanu Reeves");
        cast.add("Laurence Fishburne");
        cast.add("Carrie-Anne Moss");
        tags.add("Sci-Fi");
        tags.add("Action");
        movies.add(new Movie_old("The Matrix", 1999, "R", cast, tags));

        //Iron Man
        cast = new ArrayList<String>();
        tags = new ArrayList<String>();
        cast.add("Robert Downey Jr.");
        cast.add("Gwyneth Paltrow");
        cast.add("Jeff Bridges");
        tags.add("Action");
        tags.add("Adventure");
        tags.add("Sci-Fi");
        movies.add(new Movie_old("Iron Man", 2008, "PG-13", cast, tags));

        //The Avengers
        cast = new ArrayList<String>();
        tags = new ArrayList<String>();
        cast.add("Robert Downey Jr.");
        cast.add("Chris Evans");
        cast.add("Mark Ruffalo");
        cast.add("Chris Hemsworth");
        cast.add("Scarlett Johansson");
        cast.add("Clark Gregg");
        tags.add("Action");
        tags.add("Sci-Fi");
        movies.add(new Movie_old("The Avengers", 2012, "PG-13", cast, tags));

        //Deadpool
        cast = new ArrayList<String>();
        tags = new ArrayList<String>();
        cast.add("Ryan Reynolds");
        cast.add("Ed Skrein");
        cast.add("Karan Soni");
        tags.add("Action");
        tags.add("Adventure");
        tags.add("Comedy");
        movies.add(new Movie_old("Deadpool", 2016, "R", cast, tags));

        reviews.add(new Review("movie", "Deadpool", 5, "I loved it"));
        reviews.add(new Review("movie", "Deadpool", 4, "Ryan Reynolds was great as Deadpool"));
        reviews.add(new Review("movie", "The Avengers", 4, "The MCU is great"));
    }

    @GET
    @Path("/getMovies")
    public Response getMovies(@QueryParam("name") String name, @QueryParam("year") int year, @QueryParam("genre") String genre){
        ArrayList<Movie_old> moviesToShow = new ArrayList<Movie_old>();
        for(int i = 0; i < movies.size(); i++){
            Movie_old m = movies.get(i);
            if((m.getName().equalsIgnoreCase(name) || name.equals("")) && (m.getReleaseYear() == year || year == 0) && (m.getTags().contains(genre) || genre.equals(""))){
                moviesToShow.add(m);
            }
        }
        String json = new Gson().toJson(moviesToShow);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/getNumReviews")
    public Response getReviews(@QueryParam("movie") String movie){
        ArrayList<Review> reviewsToAdd = new ArrayList<Review>();
        for(int i = 0; i < reviews.size(); i++){
            Review r = reviews.get(i);
            if(r.getTitle().equalsIgnoreCase(movie)){
                reviewsToAdd.add(r);
            }
        }
        //String json = new Gson().toJson(reviewsToAdd);
        return Response.ok(reviewsToAdd.size()).build();
    }

}
