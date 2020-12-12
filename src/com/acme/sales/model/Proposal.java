package com.acme.sales.model;

import com.acme.sales.model.Offer;
import com.acme.sales.model.Pax;
import com.acme.sales.model.VacationPackage;

import java.util.ArrayList;
import java.util.Date;

/**
 * Strategic Pattern: Entity
 * Created when a customer calls ACME to buy package. Customer may request creation of multiple proposals
 * Model: Acme Sales
 * Represents the sale proposal prepared for the customer
 */
public class Proposal {

    // Proposal reference;
    private String referenceCode;

    // Creation date
    private Date createdDate;

    // Proposal expiry
    private Date  expiry;

    // This the product for which the proposal is getting created
    private VacationPackage vacationPackage;

    // Count of the passengers
    private int paxCount;

    // Pax Details
    private ArrayList<Pax> passengers;

    // Customer instructions
    // Agents like to put notes on each proposal that other agents may read
    private ArrayList<String> notes;

    // Price after discount
    private double offerPrice;

    // Business Rule ONLY 2 offers can be applied to a proposal
    private Offer[] offersApplied = new Offer[2];

    // Status
    enum  Status {
        ACCEPTED,
        REJECTED, /** Customer has rejected the proposal **/
        ON_HOLD,  /** Customer has not made a decision **/
        AWAITING_CONFIRMATION,   /** Customer has paid but providers need to confirm **/
        UNKNOWN
    }

    // Proposal status
    private Status  status=Status.UNKNOWN;


    /**
     * Behavior
     */

    /**
     * By default all proposals expire in 14 days of creation
     * But sales people have authority to extend up to 30 days -
     * Business Rule: It can not go beyond the validity of the package !!
     * @return
     */
    public boolean setupExpiry(int numDays){
        // Business Rule : New expiry should be < product validity date
        return true;
    }

    private String generateReferenceCode(){
        // Business Rule: 3 letter fname + 3 letter of last name + 3 letter of product + MM + DD + YY
        return "";
    }

    /**
     * Book the package
     */
    public boolean bookPackage(){
        return true;
    }

    /**
     * This applies the offer to the Vacation Product
     */
    public double applyOffer(Offer  offer){
        return 0.0;
    }
}
