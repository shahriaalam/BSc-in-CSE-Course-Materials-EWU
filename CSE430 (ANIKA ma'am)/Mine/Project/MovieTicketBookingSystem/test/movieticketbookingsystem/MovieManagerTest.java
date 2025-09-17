/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieticketbookingsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.NullPointerException;
import java.lang.AssertionError;

/**
 *
 * @author User
 */


public class MovieManagerTest {

    private MovieManager movieManager;

    @Before
    public void setUp() {
        movieManager = new MovieManager();
    }

    @Test
    public void testAddMovie() {
        movieManager.addMovie("Inception", "Sci-Fi", 148, 8.8);
        Movie movie = movieManager.getMovie(0);

        assertNotNull(movie);
        
        assertEquals("Inception", movie.getTitle());
        assertEquals("Sci-Fi", movie.getGenre());
        assertEquals(148, movie.getDuration());
        assertTrue(movie.getRating()==8.8);
         
    }

    @Test
    public void testUpdateMovie_ValidIndex() {
        movieManager.addMovie("Old Title", "Drama", 120, 7.0);
        movieManager.updateMovie(0, "New Title", "Action", 130, 8.0);

        Movie movie = movieManager.getMovie(0);
        assertEquals("New Title", movie.getTitle());
        assertEquals("Action", movie.getGenre());
        assertEquals(130, movie.getDuration());
        assertTrue(movie.getRating()==8.0);
   
    }

    @Test
    public void testUpdateMovie_InvalidIndex() {
        movieManager.updateMovie(0, "Invalid", "Genre", 100, 5.0);
        assertNull(movieManager.getMovie(0));  
    }

    @Test
    public void testDeleteMovie_ValidIndex() {
        movieManager.addMovie("Movie to Delete", "Horror", 90, 6.5);
        movieManager.deleteMovie(0);
        assertNull(movieManager.getMovie(0));
    }

    @Test
    public void testDeleteMovie_InvalidIndex() {
        movieManager.addMovie("Keep Me", "Drama", 100, 7.5);
        movieManager.deleteMovie(5);  
        assertNotNull(movieManager.getMovie(0));  
    }

    @Test
    public void testSearchMoviesByGenre_Found() {
        movieManager.addMovie("Avengers", "Action", 120, 8.0);
        movieManager.addMovie("Notebook", "Romance", 100, 7.5);

       
      Movie movie = movieManager.getMovie(0);
    assertEquals("Action", movie.getGenre());
    }

    @Test
    public void testSearchMoviesByGenre_NotFound() {
        movieManager.addMovie("Inception", "Sci-Fi", 148, 8.8);
         movieManager.addMovie("Harry Potter", "Fantasy", 150, 8.5);
    Movie movie = movieManager.getMovie(0);

    assertFalse(movie.getGenre()=="Fantasy");
    }

    @Test
    public void testSearchMoviesByRating() {
        movieManager.addMovie("Movie1", "Comedy", 100, 7.0);
        movieManager.addMovie("Movie2", "Comedy", 100, 5.0);

        movieManager.addMovie("Some Movie", "Drama", 100, 7.0);
    Movie movie = movieManager.getMovie(0);

    assertTrue(movie.getRating() >= 6.0);
    }

    @Test
    public void testSearchMoviesByTitle() {
        movieManager.addMovie("Spider-Man", "Action", 115, 7.9);
        Movie movie = movieManager.getMovie(0);
        assertTrue(movie.getTitle().toLowerCase().contains("spider"));
    }

    @Test
    public void testGetMovie_ValidIndex() {
        movieManager.addMovie("Matrix", "Sci-Fi", 136, 8.7);
        Movie movie = movieManager.getMovie(0);
        assertNotNull(movie);
        assertEquals("Matrix", movie.getTitle());
    }

    @Test
    public void testGetMovie_InvalidIndex() {
        Movie movie = movieManager.getMovie(100);
        assertNull(movie);
    }

    @Test
    public void testAddMovieWithEmptyTitle() {
        movieManager.addMovie("", "Drama", 100, 7.0);
        Movie movie = movieManager.getMovie(0);
        assertEquals("", movie.getTitle());
    }

    @Test
    public void testAddMovieWithLongTitle() {
        String longTitle = "A".repeat(1000); 
        movieManager.addMovie(longTitle, "Adventure", 120, 8.0);
        Movie movie = movieManager.getMovie(0);
        assertEquals(longTitle, movie.getTitle());
    }

    @Test
    public void testSearchMoviesByEmptyGenre() {
        movieManager.addMovie("Movie1", "Action", 100, 7.0);
        movieManager.searchMoviesByGenre("");
    }

    @Test
    public void testAddMovieWithZeroDuration() {
        movieManager.addMovie("Movie with Zero Duration", "Drama", 0, 5.0);
        Movie movie = movieManager.getMovie(0);
        assertEquals(0, movie.getDuration());
    }

    @Test
    public void testAddMovieWithNegativeRating() {
        movieManager.addMovie("Movie with Negative Rating", "Comedy", 120, -1.0);
        Movie movie = movieManager.getMovie(0);
        assertTrue(movie.getRating() == -1.0);
    }

  
    @Test
    public void testSearchMoviesByNonExistentGenre() {
        movieManager.addMovie("Inception", "Sci-Fi", 148, 8.8);
        movieManager.addMovie("Harry Potter", "Fantasy", 150, 8.5);
        movieManager.searchMoviesByGenre("Action");
        // Check for a message saying no movies found
    }


    @Test
    public void testSearchMoviesByNonExistentTitle() {
        movieManager.addMovie("Inception", "Sci-Fi", 148, 8.8);
        movieManager.addMovie("Harry Potter", "Fantasy", 150, 8.5);
        movieManager.searchMoviesByTitle("Avatar");
        // Check for a message saying no movies found
    }

    @Test
    public void testUpdateMovieWithNullTitle() {
        movieManager.addMovie("Initial Title", "Drama", 100, 7.5);
        movieManager.updateMovie(0, null, "Action", 120, 8.0);

        Movie movie = movieManager.getMovie(0);
        assertNull(movie.getTitle());  
    }

    @Test
    public void testEmptyMovieList() {
        movieManager.listMovies();
      
    }
}
