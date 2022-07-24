package zyj.yihong.leetcode.random_select;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 365. 水壶问题
 */
public class CanMeasureWater_M_365 {
    public static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // 使用数学的方式推导：ax+by=z

        // 边界条件处理
        if (jug1Capacity+jug2Capacity<targetCapacity){
            return false;
        }

        if (jug1Capacity==0||jug2Capacity==0){
            return targetCapacity==jug1Capacity||targetCapacity==jug2Capacity;
        }

        // 欧几里得 gcd(a,b) = gcd(b,a%b)
        int temp = jug1Capacity%jug2Capacity;
        while (temp!=0){
            jug1Capacity = jug2Capacity;
            jug2Capacity = temp;
            temp = jug1Capacity%jug2Capacity;
        }

        return targetCapacity%jug2Capacity==0;

    }


    // dfs 会超时
    public static boolean canMeasureWaterByDfs(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // 定义栈以及初始化状态
        Stack<List<Integer>> stack = new Stack<>();
        stack.add(Arrays.asList(0,0));

        Set<List<Integer>> existStateSet = new HashSet<>();

        while (!stack.isEmpty()){
            //判断当前状态是否存在set中
            List<Integer> peek = stack.peek();
            if (existStateSet.contains(peek)){
                stack.pop();
                continue;
            }

            // 判断当前状态是否满足
            if (peek.get(0)==targetCapacity||peek.get(1)==targetCapacity||peek.get(0)+peek.get(1)==targetCapacity){
                return true;
            }

            existStateSet.add(peek);
            List<Integer> pop = stack.pop();

            // 添加状态
            stack.add(Arrays.asList(jug1Capacity,pop.get(1)));
            stack.add(Arrays.asList(pop.get(0),jug2Capacity));
            stack.add(Arrays.asList(0,pop.get(1)));
            stack.add(Arrays.asList(pop.get(0),0));
            stack.add(Arrays.asList(pop.get(0)-Math.min(pop.get(0),jug2Capacity-pop.get(1)), pop.get(1)+Math.min(pop.get(0),jug2Capacity-pop.get(1))));
            stack.add(Arrays.asList(pop.get(0)+Math.min(pop.get(1),jug1Capacity-pop.get(0)), pop.get(1)-Math.min(pop.get(1),jug1Capacity-pop.get(0))));

        }
        return false;
    }

    public static void main(String[] args) {
//        104707
//104711
//1
        boolean b = CanMeasureWater_M_365.canMeasureWaterByDfs(104707, 104711, 1);
        System.out.println(b);

        b = CanMeasureWater_M_365.canMeasureWater(104707, 104711, 1);

        System.out.println(b);
    }



}
