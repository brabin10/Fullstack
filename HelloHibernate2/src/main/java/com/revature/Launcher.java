package com.revature;



import java.util.List;

import com.revature.daos.DirectorDAO;
import com.revature.daos.MovieDAO;
import com.revature.models.Director;
import com.revature.models.Movie;



public class Launcher {

public static void main(String[] args) {
	
	//we need a MovieDAO object so we can call it's method
	MovieDAO mDAO = new MovieDAO();
	
	DirectorDAO dDAO = new DirectorDAO();
	
	//going to create some directors and movies to insert into the DB
	//we can leave the filography field null, because the Movie class already has a reference to Director
	//This is due to the parameters we set in the @OneToMany and @ManyToOne, Hibernate knows what to fill these nulls with
	Director d1 = new Director("Quentin Tarantino", 1850, null);
	Director d2 = new Director("James Cameron", 1753, null);
	
	Movie m1 = new Movie("Pulp Fiction", "Crime movie", d1);
	Movie m2 = new Movie("Avatar: The Last Airbender", "sci fi garbage fire", d2);
	Movie m3 = new Movie("The Hateful Eight", "Wow.. what?", d1 );
	
	//insert our movie objects using our DAO method
	mDAO.insertMovie(m1);
	mDAO.insertMovie(m2);
	mDAO.insertMovie(m3);
	
	//calling our SELECT statement from the DAO
	List<Movie> allMovies = mDAO.getAllMovies();
	
	//
	for (Movie m:allMovies) {
		System.out.println(m);
	}
	
	System.out.println(mDAO.getMovieById(2));
	
	//calling our SELECT by director ID method
	List<Movie> directorMovies = mDAO.getMoviesDirectorId(1);
	
	for(Movie m:directorMovies) {
		System.out.println(m);
	}
	
	//UPDATE a Movie with session methods
	m2.setTitle("Titanic");
	m2.setGenre("I cried lowkey");
	
	mDAO.updateWithSessionMethod(m2);
	
	//print out he movie just to show that is updated
	System.out.println(mDAO.getMovieById(2)); //MOvie m2 has an id of 2
	
	//UPDATE a Movie with HQL
	m1.setTitle("Resevoir Dogs");
	
	mDAO.updateWithHQL(m1);
	
	System.out.println(m1);
	
	//SELECT and print out all of my Directors
	
	List<Director> allDirectors = dDAO.getAllDirectors();
	for(Director d:allDirectors) {
		System.out.println(d);
	}
}
	
}
