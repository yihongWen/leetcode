package zyj.yihong.leetcode.simple.arr;

import java.util.Arrays;

/**
 * 821. 字符的最短距离
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 *
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 *
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestToChar821 {
    public static int[] shortestToChar(String s, char c) {
        // 两次遍历
        int[] ans = new int[s.length()];
        int curIndex = Integer.MIN_VALUE+s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==c){
                curIndex = i;
            }
            ans[i] = i-curIndex;
        }

        curIndex = Integer.MAX_VALUE;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)==c){
                curIndex = i;
            }

            ans[i] = Math.min(ans[i],curIndex-i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = shortestToChar("loveleetcode", 'e');
        System.out.println(Arrays.toString(ints));
    }


}
