package com.acme.sales.model.tests.fake.repo;

import com.acme.sales.model.payment.PaymentAudit;
import com.acme.sales.model.repo.PaymentAuditRepo;

import java.util.ArrayList;

public class PaymentAuditRepoFake implements PaymentAuditRepo {

    private ArrayList<PaymentAudit>  paymentAudits = new ArrayList<>();

    @Override
    public long add(PaymentAudit paymentAudit) {
        paymentAudits.add(paymentAudit);

        long fakeReference = System.currentTimeMillis();

        return fakeReference;
    }

    @Override
    public PaymentAudit get(long reference) {
        return null;
    }
}
