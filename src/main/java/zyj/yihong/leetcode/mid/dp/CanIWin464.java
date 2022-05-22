package zyj.yihong.leetcode.mid.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 464. 我能赢吗
 */
public class CanIWin464 {

    // 记忆搜索、状态压缩
    private Map<Integer,Boolean> memory = new HashMap<>(32);
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        // 用等差数列求和，判断1-到maxChoosableInteger只和是否大于desiredTotal
        int allSum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if (allSum<desiredTotal){
            return false;
        }
        dfs(maxChoosableInteger,desiredTotal,0,0);
        return memory.get(0);
    }

    private boolean dfs(int maxChoosableInteger,int desiredTotal,int stateBit,int curSum){
        // 判断当前状态位是否已经处理过
        if (memory.containsKey(stateBit)){
            return memory.get(stateBit);
        }

        boolean flag = false;
        for (int i = 0; i < maxChoosableInteger; i++) {
            // 判断当前i位是否被使用
            boolean unuse = (stateBit>>i&1)==0;
            if (unuse){
                // 判断加上当前值，是否满足超过desiredTotal
                if (curSum+i+1>=desiredTotal){
                    flag =  true;
                    break;
                }

                // 否则下一位进行选择,下一位为false
                int nextStateBit = stateBit|(1<<i);
                if (!dfs(maxChoosableInteger,desiredTotal,nextStateBit,curSum+i+1)){
                    flag =  true;
                    break;
                }
            }
        }

        // 将当前状态的结果记录到memory中
        memory.put(stateBit,flag);
        return flag;
    }

    public static void main(String[] args) {
        CanIWin464 canIWin464 = new CanIWin464();
        boolean b = canIWin464.canIWin(10, 11);
        System.out.println(b);
    }
}
