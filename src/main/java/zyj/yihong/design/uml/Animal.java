package zyj.yihong.design.uml;

import lombok.Data;

/**
 * @author yihong
 */
@Data
public class Animal {
    /**
     * 动物生命
     */
    private boolean live = true;

    /**
     * 新陈代谢
     * @param oxygen 氧气
     * @param water 水分
     */
    public void metabolism(Oxygen oxygen, Water water){

    }

    /**
     * 繁殖
     * @return animal
     */
    public Animal reproduce(){
        return new Animal();
    }
}
