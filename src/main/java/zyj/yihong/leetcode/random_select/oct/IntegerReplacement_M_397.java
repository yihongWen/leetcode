package zyj.yihong.leetcode.random_select.oct;

import java.util.HashMap;
import java.util.Map;

// 397. 整数替换
public class IntegerReplacement_M_397 {
    public static int integerReplacement(int n) {
        if (n==1){
            return 0;
        }

        if (n%2==0){
            return 1+integerReplacement(n/2);
        }

        return 2+Math.min(integerReplacement(n/2),integerReplacement(n/2+1));
    }

    public static void main(String[] args) {

        int i = integerReplacement(1000);
        System.out.println(i);
    }
}
