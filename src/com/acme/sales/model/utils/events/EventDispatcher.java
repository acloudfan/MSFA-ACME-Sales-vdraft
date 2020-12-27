package com.acme.sales.model.utils.events;

import java.util.ArrayList;



/**
 * Handles the execution of the Handler
 *
 * Each dispatcher will handle only ONE type of event
 */
public class EventDispatcher {

    public final String eventName;

    ArrayList<EventHandler>  handlers = new ArrayList<>();

    public EventDispatcher(String eventName) {
        this.eventName = eventName;
    }

    public boolean register(EventHandler handler){
        // Make sure that Hanlder is not registered already - otherwise you have duplication issues !!!
        if(handlers.contains(handler)){
            return false;
        }

        return handlers.add(handler);
    }

    public boolean deregister(EventHandler handler){
        return handlers.remove(handler);
    }

    /**
     * Executes the event handler code for all registered handlers
     * @param event
     */
    public boolean dispatch(Event event){
        if(handlers.size() == 0) return false;

        for(EventHandler handler : handlers){
            handler.handle(event);
        }
        return true;
    }
}
