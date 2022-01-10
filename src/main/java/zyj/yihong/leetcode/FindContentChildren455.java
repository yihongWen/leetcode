package zyj.yihong.leetcode;

import java.util.Arrays;

/**
 * 饼干分发：
 * @author yihong
 */
public class FindContentChildren455 {

    /**
     *
     * @param g 胃口值
     * @param s 饼干size
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g==null || g.length==0 || s==null || s.length==0){
            return 0;
        }
        int optimalValue = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        while(i< g.length && j<s.length){
            if (s[j]>=g[i]){
                optimalValue++;
                i++;
            }
            j++;
        }
        return optimalValue;
    }
}
