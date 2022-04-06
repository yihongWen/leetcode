package zyj.yihong.design.behavior.listener;

import java.util.EventObject;

public abstract class MyAEvent extends EventObject {
    private String eventName;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MyAEvent(Object source,String eventName) {
        super(source);
        this.eventName = eventName;
    }

    public String getEventName(){
        return eventName;
    }

    public abstract void executeEvent();

}
