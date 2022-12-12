package zyj.yihong.leetcode.random_select.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1238. 循环码排列
public class CircularPermutation_M_1238 {
    public List<Integer> circularPermutation(int n, int start) {
        // 生成循环码
        List<Integer> ans = new ArrayList<>();
        if (n==1){
            ans.add(start);
            ans.add(start^1);
            return ans;
        }

        ans.add(0);
        ans.add(1);
        int startIndex = start==0?0:1;

        for (int i = 2; i <= n; i++) {
            int size = ans.size();
            int next = 1 << (i-1);
            for (int j = size-1; j >=0 ; j--) {
                int genValue = ans.get(j) + next;
                ans.add(genValue);
                if (genValue==start){
                    startIndex = ans.size()-1;
                }
            }
        }

        List<Integer> firstList = ans.subList(startIndex, ans.size());
        List<Integer> second = ans.subList(0, startIndex);
        ans = new ArrayList<>();
        ans.addAll(firstList);
        ans.addAll(ans.size(),second);
        return ans;
    }

    public static void main(String[] args) {
        CircularPermutation_M_1238 circularPermutation_m_1238 = new CircularPermutation_M_1238();
        List<Integer> integers = circularPermutation_m_1238.circularPermutation(3, 6);
        System.out.println(integers);
    }
}
