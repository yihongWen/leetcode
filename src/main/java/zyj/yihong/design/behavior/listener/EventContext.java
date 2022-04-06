package zyj.yihong.design.behavior.listener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class EventContext {
    private List<EventListener> listenerList = new ArrayList<>();
    public void addListener(EventListener eventListener){
        listenerList.add(eventListener);
    }

    public void removeListener(EventListener eventListener){
        listenerList.removeIf(eventListener::equals);
    }

    public List<EventListener> getListenerList(){
        return listenerList;
    }
}
