package movieticketbookingsystem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class MainTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testMain_ExitImmediately() {
        
        String input = "3\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);

       
        Main.main(new String[]{});

       
        String output = testOut.toString();
        assertTrue(output.contains("Thank you for using the Movie Ticket Booking System"));
    }
}
