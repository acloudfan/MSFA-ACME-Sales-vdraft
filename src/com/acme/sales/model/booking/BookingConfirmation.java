package com.acme.sales.model.booking;


import com.acme.sales.model.Proposal;
import com.acme.sales.model.Pax;
import com.acme.sales.model.payment.PaymentConfirmation;

import java.util.ArrayList;

/**
 * Strategic Pattern: Aggregate
 * Contains all of the information on the vacation pckage booking
 * Model: Acme Sales
 * Represents the sale proposal prepared for the customer
 */
public class BookingConfirmation {

    /**
     * Enumeration for the state machine
     */
    public enum BookingConfirmationState {
        PENDING_PAYMENT,
        PENDING_RESERVATION,
        RESERVATION_IN_PROGRESS,
        CONFIRMED,
        CANCELLATION_IN_PROGRESS,
        CANCELLED,
        UNKNOWN
    }

    /**
     * Manages state of reservation
     */
    private BookingConfirmationState  status = BookingConfirmationState.UNKNOWN;

    /**
     * Has a unique Booking reference
     */
    private int reference;

    /**
     * Reference to the proposal that customer has committed to
     */
    private int proposalReference;

    /**
     * Reference to the customer record
     */
    private int customerReference;

    /**
     * Holds payment confirmation record
     */
    private PaymentConfirmation paymentConfirmation;

    /**
     * Passengers information
     */
    private ArrayList<Pax>  paxs;

    /**
     * The vacation package may have multiple parts such as Hotel, Car, Air tickets ...
     * The objects representing the reservations are added to this list
     */
    private ArrayList<Reservation> reservations;

    /**
     * Instance is created from the proposal
     */
    public BookingConfirmation(Proposal proposal) {
        // Setup the reference to proposal
        proposalReference = proposal.getReference();

        // Setup the reference to customer
        customerReference = proposal.getCustomerReference();

        // Get the reservation holders
//        reservations = proposal.ge
    }
}
