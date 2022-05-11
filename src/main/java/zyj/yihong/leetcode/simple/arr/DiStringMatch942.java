package zyj.yihong.leetcode.simple.arr;

import java.util.Arrays;

public class DiStringMatch942 {
    /**
     * 942. 增减字符串匹配
     * @param s
     * @return
     */
    public static int[] diStringMatch(String s) {
        int dIndex = s.length();
        int[] ans = new int[s.length()+1];
        int iIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='I'){
                ans[i] = iIndex;
                iIndex++;
            }else {
                ans[i] = dIndex;
                dIndex--;
            }
        }

        ans[s.length()] = iIndex;

        return ans;
    }

    public static void main(String[] args) {
        int[] idids = diStringMatch("IDID");
        System.out.println(Arrays.toString(idids));
    }
}
