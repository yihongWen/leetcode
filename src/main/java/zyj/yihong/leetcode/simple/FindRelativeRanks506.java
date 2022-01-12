package zyj.yihong.leetcode.simple;

import java.util.Arrays;
import java.util.Collections;

/**
 * 每个评分都不同
 * 相对名次: 给定数组为得分，根据得分输出获奖信息
 */
public class FindRelativeRanks506 {

    /**
     * 此处使用两个遍历、可以使用map结构减少将一次n,减少到O(1)
     * @param score
     * @return
     */
    public static String[] findRelativeRanks(int[] score){
        int[] sortArrays = Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();
        String[] retRankArray = new String[score.length];
        for (int i = 0; i < sortArrays.length; i++) {
            for (int j = 0; j < score.length; j++) {
                if (sortArrays[i]==score[j]){
                    if (i==0){
                        retRankArray[j] = "Gold Medal";
                    }else if (i==1){
                        retRankArray[j] = "Silver Medal";
                    }else if (i==2){
                        retRankArray[j] = "Bronze Medal";
                    }else {
                        retRankArray[j] = ""+(i+1);
                    }
                }
            }
        }
        return retRankArray;
    }

    public static void main(String[] args) {
        int[] scoreArray = {1,2,3,4,5};
        String[] relativeRanks = findRelativeRanks(scoreArray);
        System.out.println(Arrays.toString(relativeRanks));
    }
}
