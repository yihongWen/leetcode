package zyj.yihong.design.uml;

import java.util.ArrayList;
import java.util.List;

/**
 * 鸟类
 * @author yihong
 */
public class Bird extends Animal {
    private boolean feather = true;

    private final List<Wing> wings = new ArrayList<>();


    /**
     * 下蛋
     */
    public void getEgg(){

    }
}