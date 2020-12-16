package com.acme.sales.model.booking;

public class RentalCarReservation extends Reservation {


    public RentalCarReservation(String provider) {
        super(ReservationTypes.CAR_RENTAL, provider);
    }


    @Override
    public boolean reserve(){
        // Successful reservation will set the reservationReference
        reservationReference =  "fake-car-reservation-ref";
        return true;
    }

    @Override
    public boolean cancel() {
        // Set the cancellation reference
        cancellationReference = "fake-car-cancellation-ref";

        return true;
    }
}
