package movieticketbookingsystem;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookingTest {

    private Booking booking;
    private Showtime showtime;
    private Seat seat;
    private List<Seat> seats;
    private User user;

    @Before
    public void setUp() {
        user = new User("testuser", "password","User");
        Movie movie = new Movie("Test Movie", "Action",100, 8.5);
        showtime = new Showtime(movie, "18:00", 50, 10.0);
        seat = new Seat(1);
        seats = new ArrayList<>();
        seats.add(seat);
        booking = new Booking(user, showtime, seats);
    }

    @Test
    public void testGetShowtime() {
        assertEquals(showtime, booking.getShowtime());
    }

    @Test
    public void testConfirmBooking() {
        CreditCardPayment payment = new CreditCardPayment(10.0, "4111111111111111", "Shahria", "12/25", "123");
        booking.confirmBooking(payment);
        assertFalse(booking.isCanceled());
        assertTrue(seat.isBooked());
    }

    @Test
    public void testCancelBooking() {
        CreditCardPayment payment = new CreditCardPayment(10.0, "4111111111111111", "Shahria", "12/25", "123");
        booking.confirmBooking(payment);
        booking.cancelBooking();
        assertTrue(booking.isCanceled());
        assertFalse(seat.isBooked());
    }

    @Test
    public void testIsCanceledInitially() {
        assertFalse(booking.isCanceled());
    }
    
    
    @Test
    public void testConfirmBookingWithMultipleSeats() {
    Seat seat2 = new Seat(2);
    List<Seat> multiSeats = new ArrayList<>();
    multiSeats.add(seat);
    multiSeats.add(seat2);
    Booking multiSeatBooking = new Booking(user, showtime, multiSeats); 
    CreditCardPayment payment = new CreditCardPayment(20.0, "1234567891234567", "Shahria", "12/25", "123");
    multiSeatBooking.confirmBooking(payment);
    assertFalse(multiSeatBooking.isCanceled());
    assertTrue(seat.isBooked());
    assertTrue(seat2.isBooked());
    }

    @Test
    public void testConfirmBookingWithZeroPayment() {
    CreditCardPayment zeroPayment = new CreditCardPayment(0.0, "1234567891234567", "Shahria", "12/25", "123");
    Booking bookingWithZeroPayment = new Booking(user, showtime, seats);
    bookingWithZeroPayment.confirmBooking(zeroPayment);
    assertFalse(bookingWithZeroPayment.isCanceled());
    assertTrue(seat.isBooked()); 
    }

    @Test
    public void testCancelAlreadyCanceledBooking() {
    CreditCardPayment payment = new CreditCardPayment(10.0, "1234567891234567", "Shahria", "12/25", "123");
    booking.confirmBooking(payment);
    booking.cancelBooking();
    assertTrue(booking.isCanceled());
    booking.cancelBooking(); 
    assertTrue(booking.isCanceled()); 
    }


    @Test
    public void testSeatReleaseAfterBookingCancellation() {
    CreditCardPayment payment = new CreditCardPayment(10.0, "1234567891234567", "Shahria", "12/25", "123");
    booking.confirmBooking(payment);
    booking.cancelBooking();
    assertFalse(seat.isBooked()); 
    }



    
}
