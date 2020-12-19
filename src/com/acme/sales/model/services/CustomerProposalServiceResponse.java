package com.acme.sales.model.services;

import com.acme.sales.model.Customer;
import com.acme.sales.model.Proposal;

import java.util.ArrayList;

/**
 * Represents the response for the CustomerProposalService
 */
public class CustomerProposalServiceResponse {
    public final Customer  customer;
    public final ArrayList<Proposal> proposals;

    public CustomerProposalServiceResponse(Customer customer, ArrayList<Proposal> proposals) {
        this.customer = customer;
        this.proposals = proposals;
    }
}
