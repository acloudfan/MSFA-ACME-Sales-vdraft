package com.acme.sales.model.repo;

import com.acme.sales.model.payment.PaymentAudit;

public interface PaymentAuditRepo {

    public  boolean   add(PaymentAudit paymentAudit);

    public PaymentAudit  get(String reference);

}
