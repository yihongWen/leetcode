package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 667. 优美的排列 II
public class ConstructArray_M_667 {
    public static int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int splitIndex = n - k;
        for (int i = 0; i < splitIndex; i++) {
            ans[i] = i + 1;
        }

        int tail = n;
        int head = splitIndex+1;
        for (int i = splitIndex; i < n;) {
            ans[i]=tail;
            i++;
            if (i<n) {
                ans[i] = head;
            }
            i++;
            tail--;
            head++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = constructArray(7, 4);
        System.out.println(Arrays.toString(ints));
    }
}
