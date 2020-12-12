package com.acme.sales.model.booking;


import com.acme.sales.model.Pax;

import java.util.ArrayList;

/**
 * Strategic Pattern: Aggregate
 * Contains all of the information on the vacation pckage booking
 * Model: Acme Sales
 * Represents the sale proposal prepared for the customer
 */
public class BookingConfirmation {

    /**
     * Has a unique Booking reference
     */
    private String bookingReference;

    /**
     * Reference to the proposal that customer has committed to
     */
    private String proposalReference;

    /**
     * Reference to the customer record
     */
    private String customerReference;

    /**
     * Holds payment confirmation record
     */
    private PaymentConfirmation paymentConfirmation;

    /**
     * Holds information on Hotel Reservation
     */
    private HotelReservation    hotelReservation;

    /**
     * Holds information on Airline Reservation
     */
    private AirlineReservation  airlineReservation;

    /**
     * Holds information on Rental Car Reservation
     */
    private RentalCarReservation rentalCarReservation;

    /**
     * Passengers information
     */
    private ArrayList<Pax>  paxs;

}
