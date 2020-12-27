package com.acme.sales.model.payment;

import com.acme.sales.model.utils.event.Event;

/**
 * Represents an event for "PaymentReceived"
 */

public class PaymentReceived extends Event {

    public PaymentReceived(PaymentAudit paymentAudit ) {
        super("PaymentReceived", paymentAudit);
    }

    public PaymentAudit getPaymentAudit(){
        return (PaymentAudit) payload;
    }
}
