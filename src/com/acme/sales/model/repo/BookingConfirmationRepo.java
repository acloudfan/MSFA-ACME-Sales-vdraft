package com.acme.sales.model.repo;

import com.acme.sales.model.booking.BookingConfirmation;

/**
 * Tactical Pattern: Repository
 * Model: Acme Sales
 * Represents a Booking Confirmation repository
 */
public interface BookingConfirmationRepo {

    /**
     * Add
     */
    public BookingConfirmation  add(BookingConfirmation bookingConfirmation);

    /**
     * Get
     */
    public BookingConfirmation get(int reference);
    public BookingConfirmation getByCustomer(int customerReference);

    /**
     * Remove
     */
    public boolean remove(int reference);

}
