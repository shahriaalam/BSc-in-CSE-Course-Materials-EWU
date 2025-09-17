package movieticketbookingsystem;

import java.util.List;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    private User user;
    private Booking booking;
    private Seat seat;
    private List<Seat> seats;
    private Movie movie;
    private Showtime showtime;

    @Before
    public void setUp() {
        user = new User("User123", "password123", "User");
        movie = new Movie("Inception", "Sci-Fi", 148, 8.8);
        showtime = new Showtime(movie, "7:00 PM", 50, 12.50);
        seat = new Seat(1);
        seats = new ArrayList<>();
        seats.add(seat);
        booking = new Booking(user, showtime, seats);
    }

    @After
    public void tearDown() {
        user = null;
        booking = null;
        movie = null;
        showtime = null;
    }

    @Test
    public void testGetUsername() {
        assertEquals("User123", user.getUsername());
    }

    @Test
    public void testGetRole() {
        assertEquals("User", user.getRole());
    }

    @Test
    public void testAuthenticate_CorrectPassword() {
        assertTrue(user.authenticate("password123"));
    }

    @Test
    public void testAuthenticate_WrongPassword() {
        assertFalse(user.authenticate("wrongPassword"));
    }

    @Test
    public void testAddBooking() {
        user.addBooking(booking);
        List<Booking> history = user.getBookingHistory();
        assertEquals(1, history.size());
        assertEquals(booking, history.get(0));
    }

    @Test
    public void testGetBookingHistoryInitiallyEmpty() {
        assertTrue(user.getBookingHistory().isEmpty());
    }

    @Test
    public void testViewBookingHistory_NoBookings() {

        user.viewBookingHistory();
    }

    @Test
    public void testViewBookingHistory_WithBookings() {
        user.addBooking(booking);
        user.viewBookingHistory();

    }
    @Test
public void testAuthenticate_EmptyPassword() {
    assertFalse(user.authenticate(""));
}


@Test
public void testAddMultipleBookings() {
    Booking secondBooking = new Booking(user, showtime, seats);
    user.addBooking(booking);
    user.addBooking(secondBooking);

    List<Booking> history = user.getBookingHistory();
    assertEquals(2, history.size());
}





@Test
public void testUserCreationWithEmptyRole() {
    User u = new User("EmptyRole", "pass", "");
    assertEquals("", u.getRole());
}

@Test
public void testUserCreationWithNullRole() {
    User u = new User("NullRole", "pass", null);
    assertNull(u.getRole());
}


}
