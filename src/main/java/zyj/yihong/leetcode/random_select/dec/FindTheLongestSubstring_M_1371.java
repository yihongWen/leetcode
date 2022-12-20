package zyj.yihong.leetcode.random_select.dec;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1371. 每个元音包含偶数次的最长子字符串
public class FindTheLongestSubstring_M_1371 {
    // 直接暴力
    public static int findTheLongestSubstring(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);

        for (int i = 0; i < s.length(); i++) {
            int status = 0;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    status = status ^ (1 << map.get(c));
                }
                if (status == 0) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }


    // 暴力加前缀和优化
    public static int findTheLongestSubstring2(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        int[] preSum = new int[s.length() + 1];
        int status = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                status = status ^ (1 << map.get(c));
            }
            preSum[i + 1] = status;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int curStatus = preSum[j + 1] ^ preSum[i];
                if (curStatus == 0) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }


    public static int findTheLongestSubstring3(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        int status = 0;
        int[] position = new int[1 << 5];
        Arrays.fill(position, -1);
        position[0] = 0;

        // 遍历到当前字符串时，记录当前的状态
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                status = status ^ (1 << map.get(c));
            }

            if (position[status] == -1) {
                position[status] = i + 1;
            } else {
                ans = Math.max(ans,i+1-position[status]);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        int theLongestSubstring = findTheLongestSubstring2(s);
        System.out.println(theLongestSubstring);

    }
}
