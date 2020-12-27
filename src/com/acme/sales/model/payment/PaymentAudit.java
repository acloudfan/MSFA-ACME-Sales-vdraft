package com.acme.sales.model.payment;

import com.acme.sales.model.repo.PaymentAuditRepo;
import com.acme.sales.model.services.PaymentGateway;
import com.acme.sales.model.services.PaymentGatewayTransaction;
import com.acme.sales.model.services.PaymentGatewayTransactionDetails;

import java.util.Date;

/**
 * Pattern : Entity
 * Regulatory requirements require all payment records to be maintained for 7 years
 * This object represents the record of the customer's payment
 */
public class PaymentAudit {

    private String   reference;
    private int      bookingReference;
    private Date     transactionDate;


    private String   transactionType;  // Charge, Refund

    private double transactionAmount;

    private String  cardHolderLastName;
    private String  cardHolderFirstName;

    private String   creditCardNumber;
    private String   zipCode;
    private int      expiryMonth;
    private int      expiryYear;


    /**
     * This aggregate is aware of the Repository
     */
    private static PaymentAuditRepo     paymentAuditRepo;


    /**
     * This is to create an instance of the existing record
     */
    public PaymentAudit(String reference, int bookingReference, Date transactionDate, String transactionType, double transactionAmount,
                        String cardHolderLastName, String cardHolderFirstName,
                        String   creditCardNumber, String   zipCode,  int      expiryMonth, int      expiryYear) {

        this.reference = reference;
        this.bookingReference = bookingReference;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.cardHolderLastName = cardHolderLastName;
        this.cardHolderFirstName = cardHolderFirstName;
        this.creditCardNumber = creditCardNumber;
        this.zipCode = zipCode;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }

    /**
     * This creates an instance of the payment audit that is used for processing the payment
     */
    public PaymentAudit(int bookingReference, String transactionType, double transactionAmount, String cardHolderLastName, String cardHolderFirstName) {

        // MUST set to 0 to indicate that this is a new payment instance
        this.reference = null;
        this.bookingReference = bookingReference;
        this.transactionAmount = transactionAmount;
        this.cardHolderLastName = cardHolderLastName;
        this.cardHolderFirstName = cardHolderFirstName;
        this.transactionType = transactionType;
    }

    /**
     * Checks if the instance represents an already processed payment
     * @return
     */
    public boolean isAlreadyProcessed(){
        return (reference != null);
    }

    /**
     * Process Payment
     * This function MUST be atomic - This implementation is NOT atomic as it is for demonstration purposes only
     */
    public boolean processPayment(String creditCardNumber,  int expiryMonth, int expiryYear, String zipCode, double amount, PaymentGateway paymentGateway) {

        if(isAlreadyProcessed()){
            // This represents an already processed payment
            // throw an Exception
            return false;
        }

        // Save the credit card information in the audit
        this.creditCardNumber = creditCardNumber;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
        this.zipCode = zipCode;

        // Call the Payment Service
        PaymentGatewayTransaction  gatewayTxn =  paymentGateway.processPayment(creditCardNumber,expiryMonth, expiryYear, zipCode, amount);

        // Get the details of the transaction
        PaymentGatewayTransactionDetails  txnDetails = paymentGateway.getTransactionDetails(gatewayTxn.reference);

        // Set it up in the aggregate
        this.reference = txnDetails.reference;
        this.transactionType = txnDetails.transactionType;
        this.transactionDate = txnDetails.transactionDate;

        // Aggregate Saves itself
        if(paymentAuditRepo.add(this)){

            // Raise the Event

        } else {
            // There is a problem - someone need to be notified "Payment processed & Payment Audit could NOT be created !!!!
        }

        return true;
    }
}
