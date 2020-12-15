package com.acme.sales.model.booking;

public class RentalCarReservation extends Reservation {


    public RentalCarReservation(String provider){
        super(provider);
    }

    @Override
    public String reserve(){
        // Successful reservation will set the reservationReference

        return "fake-reservation-id";
    }

    @Override
    public boolean cancel() {
        return true;
    }
}
