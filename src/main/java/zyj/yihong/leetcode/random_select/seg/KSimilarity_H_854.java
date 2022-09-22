package zyj.yihong.leetcode.random_select.seg;


import java.util.*;

// 854. 相似度为 K 的字符串
public class KSimilarity_H_854 {
    public int kSimilarity(String s1, String s2){
        if (Objects.equals(s1,s2)){
            return 0;
        }

        // 保存起始状态到当前状态需要的cost
        Map<String,Integer> stateCostMap = new HashMap<>();

        // 基于优先队列的A-Start算法、优先队列也就是代价函数（start->mid->end）
        Queue<String> priorityQueue = new PriorityQueue<>((state1,state2)->{
            int cost1 = stateCostMap.get(state1) + costFunction(state1, s2);
            int cost2 = stateCostMap.get(state2) + costFunction(state2, s2);

            // 代价越小排在越前
            return cost1-cost2;
        });

        priorityQueue.offer(s1);
        stateCostMap.put(s1,0);

        while (priorityQueue.size()!=0){
            String curState = priorityQueue.poll();
            Integer step = stateCostMap.get(curState);
            char[] curStateCharArr = curState.toCharArray();

            // 找到第一个不想等的坐标
            int index = 0;
            for (int i = 0; i < curStateCharArr.length; i++) {
                if (curStateCharArr[i]!=s2.charAt(i)){
                    index = i;
                    break;
                }
            }

            // 某一次交换可以使当前index所处的位置变成相等
            for (int i = index+1; i < curStateCharArr.length; i++) {

                // 不满足交换的条件
                if (s2.charAt(index)!=curStateCharArr[i] || curStateCharArr[i]==s2.charAt(i)){
                    continue;
                }

                // 交换
                char temp = curStateCharArr[index];
                curStateCharArr[index] = curStateCharArr[i];
                curStateCharArr[i] = temp;

                String nextState = String.valueOf(curStateCharArr);

                // 换回来，下一次处理
                temp = curStateCharArr[index];
                curStateCharArr[index] = curStateCharArr[i];
                curStateCharArr[i] = temp;

                if (stateCostMap.containsKey(nextState)){
                    if (stateCostMap.get(nextState)<=step+1){
                        continue;
                    }
                }

                // 判断当前是否是目标状态
                if (Objects.equals(nextState,s2)){
                    return step+1;
                }

                stateCostMap.put(nextState,step+1);
                priorityQueue.add(nextState);
            }
        }
        return -1;
    }

    private int costFunction(String s1,String s2){
        // 从s1转换到s2需要的次数也就是代价
        int cost = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)!=s2.charAt(i)){
                cost++;
            }
        }

        return cost+1>>1;
    }

}
