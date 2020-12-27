package com.acme.sales.model.tests.event.framework;

import com.acme.sales.model.utils.event.Event;
import com.acme.sales.model.utils.event.EventHandler;

public class SomeActionHappened implements EventHandler {
    @Override
    public void handle(Event event) {
        System.out.println(this.getClass()+": Handler executed");
    }
}
