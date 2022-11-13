package zyj.yihong.leetcode.random_select.nov;

import java.util.*;
import java.util.stream.Collectors;

// 638. 大礼包
public class ShoppingOffers_638 {
    private List<Integer> price;
    private List<List<Integer>> special;
    private List<Integer> needs;
    private Map<List<Integer>,Integer> map = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price = price;
        // 排除并不能真正优化的大礼包

        this.special = special.stream().filter(curSpecial -> {
            int difGoodCount = 0;
            int money = 0;
            for (int i = 0; i < price.size(); i++) {
                Integer goodNum = curSpecial.get(i);
                if (goodNum != 0) {
                    difGoodCount++;
                    money += price.get(i) * goodNum;
                }
            }

            if (difGoodCount != 0 && money > curSpecial.get(price.size())) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        return dfs(needs);


    }

    private int dfs(List<Integer> curNeeds){
        if (map.containsKey(curNeeds)){
            return map.get(curNeeds);
        }
        // 计算当前产品如果全部使用原价
        int minPrice = 0;
        for (int i = 0; i < price.size(); i++) {
            minPrice+=price.get(i)*curNeeds.get(i);
        }

        // 遍历每个可用大礼包，判断当前的needs是否可用
        for (int i = 0; i < special.size(); i++) {
            List<Integer> curSpecial = special.get(i);
            List<Integer> nextNeeds = new ArrayList<>();
            boolean flag = true;
            for (int j = 0; j < price.size(); j++) {
                if (curNeeds.get(j)>=curSpecial.get(j)){
                    nextNeeds.add(curNeeds.get(j)-curSpecial.get(j));
                }else {
                    flag = false;
                }
            }

            if (!flag){
                continue;
            }

            // 计算使用当前大礼包之后需要原价购买的物品
            minPrice =  Math.min(dfs(nextNeeds)+curSpecial.get(price.size()),minPrice);
        }
        map.put(curNeeds,minPrice);
        return map.get(curNeeds);
    }

    public static void main(String[] args) {
        ShoppingOffers_638 shoppingOffers_638 = new ShoppingOffers_638();
        List<Integer> price = Arrays.asList(2,5);
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> special1 = Arrays.asList(3,0,5);
        List<Integer> special2 = Arrays.asList(1,2,10);
        special.add(special1);
        special.add(special2);
        List<Integer> needs = Arrays.asList(3,2);
        int i = shoppingOffers_638.shoppingOffers(price, special, needs);
        System.out.println(i);


    }
}
