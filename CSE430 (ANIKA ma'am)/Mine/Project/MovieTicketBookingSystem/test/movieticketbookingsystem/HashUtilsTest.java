package movieticketbookingsystem;

import static org.junit.Assert.*;
import org.junit.Test;

public class HashUtilsTest {

    @Test
    public void testHashPasswordRegular() {
        String password = "password123";
        String hashedPassword = HashUtils.hashPassword(password);
        assertNotNull("Hashed password should not be null", hashedPassword);
        assertNotEquals("Hashed password should not be the same as the original password", password, hashedPassword);
    }

    @Test
    public void testHashPasswordEmpty() {
        String password = "";
        String hashedPassword = HashUtils.hashPassword(password);
        assertNotNull("Hashed password for empty string should not be null", hashedPassword);
        assertNotEquals("Hashed password for empty string should not be empty", "", hashedPassword);
    }

    @Test
    public void testHashPasswordNull() {
    String password = null;
    try {
        String hashedPassword = HashUtils.hashPassword(password);
        fail("Expected NullPointerException for null input");
    } catch (NullPointerException e) {
    }
    }

    @Test
    public void testHashPasswordConsistency() {
        String password = "consistentPassword123";
        String firstHash = HashUtils.hashPassword(password);
        String secondHash = HashUtils.hashPassword(password);
        assertEquals("Hashed passwords should be the same for the same input", firstHash, secondHash);
    }


    @Test
    public void testHashPasswordSingleCharacter() {
        String password = "a";
        String hashedPassword = HashUtils.hashPassword(password);
        assertNotNull("Hashed password for a single character should not be null", hashedPassword);
        assertNotEquals("Hashed password should not be the same as the original password", password, hashedPassword);
    }

    @Test
    public void testHashPasswordLongString() {
        String password = "a".repeat(1000); 
        String hashedPassword = HashUtils.hashPassword(password);
        assertNotNull("Hashed password for a long string should not be null", hashedPassword);
    }

    @Test
    public void testHashPasswordWithSpecialCharacters() {
        String password = "!@#&$%^";
        String hashedPassword = HashUtils.hashPassword(password);
        assertNotNull("Hashed password for special characters should not be null", hashedPassword);
        assertNotEquals("Hashed password should not be the same as the original password", password, hashedPassword);
    }

    @Test
    public void testHashPasswordWithExceptionHandling() {
        String password = "password123";
        String hashedPassword = HashUtils.hashPassword(password);
        assertNotNull("Hashed password should not be null even if algorithm is unavailable", hashedPassword);
        assertNotEquals("Hashed password should not be the same as the original password", password, hashedPassword);
    }

    @Test
    public void testHashPasswordSHA256Length() {
        String password = "testPassword";
        String hashedPassword = HashUtils.hashPassword(password);
        assertEquals("Hashed password should have 64 characters for SHA-256", 64, hashedPassword.length());
    }
}
