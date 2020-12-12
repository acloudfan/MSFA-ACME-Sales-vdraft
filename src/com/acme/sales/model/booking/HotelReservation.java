package com.acme.sales.model.booking;

/**
 * This is to mange the reservation of the hotel
 */
public class HotelReservation extends Reservation {

    public HotelReservation(String provider){
        super(provider);
    }

    @Override
    public String reserve(){
        return "fake-reservation-id";
    }

    @Override
    public boolean cancel() {
        return true;
    }
}
