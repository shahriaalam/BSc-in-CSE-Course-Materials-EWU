package movieticketbookingsystem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WalletPaymentTest {

    private WalletPayment walletPayment;

    @Before
    public void setUp() {
        walletPayment = new WalletPayment(50.00, "WALLET123");
    }

    @After
    public void tearDown() {
        walletPayment = null;
    }

    @Test
    public void testProcessPayment() {
        System.out.println("Testing processPayment...");
        boolean result = walletPayment.processPayment();
        assertTrue("Payment should be successful", result);
    }

    @Test
    public void testGenerateReceipt() {
        System.out.println("Testing generateReceipt...");
        walletPayment.generateReceipt();
        assertNotNull("Transaction ID should not be null after payment object creation", walletPayment.transactionID);
    }
    

    @Test
public void testProcessPaymentWithZeroAmount() {
    WalletPayment zeroPayment = new WalletPayment(0.0, "WALLET000");
    boolean result = zeroPayment.processPayment();
    assertTrue(result);
}
@Test
public void testProcessPaymentMultipleTimes() {
    assertTrue(walletPayment.processPayment());
    assertTrue(walletPayment.processPayment());
}

  @Test
public void testProcessPaymentWithNegativeAmount() {
    WalletPayment payment = new WalletPayment(-10.0, "NEG123");
    boolean result = payment.processPayment();
    assertTrue(result);
}
  
}
