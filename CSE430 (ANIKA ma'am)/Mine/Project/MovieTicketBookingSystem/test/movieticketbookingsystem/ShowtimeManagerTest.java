package movieticketbookingsystem;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShowtimeManagerTest {

    private ShowtimeManager showtimeManager;
    private Movie testMovie;

    @Before
    public void setUp() {
        showtimeManager = new ShowtimeManager();
        testMovie = new Movie("Interstellar", "Sci-Fi", 169, 8.6);
        showtimeManager.addShowtime(testMovie, "15:00", 100, 12.5);
    }

    @After
    public void tearDown() {
        showtimeManager = null;
        testMovie = null;
    }

    @Test
    public void testAddShowtime() {
        int initialSize = showtimeManager.getShowtimes().size();
        showtimeManager.addShowtime(new Movie("Dunkirk", "War", 106, 7.9), "17:00", 80, 11.0);
        assertEquals(initialSize + 1, showtimeManager.getShowtimes().size());
    }

    @Test
    public void testUpdateShowtime() {
        showtimeManager.updateShowtime(0, "16:00", 90, 10.5);
        Showtime updated = showtimeManager.getShowtime(0);
        assertEquals("16:00", updated.getTime());
        assertEquals(90, updated.getAvailableSeats().size());
        assertEquals(10.5, updated.getPrice(), 0.001);
    }

    @Test
    public void testGetShowtimes() {
        List<Showtime> showtimes = showtimeManager.getShowtimes();
        assertNotNull(showtimes);
        assertEquals(1, showtimes.size());
    }

    @Test
    public void testDeleteShowtime() {
        showtimeManager.deleteShowtime(0);
        assertEquals(0, showtimeManager.getShowtimes().size());
    }

    @Test
    public void testListShowtimes() {
       
        showtimeManager.listShowtimes();
    }

    @Test
    public void testGetShowtime() {
        Showtime showtime = showtimeManager.getShowtime(0);
        assertNotNull(showtime);
        assertEquals("Interstellar", showtime.getMovie().getTitle());
    }

    @Test
    public void testListShowtimesForMovie() {
       
        showtimeManager.listShowtimesForMovie(testMovie);
    }
    
    @Test
public void testUpdateShowtimeWithInvalidIndex() {
    showtimeManager.updateShowtime(-1, "18:00", 50, 9.5);
    showtimeManager.updateShowtime(5, "18:00", 50, 9.5); 
    Showtime unchanged = showtimeManager.getShowtime(0);
    assertEquals("15:00", unchanged.getTime());
}

@Test
public void testDeleteShowtimeInvalidIndex() {
    showtimeManager.deleteShowtime(-1);
    showtimeManager.deleteShowtime(10); 
    assertEquals(1, showtimeManager.getShowtimes().size()); 
}

@Test
public void testGetShowtimeInvalidIndex() {
    Showtime invalidShowtime = showtimeManager.getShowtime(-1);
    assertNull(invalidShowtime);
}
@Test
public void testListShowtimesWhenEmpty() {
    showtimeManager.deleteShowtime(0);
    showtimeManager.listShowtimes(); 
}

@Test
public void testAddMultipleShowtimesSameMovie() {
    showtimeManager.addShowtime(testMovie, "18:00", 100, 12.5);
    showtimeManager.addShowtime(testMovie, "21:00", 100, 12.5);
    List<Showtime> showtimes = showtimeManager.getShowtimes();
    assertEquals(3, showtimes.size());
}

@Test
public void testListShowtimesForMovieWithNoMatches() {
    Movie anotherMovie = new Movie("The Prestige", "Drama", 130, 8.5);
    showtimeManager.listShowtimesForMovie(anotherMovie); 
}

@Test
public void testRevenueAfterSeatBooking() {
    Showtime showtime = showtimeManager.getShowtime(0);
    Seat seat = showtime.getAvailableSeats().get(0);
    seat.reserve(); 
    showtime.addRevenue(showtime.getPrice());

    assertEquals(1, showtime.getTotalBookings());
    assertEquals(showtime.getPrice(), showtime.getTotalRevenue(), 0.001);
}


@Test
public void testSetAvailableSeatsToZero() {
    Showtime showtime = showtimeManager.getShowtime(0);
    showtime.setAvailableSeats(0);
    assertEquals(0, showtime.getAvailableSeats().size());
}

}
