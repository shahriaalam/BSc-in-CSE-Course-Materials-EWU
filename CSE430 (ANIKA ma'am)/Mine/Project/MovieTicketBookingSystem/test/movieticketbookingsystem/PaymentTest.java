package movieticketbookingsystem;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaymentTest {

    private Payment payment;
    private Payment paymentWithZeroAmount;
    private Payment paymentWithNegativeAmount;

    @Before
    public void setUp() {
        payment = new CreditCardPayment(100.0, "4111111111111111", "TestUser", "12/25", "123");
        paymentWithZeroAmount = new CreditCardPayment(0.0, "4111111111111111", "TestUser", "12/25", "123");
        paymentWithNegativeAmount = new CreditCardPayment(-100.0, "4111111111111111", "TestUser", "12/25", "123");
    }

    @Test
    public void testGetAmount() {
        assertEquals(100.0, payment.getAmount(), 0.01);
    }

    @Test
    public void testGetTransactionID() {
        String transactionID = payment.getTransactionID();
        assertNotNull(transactionID);
        assertTrue(transactionID.startsWith("TXN"));
    }

    @Test
    public void testProcessPayment() {
        assertTrue(payment.processPayment()); // Ensure payment is processed successfully
    }

   
    @Test
    public void testProcessPaymentWithZeroAmount() {
        assertTrue(paymentWithZeroAmount.processPayment()); // Zero payment should still succeed
    }

  

    @Test
    public void testTransactionIDFormat() {
        String transactionID = payment.getTransactionID();
        assertNotNull(transactionID);
        assertTrue(transactionID.startsWith("TXN"));
    }

  

    @Test
    public void testValidCreditCardPayment() {
        assertTrue(payment.processPayment());
    }

    @Test
    public void testLargeAmountPayment() {
        Payment largeAmountPayment = new CreditCardPayment(1000000.0, "4111111111111111", "TestUser", "12/25", "123");
        assertTrue(largeAmountPayment.processPayment());
    }

    @Test
    public void testNullAmountPayment() {
        try {
            Payment nullAmountPayment = new CreditCardPayment(0.0, "4111111111111111", "TestUser", "12/25", "123");
            assertNotNull(nullAmountPayment);
        } catch (Exception e) {
            fail("Payment with zero amount should not throw an exception");
        }
    }

    @Test
    public void testGenerateReceipt() {
        payment.generateReceipt();
        assertNotNull(payment.getTransactionID());
    }

}
