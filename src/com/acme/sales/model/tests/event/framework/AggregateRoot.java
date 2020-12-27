package com.acme.sales.model.tests.event.framework;

import com.acme.sales.model.utils.event.EventBus;

/**
 * Class that represents an Aggregate Root
 */
public class AggregateRoot {
    // Assume there are attributes
    // Assume there is a reference to a repository

    public final static String SOME_ACTION_EVENT = "SOME_ACTION_EVENT";

    /**
     * Represents a business action that led to a change in the state of aggregate
     * This throws an event
     */
    public void someAction(){
        // Logic that carries out the process steps
        // Change in state happens successfully

        EventBus.raise(new SomeActionEvent("this is the payload"));
    }
}
