package zyj.yihong.leetcode.mid.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 *
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 */
public class LexicalOrder386 {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int cur = 1;
        // 1、先加0 然后从1-9 往上一层+1
        for (int i = 0; i < n; i++) {
            ans.add(cur);
            if (cur*10<=n){
                cur = cur*10;
            }else {
                while (cur%10==9 || cur>=n){
                    cur = cur/10;
                }
                cur++;
            }
        }
        return ans;
    }
}
