package zyj.yihong.lang.demo;

import java.util.ArrayList;
import java.util.List;

public class FoodPool {
    private List<String> allFood = new ArrayList<>(1);

    public List<String> getAllFood() {
        return allFood;
    }

    public void setAllFood(List<String> allFood) {
        this.allFood = allFood;
    }

    public FoodPool(List<String> allFood) {
        this.allFood = allFood;
    }
}
