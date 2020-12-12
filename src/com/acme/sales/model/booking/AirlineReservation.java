package com.acme.sales.model.booking;

public class AirlineReservation extends Reservation {
    public AirlineReservation(String provider) {
        super(provider);
    }

    @Override
    public String reserve() {
        return null;
    }

    @Override
    public boolean cancel() {
        return false;
    }

    @Override
    public String getReservationReference() {
        return super.getReservationReference();
    }
}
