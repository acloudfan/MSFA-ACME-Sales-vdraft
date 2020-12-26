package com.acme.sales.model.payment;

import java.util.Date;

/**
 * Pattern : Entity
 * Regulatory requirements require all payment records to be maintained for 7 years
 * This object represents the record of the customer's payment
 */
public class PaymentAudit {
    public final    int  reference;
    public final    int  bookingReference;
    public final    double transactionAmount;
    public final    String  cardHolderLastName;
    public final    String  cardHolderFirstName;
    public final    Date    transactionDate;
    public final    String  transactionType;  // Charge, Refund

    /**
     * Process Payment
     */
    public boolean processPayment(int bookingReference) {

        // Call the Payment Service

        //
    }
}
