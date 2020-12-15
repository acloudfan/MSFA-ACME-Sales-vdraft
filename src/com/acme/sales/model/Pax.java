package com.acme.sales.model;

/**
 * Strategic Pattern: Value Object
 * Persistence: Stored as part of the proposal
 * Model: Acme Sales
 * Represents a Pax or Passengers
 */

public class Pax {

    // Name
    public final String fName;
    public final String mName;
    public final String lName;

    // Age
    private final int age;

    /**
     * Constructor
     * @param fName
     * @param mName
     * @param lName
     * @param age
     */
    public Pax(String fName, String mName, String lName, int age) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
        this.age = age;
    }
}