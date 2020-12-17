package com.acme.sales.model.tests.fake;

import com.acme.sales.model.Proposal;
import com.acme.sales.model.repo.ProposalRepo;

import java.util.ArrayList;

public class ProposalRepoFake implements ProposalRepo {
    // In memory collection to simulate the database
    private ArrayList<Proposal>  collection = new ArrayList<>();

    @Override
    public boolean add(Proposal proposal) {
        collection.add(proposal);
        return true;
    }

    @Override
    public Proposal get(int reference) {
        // Loop through the collection
        for(Proposal proposal : collection){
            if(proposal.getReferenceNumber() == reference) {
                return   proposal;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Proposal> getCustomerProposals(int customerReference) {
        ArrayList<Proposal>  list = new ArrayList<>();
        // Loop through the collection
        for(Proposal proposal : collection){
            if(proposal.getCustomerReference() == customerReference) {
                list.add(proposal);
            }
        }
        return list;
    }

    @Override
    public boolean remove(int reference) {
        // Loop through the collection
        for(Proposal proposal : collection){
            if(proposal.getReferenceNumber() == reference) {
                collection.remove(proposal);
                return   true;
            }
        }
        return false;
    }
}
