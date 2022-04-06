package zyj.yihong.design.behavior.listener;

import java.util.EventListener;

public class GoToSchoolListener implements EventListener {
    public void execute(MyAEvent event){
        System.out.println("事件:"+event.getEventName()+"发生了..");
        System.out.println("执行相关应对措施....");
    }
}
