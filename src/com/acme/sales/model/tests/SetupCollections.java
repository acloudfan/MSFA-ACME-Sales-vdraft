package com.acme.sales.model.tests;

import com.acme.sales.model.Address;
import com.acme.sales.model.Customer;
import com.acme.sales.model.VacationPackage;
import com.acme.sales.model.booking.AirlineReservation;
import com.acme.sales.model.booking.HotelReservation;
import com.acme.sales.model.booking.Reservation;
import com.acme.sales.model.tests.fake.CustomerRepoFake;
import com.acme.sales.model.tests.fake.VacatonPackageRepoFake;

import java.util.ArrayList;
import java.util.Date;

public class SetupCollections {
    public static CustomerRepoFake  customerRepoFake;
    public static VacatonPackageRepoFake vacatonPackageRepoFake;

    /**
     * Sets up the Fake Customer Collection
     */
    private static void generateCustomerData(){
        // Add some customers
        customerRepoFake = new CustomerRepoFake();
        Address address = new Address("123 mai st","","Kent","OH","92999",true);
        Customer  customer = new Customer("Micahel","","Wang",address,"2135551212","michael@wang.com");
        // This will be the primary key in the DB
        customer.setReferenceNumber(1000);
        customerRepoFake.add(customer);

        address = new Address("42 east summer lane","","Pesadinia","CA","90210",true);
        customer = new Customer("Jane","","Tito",address,"9185556171","jane@toto.com");
        customer.setReferenceNumber(1001);
        customerRepoFake.add(customer);

        address = new Address("500 Starburst Court","Apartment 2C","Houston","TX","76122",true);
        customer = new Customer("Mina","","Bhind",address,"5515551616","mina@bhind.com");
        customer.setReferenceNumber(1002);
        customerRepoFake.add(customer);
    }

    /**
     * Sets the fake vacation packages
     */
    private static void generateVacationPackage(){
        vacatonPackageRepoFake = new VacatonPackageRepoFake();

        // BAH3NIGHTHOTELAIR
        ArrayList<Reservation> holders = new ArrayList<>();
        // Add the hotel & airline reservation holder
        holders.add(new HotelReservation("BestWestern","H1234"));
        holders.add(new AirlineReservation("United Airlines","A4567"));
        VacationPackage vacationPackage = new VacationPackage("BAH3NIGHTHOTELAIR","3 Nights Stay in a 3 star Hotel. Door to dor shuttle included. Airfare covered.",
                3, VacationPackage.vacationPackageType.HOTEL_AIR,547.98,new Date(2021,01,31),true,false,"bahamas",
                holders);
        vacatonPackageRepoFake.add(vacationPackage);

        // FLKEYS5NIGHTHOTELAIRRENTAL
        holders = new ArrayList<>();
        holders.add(new HotelReservation("Marriott Key West","H1999"));
        holders.add(new AirlineReservation("American Airlines","A9122"));
        vacationPackage = new VacationPackage("FLKEYS5NIGHTHOTELAIRRENTAL","5 Nights Stay in a 4 star Hotel. Rental car pickup at airport. Airfare covered.",
                5, VacationPackage.vacationPackageType.HOTEL_AIR_CAR,800.98,new Date(2021,01,31),true,false,"florida",
                holders);
        vacatonPackageRepoFake.add(vacationPackage);
    }
}
