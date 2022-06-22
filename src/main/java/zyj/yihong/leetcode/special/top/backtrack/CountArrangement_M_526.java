package zyj.yihong.leetcode.special.top.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 526. 优美的排列
 */
public class CountArrangement_M_526 {
    int ans = 0;
    List<Integer>[] optSpace;
    boolean[] flagArr;
    
    public int countArrangement(int n) {
        // 初始化数据结构,对了是index对齐，多开辟一个空间
        flagArr = new boolean[n+1];
        optSpace =  new List[n+1];
        for (int i = 0; i <= n; i++) {
            optSpace[i] = new ArrayList<>();
        }

        // 初始化optSpace数据
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (i%j==0||j%i==0){
                    optSpace[i].add(j);
                }
            }
        }

        // 回溯
        backtrack(1,n);

        return ans;
    }

    private void backtrack(int index, int n){
        // 结束条件
        if (index>n){
            ans++;
            return;
        }

        for (int i = 1; i <= n ; i++) {
            if (index%i==0||i%index==0){
                if (!flagArr[i]){
                    flagArr[i] = true;
                    backtrack(index+1,n);
                    flagArr[i] = false;
                }
            }
        }

    }

    private void backtrackOpt(int index, int n){
        // 结束条件
        if (index>n){
            ans++;
            return;
        }

        List<Integer> cur = optSpace[index];
        for (Integer selectIndex : cur) {
            if (!flagArr[selectIndex]){
                flagArr[selectIndex] = true;
                backtrackOpt(index+1,n);
                flagArr[selectIndex] = false;
            }
        }
    }
}
