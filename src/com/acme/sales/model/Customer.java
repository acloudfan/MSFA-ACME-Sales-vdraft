package com.acme.sales.model;

/**
 * Strategic Pattern: Entity
 * Persistence: Stored in DB as a unique object
 * Model: Acme Sales
 * Represents a Customer
 */

public class Customer {

    // Customer identified uniquely by an email address
    public String email;

    // This is an alternate way to identify the customer
    public String phoneNumber;
    public Address address;

    // Name
    public final String fName;
    public final String mName;
    public final String lName;

    /**
     * Constructor - first time creation of the object would require the contact information to be validated
     */
    public Customer(String fName, String mName, String lName, Address address, String phoneNumber, String email) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;

        this.address = address;

        this.phoneNumber=phoneNumber;
        this.email=email;
    }


}
