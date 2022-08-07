package zyj.yihong.leetcode.random_select;

import java.util.Arrays;

public class OrderlyQueue_H_899 {
    public String orderlyQueue(String s, int k) {
        // 分类讨论当k==1的情况

        if (k==1) {
            String minS = s;
            StringBuilder stringBuilder = new StringBuilder(s);
            for (int i = 0; i < s.length()-1; i++) {
                stringBuilder.append(stringBuilder.charAt(0)).deleteCharAt(0);
                if (minS.compareTo(stringBuilder.toString())>0){
                    minS = stringBuilder.toString();
                }
            }

            return minS;
        }

        // k>1时可以用归纳法进行推导
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);

    }

    public static void main(String[] args) {
        OrderlyQueue_H_899 orderlyQueue_h_899 = new OrderlyQueue_H_899();
        String xisxr = orderlyQueue_h_899.orderlyQueue("xisxr", 1);
        System.out.println(xisxr);
    }
}
