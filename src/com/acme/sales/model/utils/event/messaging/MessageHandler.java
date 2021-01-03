package com.acme.sales.model.utils.event.messaging;

import java.util.Properties;

public interface MessageHandler {
    /**
     * Function implemented by the handler
     * @return
     */
    public boolean handleMessage(Properties metadata, String payload);

}
