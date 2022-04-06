package zyj.yihong.design.behavior.listener;

import java.util.EventListener;
import java.util.EventObject;

public class ComeBackHomeListener implements EventListener {
    public void execute(MyAEvent event){
        System.out.println("事件:"+event.getEventName()+"发生了..");
        System.out.println("执行相关应对措施....");
    }
}
