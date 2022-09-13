package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 670. 最大交换
public class MaximumSwap_M_670 {
    public static int maximumSwap(int num) {
        char[] numChar = String.valueOf(num).toCharArray();
        int swapMaxIndex = -1 ;
        int swapMinIndex = -1;
        int curMaxIndex = numChar.length-1;


        for (int i = numChar.length-2; i >=0 ; i--) {
            if (numChar[curMaxIndex]<numChar[i]){
                curMaxIndex = i;
            }else if (numChar[curMaxIndex]>numChar[i]){
                swapMaxIndex = curMaxIndex;
                swapMinIndex = i;
            }
        }

        if (swapMinIndex==-1){
            return num;
        }

        // 交换
        char c = numChar[swapMaxIndex];
        numChar[swapMaxIndex] = numChar[swapMinIndex];
        numChar[swapMinIndex] = c;

        return Integer.parseInt(String.valueOf(numChar));

    }

    public static void main(String[] args) {
        int num = 98368;
        int ans = maximumSwap(num);
        System.out.println(ans);
    }
}
