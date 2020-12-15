package com.acme.sales.model.booking;

/**
 * All provider reservation classes inherit from this class
 */
public abstract class Reservation {

    // ID of the Provider
    protected final String provider;

    // Reference code provided by the Provider for reservation
    protected String reservationReference;

    // Reference code provided by the Provider for cancellation
    protected String cancellationReference;


    public Reservation(String provider) {
        this.provider = provider;
    }

    /**
     * This is to initiate the reservation process
     * @return
     */
    public abstract String reserve();

    /**
     * This is to initiate the cancellation process
     * @return
     */
    public abstract boolean cancel();

    /**
     * Returns the reservation number
     */
    public String getReservationReference(){
        return reservationReference;
    }
}
