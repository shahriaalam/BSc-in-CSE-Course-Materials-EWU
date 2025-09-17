package movieticketbookingsystem;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PayPalPaymentTest {

    private PayPalPayment payPalPayment;

    @Before
    public void setUp() {
        payPalPayment = new PayPalPayment(15.0, "testuser@example.com");
    }

   
    @Test
    public void testProcessPayment() {
        System.out.println("processPayment");
        boolean result = payPalPayment.processPayment();
        assertTrue("Payment should be processed successfully", result);
    }

 
    @Test
    public void testGenerateReceipt() {
        System.out.println("generateReceipt");
        payPalPayment.generateReceipt();
        assertNotNull("Receipt should be generated", payPalPayment.getTransactionID());
        assertTrue("Transaction ID should start with 'TXN'", payPalPayment.getTransactionID().startsWith("TXN"));
    }

   
    @Test
    public void testProcessPaymentWithNullEmail() {
        PayPalPayment nullEmailPayment = new PayPalPayment(20.0, null);
        boolean result = nullEmailPayment.processPayment();
        assertTrue("Payment should still process even with a null email", result);
    }

  
    @Test
    public void testProcessPaymentWithEmptyEmail() {
        PayPalPayment emptyEmailPayment = new PayPalPayment(25.0, "");
        boolean result = emptyEmailPayment.processPayment();
        assertTrue("Payment should still process even with an empty email", result);
    }


    @Test
    public void testProcessPaymentWithZeroAmount() {
        PayPalPayment zeroAmountPayment = new PayPalPayment(0.0, "zeroamount@example.com");
        boolean result = zeroAmountPayment.processPayment();
        assertTrue("Payment should be processed successfully even with a zero amount", result);
    }

  
    @Test
    public void testProcessPaymentWithLargeAmount() {
        PayPalPayment largeAmountPayment = new PayPalPayment(1000000.0, "largepayment@example.com");
        boolean result = largeAmountPayment.processPayment();
        assertTrue("Payment should be processed successfully with a large amount", result);
    }

    @Test
    public void testTransactionIDFormat() {
        PayPalPayment validPayment = new PayPalPayment(50.0, "testuser@example.com");
        validPayment.processPayment();
        String transactionID = validPayment.getTransactionID();
        assertNotNull("Transaction ID should not be null", transactionID);
        assertTrue("Transaction ID should start with 'TXN'", transactionID.startsWith("TXN"));
    }

   
}
