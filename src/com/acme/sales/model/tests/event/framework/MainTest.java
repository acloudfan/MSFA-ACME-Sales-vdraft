package com.acme.sales.model.tests.event.framework;

import com.acme.sales.model.utils.event.EventBus;
import com.acme.sales.model.utils.event.EventHandler;

public class MainTest {

    public static void main(String[] args){

        // Create a handler and register it
        EventHandler  handler = new SomeActionHappened();
        EventBus.register(AggregateRoot.SOME_ACTION_EVENT, handler);

        // Assume that an aggregate was pulled from the repository
        AggregateRoot  aggregateRoot = new AggregateRoot();

        // Some action taken on the aggregate
        aggregateRoot.someAction();

    }
}
