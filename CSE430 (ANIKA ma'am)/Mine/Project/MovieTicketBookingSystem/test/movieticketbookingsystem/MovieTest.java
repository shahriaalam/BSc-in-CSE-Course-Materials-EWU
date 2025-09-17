/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package movieticketbookingsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest {

    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("Inception", "Sci-Fi", 148, 8.8);
    }

    @Test
    public void testGetTitle() {
        String expResult = "Inception";
        String result = movie.getTitle();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGenre() {
        String expResult = "Sci-Fi";
        String result = movie.getGenre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDuration() {
        int expResult = 148;
        int result = movie.getDuration();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRating() {
        double expResult = 8.8;
        double result = movie.getRating();
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testSetTitle() {
        movie.setTitle("Interstellar");
        String expResult = "Interstellar";
        String result = movie.getTitle();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetGenre() {
        movie.setGenre("Adventure");
        String expResult = "Adventure";
        String result = movie.getGenre();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetDuration() {
        movie.setDuration(169);
        int expResult = 169;
        int result = movie.getDuration();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetRating() {
        movie.setRating(8.6);
        double expResult = 8.6;
        double result = movie.getRating();
        assertEquals(expResult, result, 0.01);
    }

    @Test
    public void testGetDetails() {

        movie.getDetails();

    }

    @Test
    public void testSetInvalidRating() {
        movie.setRating(10.5);  
        assertEquals(10.5, movie.getRating(), 0.01);

        movie.setRating(-1.0); 
        assertEquals(-1.0, movie.getRating(), 0.01);
    }

    @Test
    public void testSetInvalidDuration() {
        movie.setDuration(-100); 
        assertEquals(-100, movie.getDuration());

        movie.setDuration(0); 
        assertEquals(0, movie.getDuration());
    }

    @Test
    public void testSetNullTitle() {
        movie.setTitle(null);
        assertNull(movie.getTitle());  
    }

    @Test
    public void testSetEmptyTitle() {
        movie.setTitle("");
        assertEquals("", movie.getTitle()); 
    }

    @Test
    public void testSetNullGenre() {
        movie.setGenre(null);
        assertNull(movie.getGenre()); 
    }

    @Test
    public void testSetEmptyGenre() {
        movie.setGenre("");
        assertEquals("", movie.getGenre()); 
    }

    @Test
    public void testDurationGreaterThanZero() {
        assertTrue("Duration should be greater than 0", movie.getDuration() > 0);
    }

    @Test
    public void testRatingInRange() {
        assertTrue("Rating should be between 0 and 10", movie.getRating() >= 0 && movie.getRating() <= 10);
    }

    @Test
    public void testSetLongTitle() {
        String longTitle = "A".repeat(1000);  
        movie.setTitle(longTitle);
        assertEquals(longTitle, movie.getTitle());
    }

    @Test
    public void testSetBoundaryRating() {
        movie.setRating(0); 
        assertEquals(0, movie.getRating(), 0.01);

        movie.setRating(10); 
        assertEquals(10, movie.getRating(), 0.01);
    }
}
