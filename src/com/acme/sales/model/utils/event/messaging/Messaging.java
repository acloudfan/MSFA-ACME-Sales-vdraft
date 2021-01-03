package com.acme.sales.model.utils.event.messaging;

import java.util.Properties;

/**
 * Interface for messaging systems
 */
public interface Messaging {

    /**
     * This is for publishing an event
     */
    public void publish(Properties metadata, String data) throws MessagingException;

    /**
     * Subscribe
     * Blocks the caller
     */
    public void subscribe(String topic);

}
