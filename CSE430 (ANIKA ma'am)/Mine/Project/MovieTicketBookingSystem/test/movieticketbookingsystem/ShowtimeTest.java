package movieticketbookingsystem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class ShowtimeTest {

    private Showtime showtime;
    private Movie movie;
    private Seat seat;

    @Before
    public void setUp() {
        movie = new Movie("Inception", "Sci-Fi", 148, 8.8);
        showtime = new Showtime(movie, "7:00 PM", 50, 12.50);
        seat = new Seat(1); 
    }

    @After
    public void tearDown() {
        showtime = null; 
        movie = null;
    }

    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        double expResult = 12.50;
        double result = showtime.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 15.00;
        showtime.setPrice(price);
        assertEquals(price, showtime.getPrice(), 0.0);
    }

@Test
public void testGetTotalBookings() {
    System.out.println("getTotalBookings");
    int expResult = 0;
    int result = showtime.getTotalBookings();
    assertEquals(expResult, result);

   
    List<Seat> availableSeats = showtime.getAvailableSeats();
    Seat firstSeat = availableSeats.get(0); 
    firstSeat.reserve(); 

    expResult = 1; 
    result = showtime.getTotalBookings();
    assertEquals(expResult, result);
}

    @Test
    public void testAddRevenue() {
        System.out.println("addRevenue");
        double amount = 12.50;
        showtime.addRevenue(amount);
        assertEquals(amount, showtime.getTotalRevenue(), 0.0);
    }

    @Test
    public void testGetTotalRevenue() {
        System.out.println("getTotalRevenue");
        double expResult = 0.0;
        double result = showtime.getTotalRevenue();
        assertEquals(expResult, result, 0.0);

        seat.reserve(); 
        showtime.addRevenue(showtime.getPrice());  
        expResult = 12.50;
        result = showtime.getTotalRevenue();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetMovie() {
        System.out.println("getMovie");
        Movie expResult = movie;
        Movie result = showtime.getMovie();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTime() {
        System.out.println("getTime");
        String expResult = "7:00 PM";
        String result = showtime.getTime();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAvailableSeats() {
        System.out.println("getAvailableSeats");
        List<Seat> availableSeats = showtime.getAvailableSeats();
        int expResult = 50; 
        int result = availableSeats.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTime() {
        System.out.println("setTime");
        String newTime = "9:00 PM";
        showtime.setTime(newTime);
        assertEquals(newTime, showtime.getTime());
    }

    @Test
    public void testSetAvailableSeats() {
        System.out.println("setAvailableSeats");
        showtime.setAvailableSeats(100);
        List<Seat> availableSeats = showtime.getAvailableSeats();
        assertEquals(100, availableSeats.size());
    }

    @Test
    public void testShowDetails() {
        System.out.println("showDetails");
        showtime.showDetails();
        assertNotNull(showtime.getMovie());  
        assertNotNull(showtime.getTime());   
    }
    
    @Test
public void testBookAllSeats() {
    System.out.println("bookAllSeats");
    List<Seat> seats = showtime.getAvailableSeats();
    for (Seat s : seats) {
        s.reserve();
    }
    assertEquals(0, showtime.getAvailableSeats().size());
    assertEquals(50, showtime.getTotalBookings());
}

@Test
public void testDoubleBookingSameSeat() {
    System.out.println("doubleBookingSameSeat");
    Seat s = showtime.getAvailableSeats().get(0);
    s.reserve();
    s.reserve(); 
    assertTrue(s.isBooked());
    assertEquals(1, showtime.getTotalBookings());
}

@Test
public void testMultipleAddRevenue() {
    System.out.println("multipleAddRevenue");
    showtime.addRevenue(10.0);
    showtime.addRevenue(15.0);
    assertEquals(25.0, showtime.getTotalRevenue(), 0.0);
}

@Test
public void testAddZeroRevenue() {
    System.out.println("addZeroRevenue");
    showtime.addRevenue(0.0);
    assertEquals(0.0, showtime.getTotalRevenue(), 0.0);
}

@Test
public void testSetAvailableSeatsTwice() {
    System.out.println("setAvailableSeatsTwice");
    showtime.setAvailableSeats(10);
    assertEquals(10, showtime.getAvailableSeats().size());
    showtime.setAvailableSeats(5);
    assertEquals(5, showtime.getAvailableSeats().size());
}

@Test
public void testCreateShowtimeWithZeroSeats() {
    System.out.println("zeroSeats");
    Showtime s = new Showtime(movie, "10:00 AM", 0, 10.0);
    assertEquals(0, s.getAvailableSeats().size());
}

@Test
public void testCreateShowtimeWithNegativePrice() {
    System.out.println("negativePrice");
    Showtime s = new Showtime(movie, "10:00 AM", 10, -5.0);
    assertEquals(-5.0, s.getPrice(), 0.0); 
}

}
