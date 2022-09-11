package zyj.yihong.leetcode.random_select.seg;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions_S_830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curAns = new ArrayList<>();
        curAns.add(0);
        char curChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c==curChar){
                if (i==s.length()-1&&i-curAns.get(0)+1>=3){
                    curAns.add(i);
                    ans.add(new ArrayList<>(curAns));
                }
                continue;
            }

            if (i-curAns.get(0)>=3) {
                curAns.add(i-1);
                ans.add(new ArrayList<>(curAns));
            }

            curAns.clear();
            curAns.add(i);
            curChar = c;
        }
        return ans;
    }
}
