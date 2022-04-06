package zyj.yihong.design.behavior.listener;


import java.util.EventListener;
import java.util.List;

public class ComeBackHomeEvent extends MyAEvent {
    public ComeBackHomeEvent(Object source,String eventName) {
        super(source,eventName);
    }

    @Override
    public void executeEvent() {
        EventContext eventContext = (EventContext) super.source;
        List<EventListener> listenerList = eventContext.getListenerList();
        for (EventListener eventListener : listenerList) {
            if (eventListener instanceof ComeBackHomeListener){
                ((ComeBackHomeListener) eventListener).execute(this);
            }
        }
    }

}
