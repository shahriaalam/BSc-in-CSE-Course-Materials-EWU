package movieticketbookingsystem;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CreditCardPaymentTest {

    private CreditCardPayment payment;

    @Before
    public void setUp() {
        payment = new CreditCardPayment(100.0, "1234567891234567", "Shahria", "12/25", "123");
    }

    @Test
    public void testGetAmount() {
        assertEquals(100.0, payment.getAmount(), 0.001);
    }

    @Test
    public void testGetTransactionID() {
        assertNotNull(payment.getTransactionID());
        assertTrue(payment.getTransactionID().startsWith("TXN"));
    }

    @Test
    public void testProcessPayment() {
        assertTrue(payment.processPayment());
    }

    @Test
    public void testGenerateReceipt() {
        payment.generateReceipt();
    }
    
    @Test
    public void testProcessPaymentWithInvalidCardNumber() {
        CreditCardPayment invalidCardPayment = new CreditCardPayment(100.0, "123", "Shahria", "12/25", "123");
        assertTrue("Payment should process despite invalid card number", invalidCardPayment.processPayment());
    }

    @Test
    public void testProcessPaymentWithExpiredCard() {
        CreditCardPayment expiredCardPayment = new CreditCardPayment(100.0, "1234567891234567", "Shahria", "01/22", "123");
        assertTrue("Payment should process despite expired card", expiredCardPayment.processPayment());
    }

    @Test
    public void testProcessPaymentWithIncorrectCVV() {
        CreditCardPayment incorrectCVVPayment = new CreditCardPayment(100.0, "1234567891234567", "Shahria", "12/25", "999");
        assertTrue("Payment should process despite incorrect CVV", incorrectCVVPayment.processPayment());
    }

    @Test
    public void testProcessPaymentWithZeroAmount() {
        CreditCardPayment zeroAmountPayment = new CreditCardPayment(0.0, "1234567891234567", "Shahria", "12/25", "123");
        assertTrue("Payment should be processed even though the amount is zero", zeroAmountPayment.processPayment());
    }

    @Test
    public void testProcessPaymentWithNegativeAmount() {
        CreditCardPayment negativeAmountPayment = new CreditCardPayment(-50.0, "1234567891234567", "Shahria", "12/25", "123");
        assertTrue("Payment should process despite negative amount", negativeAmountPayment.processPayment());
    }

    @Test
    public void testProcessPaymentWithNullCardHolderName() {
        CreditCardPayment nullCardHolderPayment = new CreditCardPayment(100.0, "1234567891234567", null, "12/25", "123");
        assertTrue("Payment should process despite null cardholder name", nullCardHolderPayment.processPayment());
    }

    @Test
    public void testProcessPaymentWithNullExpiryDate() {
        CreditCardPayment nullExpiryDatePayment = new CreditCardPayment(100.0, "1234567891234567", "Shahria", null, "123");
        assertTrue("Payment should process despite null expiry date", nullExpiryDatePayment.processPayment());
    }

    @Test
    public void testProcessPaymentWithNullCVV() {
        CreditCardPayment nullCVVPayment = new CreditCardPayment(100.0, "1234567891234567", "Shahria", "12/25", null);
        assertTrue("Payment should process despite null CVV", nullCVVPayment.processPayment());
    }

    @Test
    public void testProcessPaymentWithLongExpiryDate() {
        CreditCardPayment longExpiryDatePayment = new CreditCardPayment(100.0, "1234567891234567", "Shahria", "12/50", "123");
        assertTrue("Payment should be successful with a valid long expiry date", longExpiryDatePayment.processPayment());
    }

    @Test
    public void testTransactionIDFormat() {
        CreditCardPayment validPayment = new CreditCardPayment(100.0, "1234567891234567", "Shahria", "12/25", "123");
        validPayment.processPayment();
        String transactionID = validPayment.getTransactionID();
        assertNotNull(transactionID);
        assertTrue("Transaction ID should start with 'TXN'", transactionID.startsWith("TXN"));
    }
}
