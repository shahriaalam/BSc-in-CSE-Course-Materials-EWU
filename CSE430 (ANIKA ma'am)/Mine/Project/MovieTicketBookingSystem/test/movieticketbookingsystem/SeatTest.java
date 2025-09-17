package movieticketbookingsystem;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SeatTest {

    private Seat seat;

    @Before
    public void setUp() {
        seat = new Seat(1);
    }

    @Test
    public void testGetSeatNumber() {
        System.out.println("getSeatNumber");
        int expResult = 1;
        int result = seat.getSeatNumber();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsBookedInitially() {
        System.out.println("isBooked");
        boolean expResult = false;
        boolean result = seat.isBooked();
        assertEquals(expResult, result);
    }

    @Test
    public void testReserve() {
        System.out.println("reserve");
        seat.reserve();
        assertTrue("Seat should be booked", seat.isBooked());
    }

    @Test
    public void testRelease() {
        System.out.println("release");
        seat.reserve();
        seat.release();
        assertFalse("Seat should be available after release", seat.isBooked());
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Seat 1 (Available)";
        String result = seat.toString();
        assertEquals(expResult, result);

        seat.reserve();
        expResult = "Seat 1 (Booked)";
        result = seat.toString();
        assertEquals(expResult, result);
    }


    @Test
    public void testDoubleReserve() {
        System.out.println("double reserve");
        seat.reserve();
        seat.reserve(); 
        assertTrue("Seat should remain booked", seat.isBooked());
    }

    @Test
    public void testDoubleRelease() {
        System.out.println("double release");
        seat.release(); 
        assertFalse("Seat should still be available", seat.isBooked());
    }

    @Test
    public void testReserveReleaseReserve() {
        System.out.println("reserve-release-reserve");
        seat.reserve();
        assertTrue(seat.isBooked());

        seat.release();
        assertFalse(seat.isBooked());

        seat.reserve();
        assertTrue(seat.isBooked());
    }

    @Test
    public void testMultipleSeatsIndependence() {
        System.out.println("multiple seats independence");
        Seat seat1 = new Seat(1);
        Seat seat2 = new Seat(2);

        seat1.reserve();
        assertTrue(seat1.isBooked());
        assertFalse(seat2.isBooked());

        seat2.reserve();
        assertTrue(seat2.isBooked());
    }

    @Test
    public void testDifferentSeatNumberToString() {
        System.out.println("different seat number");
        Seat seat5 = new Seat(5);
        assertEquals("Seat 5 (Available)", seat5.toString());
        seat5.reserve();
        assertEquals("Seat 5 (Booked)", seat5.toString());
    }
}
