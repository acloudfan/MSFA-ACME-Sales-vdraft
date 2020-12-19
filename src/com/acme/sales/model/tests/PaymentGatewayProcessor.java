package com.acme.sales.model.tests;

import com.acme.sales.model.payment.PaymentConfirmation;
import com.acme.sales.model.services.PaymentGateway;

import java.util.Date;

/**
 * Fake implementation of the Infrastructure Service
 */
public class PaymentGatewayProcessor implements PaymentGateway {
    @Override
    public PaymentConfirmation processPayment(String creditCardNumber, int expiryMonth, int expiryYear, String zipCode) {

        // generate a fake confirmation
        PaymentConfirmation  paymentConfirmation = new PaymentConfirmation(10000, new Date());

        return paymentConfirmation;
    }

    /**
     * This issues a full refund - support for partial refund not needed
     * @param paymentConfirmation
     * @return
     */
    @Override
    public PaymentConfirmation processRefund(PaymentConfirmation paymentConfirmation) {

        // Simulate payment cancellation
        PaymentConfirmation  cancelledPaymentConfirmation = new PaymentConfirmation(paymentConfirmation, 5000, new Date());

        return cancelledPaymentConfirmation;
    }

}
