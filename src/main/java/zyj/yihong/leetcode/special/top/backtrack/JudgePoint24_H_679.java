package zyj.yihong.leetcode.special.top.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 679. 24 点游戏
 * 回溯：除法精度的问题
 *
 * 优化点：乘法跟加法满足交换律（两个数前后无所谓，可以减少一次dfs）
 */
public class JudgePoint24_H_679 {
    public boolean judgePoint24(int[] cards) {
        List<Double> cardList = Arrays.asList((double)cards[0], (double)cards[1], (double)cards[2], (double)cards[3]);
        return backtrack(cardList);
    }

    private boolean backtrack(List<Double> curCardList){
        // 结束条件，当前列表中的card==1，并且为24点时（容忍精度丢失范围）1e-6;
        if (curCardList.size()==1 && Math.abs(curCardList.get(0)-24)<1e-6){
            return true;
        }

        // 从当前列表中以排列的方式选择出两个card
        for (int selectFirstCard = 0; selectFirstCard < curCardList.size(); selectFirstCard++) {
            for (int selectSecondCard = 0; selectSecondCard < curCardList.size(); selectSecondCard++) {
                if (selectFirstCard==selectSecondCard){
                    continue;
                }

                // 对于没有选中的值直接加入到新的List中
                List<Double> nextStateCardList = new ArrayList<>();
                for (int i = 0; i < curCardList.size(); i++) {
                    if (i!=selectFirstCard && i!=selectSecondCard){
                        nextStateCardList.add(curCardList.get(i));
                    }
                }

                // 对选出的两个card进行加减乘除的计算
                double calValue=1;
                for (int i = 0; i < 4; i++) {
                    // 加法
                    if (i==0){
                        calValue = curCardList.get(selectFirstCard)+curCardList.get(selectSecondCard);
                    }

                    if (i==1){
                        calValue = curCardList.get(selectFirstCard)-curCardList.get(selectSecondCard);
                    }

                    if (i==2){
                        calValue = curCardList.get(selectFirstCard)*curCardList.get(selectSecondCard);
                    }

                    // 除法精度问题考虑，如果除数趋近0，则视为无效
                    if (i==3){
                        if (Math.abs(curCardList.get(selectSecondCard))<=1e-6){
                            continue;
                        }
                        calValue = curCardList.get(selectFirstCard)/curCardList.get(selectSecondCard);
                    }
                    nextStateCardList.add(calValue);
                    if (backtrack(nextStateCardList)){
                        return true;
                    }
                    nextStateCardList.remove(nextStateCardList.size()-1);
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,8,7};
        JudgePoint24_H_679 judgePoint24_h_679 = new JudgePoint24_H_679();
        boolean b = judgePoint24_h_679.judgePoint24(arr);
        System.out.println(b);
    }
}
