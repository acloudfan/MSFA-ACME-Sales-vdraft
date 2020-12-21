package com.acme.sales.model.tests.fake.repo;

import com.acme.sales.model.booking.BookingConfirmation;
import com.acme.sales.model.repo.BookingConfirmationRepo;

import java.util.ArrayList;

/**
 * Fake repo implementation for testing
 */
public class BookingConfirmationRepoFake implements BookingConfirmationRepo {

    // In memory collection to simulate the database
    private ArrayList<BookingConfirmation> collection = new ArrayList<>();

    @Override
    public BookingConfirmation add(BookingConfirmation bookingConfirmation) {
        collection.add(bookingConfirmation);
        return bookingConfirmation;
    }

    @Override
    public BookingConfirmation get(int reference) {
        // Loop through the collection
        for(BookingConfirmation bookingConfirmation : collection){
            if(bookingConfirmation.getReference() == reference) {
                return   bookingConfirmation;
            }
        }
        return null;
    }

    @Override
    public BookingConfirmation getByCustomer(int customerReference) {
        // Loop through the collection
        for(BookingConfirmation bookingConfirmation : collection){
            if(bookingConfirmation.getCustomerReference() == customerReference) {
                return   bookingConfirmation;
            }
        }
        return null;
    }

    @Override
    public boolean remove(int reference) {
        // Loop through the collection
        for(BookingConfirmation bookingConfirmation : collection){
            if(bookingConfirmation.getReference() == reference) {
                collection.remove(bookingConfirmation);
                return   true;
            }
        }
        return false;
    }
}
