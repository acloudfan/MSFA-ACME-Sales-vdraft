package com.acme.sales.model.booking;

public class AirlineReservation extends Reservation {
    public AirlineReservation(String provider) {
        super(ReservationTypes.AIRLINE, provider);
    }

    @Override
    public boolean reserve(){
        // Successful reservation will set the reservationReference
        reservationReference =  "fake-airline-reservation-ref";
        return true;
    }

    @Override
    public boolean cancel() {
        // Set the cancellation reference
        cancellationReference = "fake-airline-cancellation-ref";

        return true;
    }

    @Override
    public String getReservationReference() {
        return super.getReservationReference();
    }


}
