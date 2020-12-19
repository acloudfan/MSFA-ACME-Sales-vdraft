package com.acme.sales.model.services;

import com.acme.sales.model.Customer;
import com.acme.sales.model.Proposal;
import com.acme.sales.model.repo.CustomerRepo;
import com.acme.sales.model.repo.ProposalRepo;

import java.util.ArrayList;

/**
 * Pattern: Application Service
 * Consolidates the customer & proposals data.
 * This service will get the Customer data and Proposals data put it in ONE object and return
 * This service may be exposed as a REST/API that can be invoked from a Front End application
 */
public class CustomerProposalService {

    // Use the Repo to get the customer data
    private CustomerRepo   customerRepo;

    // Use thet Repo to get the Proposals data
    private ProposalRepo   proposalRepo;

    public CustomerProposalService(CustomerRepo customerRepo, ProposalRepo proposalRepo) {
        this.customerRepo = customerRepo;
        this.proposalRepo = proposalRepo;
    }

    /**
     * Sets up the response object and returns to the caller
     * @param customerReference
     * @return
     */
    public CustomerProposalServiceResponse getCustomerProposals(int customerReference){
        Customer customer = customerRepo.get(customerReference);
        // If the customer does not exist then return
        if(customer == null) return null;

        ArrayList<Proposal> proposals = proposalRepo.getCustomerProposals(customerReference);

        return new CustomerProposalServiceResponse(customer, proposals);
    }
}
