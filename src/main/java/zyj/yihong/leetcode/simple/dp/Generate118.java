package zyj.yihong.leetcode.simple.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class Generate118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> preList = new ArrayList<>();
        preList.add(1);
        ans.add(preList);

        for (int i = 2; i <= numRows ; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            List<Integer> dp = ans.get(i-2);
            for (int j = 1; j < i-1; j++) {
                int curValue = dp.get(j - 1) + dp.get(j);
                cur.add(j,curValue);
            }
            cur.add(1);
            ans.add(cur);
        }

        return ans;
    }


    public static List<Integer> getRow(int rowIndex) {
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        for (int i = 2; i <= rowIndex+1 ; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < i-1; j++) {
                int curValue = dp.get(j - 1) + dp.get(j);
                cur.add(j,curValue);
            }
            cur.add(1);
            dp = cur;
        }

        return dp;
    }

    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        System.out.println(row);
    }
}
