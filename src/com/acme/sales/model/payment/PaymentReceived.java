package com.acme.sales.model.payment;

import com.acme.sales.model.utils.events.Event;

/**
 * Represents an event for "PaymentReceived"
 */

public class PaymentReceived extends Event {

    public PaymentReceived(PaymentConfirmation paymentConfirmation ) {
        super("PaymentReceived", paymentConfirmation);
    }

    public PaymentConfirmation getPaymentConfirmation(){
        return (PaymentConfirmation) payload;
    }
}
