package com.acme.sales.model.tests.event.audit;

import com.acme.sales.model.booking.BookingConfirmation;
import com.acme.sales.model.payment.PaymentAudit;
import com.acme.sales.model.payment.PaymentReceived;
import com.acme.sales.model.repo.BookingConfirmationRepo;
import com.acme.sales.model.repo.PaymentAuditRepo;
import com.acme.sales.model.services.PaymentGateway;
import com.acme.sales.model.tests.PaymentGatewayProcessor;
import com.acme.sales.model.tests.RepoCollectionsTest;
import com.acme.sales.model.tests.fake.repo.PaymentAuditRepoFake;
import com.acme.sales.model.utils.event.EventBus;

/**
 * Demonstrates the working of the PaymentAudit functionality
 */
public class PaymentAuditTest {

    public static void main(String[] args){

        // 1. Get the reference to Booking confirmation repo (Fake)
        BookingConfirmationRepo bookingConfirmationRepo = RepoCollectionsTest.bookingConfirmationRepo;

        // 2. Create an instance of the Handler & Register the handler
        System.out.println("===== Register the handler ===="+com.acme.sales.model.booking.PaymentReceived.class);
        com.acme.sales.model.booking.PaymentReceived  paymentReceived =
                new com.acme.sales.model.booking.PaymentReceived(bookingConfirmationRepo);
        EventBus.register(PaymentReceived.EVENT_PAYMENT_RECEIVED, paymentReceived);

        // 3. The repo is already initialized with a Booking confirmation with reference = 928
        BookingConfirmation  bookingConfirmation = bookingConfirmationRepo.get(928);
        System.out.println("===== Get BookingConfirmation object for which customer is paying ====");
        System.out.println(bookingConfirmation);

        // Uncomment this to see the details of the BookingConfirmation object
        // System.out.println(bookingConfirmation);

        // 4. Create a fake instance of the payment gateway
        PaymentGateway paymentGateway = new PaymentGatewayProcessor();

        // 5. Create an instance of the PaymentAuditRepo
        PaymentAuditRepo paymentAuditRepo = new PaymentAuditRepoFake();

        // 6. Now lets process the payment => This should lead to processing in the Handler
        System.out.println("===== Proces Payment using the PaymentAudit.pay(...) ====");
        // New class that represents the PaymentAudit Entity
        PaymentAudit paymentAudit = new PaymentAudit(bookingConfirmation.getReference(),"CHARGE", paymentAuditRepo);
        paymentAudit.processPayment("13245555",05,2030,
                "91620",1092.23,
                "Wang","Michael",paymentGateway);

        // 7. Now compare the Before & After status of the Booking confirmation
        System.out.println(bookingConfirmation);

    }
}
