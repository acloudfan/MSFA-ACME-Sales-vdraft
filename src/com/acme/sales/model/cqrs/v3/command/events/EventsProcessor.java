package com.acme.sales.model.cqrs.v3.command.events;

import com.acme.infra.rabbitmq.PubSubService;
import com.acme.sales.model.utils.event.messaging.MessagingException;

import java.util.ArrayList;
import java.util.Base64;

/**
 * This is a scheduled event processor job that continuously try to send the unsent events to MQ
 */
public class EventsProcessor implements  Runnable{

    // Wakes up every 10 seconds
    public final static long   SLEEP_TIME = 30000;

    private PubSubService pubSubService;
    private ProposalEventRepo proposalEventRepo = new ProposalEventRepo();

    public EventsProcessor(PubSubService pubSubService) {
        this.pubSubService = pubSubService;
    }

    /**
     * Publishes the event and then update the status
     * @param event
     */
    private void processEvent(ProposalEvent event){
        String payload = new String(Base64.getDecoder().decode(event.payloadBase64));

        System.out.println(payload);

        // 9. Publish the event
        try {
            pubSubService.start();

            pubSubService.publish(payload);

            // Mark the status updated
            // This will NOT happen if there is a failure in publish
            proposalEventRepo.markEventProcessed(event.event_id);

        } catch (MessagingException me) {
            me.printStackTrace();
        }finally{
            try{pubSubService.stop();}catch(Exception e){}
        }
    }

    @Override
    public void run() {
        while(true) {
            ArrayList<ProposalEvent> unsentEvents = proposalEventRepo.getUnprocessed();
            System.out.println("Unprocessed event count = "+unsentEvents.size());
            if (unsentEvents.size() > 0) {
                for(ProposalEvent event : unsentEvents)
                    processEvent(event);
            }
        }
    }


}
