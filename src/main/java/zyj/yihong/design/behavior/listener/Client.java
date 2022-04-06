package zyj.yihong.design.behavior.listener;

import java.util.EventListener;

public class Client {
    public static void main(String[] args) {
        EventContext eventContext = new EventContext();
        MyAEvent go = new GoToSchoolEvent(eventContext, "去上学");
        MyAEvent comeBack = new ComeBackHomeEvent(eventContext,"放学");

        EventListener goListener = new GoToSchoolListener();
        EventListener comeBackHome = new ComeBackHomeListener();
        eventContext.addListener(goListener);
        eventContext.addListener(comeBackHome);

        go.executeEvent();
        comeBack.executeEvent();


    }
}
