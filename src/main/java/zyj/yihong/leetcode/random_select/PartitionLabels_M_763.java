package zyj.yihong.leetcode.random_select;

import java.util.ArrayList;
import java.util.List;

// 763. 划分字母区间
public class PartitionLabels_M_763 {
    public List<Integer> partitionLabels(String s) {
        // 贪心，记录每个字符在s中的最后一个位置
        int[] alphabetIndexArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabetIndexArr[s.charAt(i)-'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();

        //每个segment 为当前段出现的一个值最后的区间范围的字母 中的最后一个index
        int curEnd = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            int curAlphabetMax = alphabetIndexArr[s.charAt(i) - 'a'];
            curEnd = Math.max(curAlphabetMax,curEnd);
            // 到达结束的段
            if (curEnd==i){
                ans.add(curEnd-start);
                start = i;
            }
        }
        return ans;
    }
}
