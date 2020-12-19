package com.acme.sales.model.services;

import com.acme.sales.model.payment.PaymentConfirmation;

/**
 * Pattern: Infrastructure Service
 * Sales system depend on external payment gateway service for processing credit card payments
 * This interface defines the payment gateway interface Idea is that it may be switched if there is a need
 */
public interface PaymentGateway {

    /**
     * This is to process the payment with the credit card provided by the customer
     * @param creditCardNumber
     * @param expiryMonth
     * @param expiryYear
     * @param zipCode
     * @return  the reference code -1 if payment declined
     */
    public PaymentConfirmation processPayment(String creditCardNumber, int expiryMonth, int expiryYear, String zipCode);

    /**
     * Customer may cancel the purchase and hence will be refunded the amount paid.
     * @param paymentConfirmation
     * @return
     */
    public PaymentConfirmation processRefund(PaymentConfirmation paymentConfirmation);


}
