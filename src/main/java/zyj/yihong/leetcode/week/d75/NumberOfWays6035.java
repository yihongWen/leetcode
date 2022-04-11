package zyj.yihong.leetcode.week.d75;

/**
 * 6035. 选择建筑的方案数
 */
public class NumberOfWays6035 {
    public long numberOfWays(String s) {
        // 问题转化寻找字串的个数 010  101
        return findSubCount(s, "101") + findSubCount(s, "010");
    }

    private long findSubCount(String s,String sub){
        long first = 0,second = 0,third = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c==sub.charAt(2)){
                third+=second;
            }
            if (c==sub.charAt(1)){
                second+=first;
            }else {
                first++;
            }
        }

        return third;
    }
}
