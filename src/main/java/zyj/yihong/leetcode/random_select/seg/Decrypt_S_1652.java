package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;

// 1652. 拆炸弹
public class Decrypt_S_1652 {
    public static int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
        }

        int[] ans = new int[code.length];
        int[] preSum = new int[code.length];
        preSum[0] = code[0];
        for (int i = 1; i < code.length; i++) {
            preSum[i] += preSum[i - 1] + code[i];
        }

        for (int i = 0; i < code.length; i++) {
            int start;
            int end;
            if (k > 0) {
                start = (i) % code.length;
                end = (i + k) % code.length;
            } else {
                end = (i - 1 + code.length) % code.length;
                start = (i + k-1 + code.length) % code.length;
            }
            if (start > end) {
                ans[i] = preSum[code.length - 1] - preSum[start] + preSum[end];
            } else {
                ans[i] = preSum[end] - preSum[start];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 9, 3};
        int k = -2;
        int[] decrypt = decrypt(arr, k);
        System.out.println(Arrays.toString(decrypt));

    }
}
//[12,10,16,13]