package com.acme.sales.model.services;

import java.util.Date;

public class PaymentGatewayTransactionDetails {
    public final    String  reference;
    public final    String  cardHolderLastName;
    public final    String  cardHolderFirstName;
    public final    Date    transactionDate;
    public final    String  transactionType;  // Payment, Refund

    public PaymentGatewayTransactionDetails(String reference, String cardHolderLastName, String cardHolderFirstName, Date transactionDate, String transactionType) {
        this.reference = reference;
        this.cardHolderLastName = cardHolderLastName;
        this.cardHolderFirstName = cardHolderFirstName;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
    }
}
