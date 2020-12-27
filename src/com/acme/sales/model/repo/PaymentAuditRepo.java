package com.acme.sales.model.repo;

import com.acme.sales.model.payment.PaymentAudit;

public interface PaymentAuditRepo {

    // Returns the reference to the audit record
    public  int   add(PaymentAudit paymentAudit);

    public PaymentAudit  get(String reference);

}
