package com.acme.infra.rabbitmq;

import com.acme.sales.model.utils.event.messaging.Messaging;
import com.acme.sales.model.utils.event.messaging.MessagingException;

import java.util.HashMap;
import java.util.Properties;

/**
 * Encapsulates the messaging API for Rabbit MQ
 */
public class PubSub implements Messaging {

    public final String AMQP_URL;
    public final String AMQP_PASSWORD;

//    ConnectionFactory factory = new ConnectionFactory();
//    Channel channel = null;

    /**
     *
     * @param props contail all of the MQ specific properties
     */
    public PubSub(HashMap<String, String> props){
        AMQP_URL = props.get("AMQP_URL");
        AMQP_PASSWORD = props.get("AMQP_PASSWORD");


    }


    @Override
    public void publish(Properties metadata, String data) throws MessagingException {

    }

    @Override
    public void subscribe(String topic) {

    }
}
