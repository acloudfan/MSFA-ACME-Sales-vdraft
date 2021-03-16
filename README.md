# MSFA-ACME-Sales-v1.0

## SAGA Pattern


Prereq:
======
1. Cloud Karfaka cluster is setup  https://www.cloudkarafka.com/
2. Mongodb database AcmeTravel on  https://cloud.mongodb.com/

Test:
=====

1. Make sure that Kafka credentials are correctly set in the interface
com.acme.infra.kafka.KafkaConfiguration

2. Make sure that MongoDB credentials are correctly set in the class
com.acme.infra.mongodb.MongoDBBase

3. Open the Cloud Kafka console on cloudkarafka.com
*   3.1 Create a topic   *bookingsaga*
*   3.2 In the "Karafka Browser" start the consumer for the topic *bookingsaga*
   
4. Launch the SAGA services
*   4.1 com.acme.simulation.saga.booking.BookingSaga   (Orchestrator)
*   4.2 com.acme.simulation.saga.payment
*   4.3 com.acme.simulation.saga.reservations
   
5. To test use the open the class
   com.acme.simulation.saga.RunSgaTest
*   5.1 Set a unique booking_id
*   5.2 Execute RunSgaTest
*   5.3 Observe Saga message flow in the Karfka consumer started in #3



