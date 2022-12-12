package zyj.yihong.leetcode.random_select.dec;

import java.util.Arrays;

// 1781. 所有子字符串美丽值之和
public class BeautySum_M_1781 {
    public static int beautySum(String s) {
        int ans = 0;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(arr, 0);
            System.arraycopy(freq, 0, arr, 0, freq.length);
            for (int j = s.length() - 1; j >= i; j--) {
                int max = 0;
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    max = Math.max(max, arr[k]);
                    min = arr[k] != 0 ? Math.min(min, arr[k]) : min;
                }
                if (max != 0 && min != Integer.MAX_VALUE) {
                    ans += max - min;
                }
                arr[s.charAt(j)-'a']--;
            }
            freq[s.charAt(i) - 'a']--;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        int num = beautySum(s);
        System.out.println(num);
    }
}
