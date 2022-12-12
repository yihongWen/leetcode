package zyj.yihong.leetcode.random_select.dec;

// 1796. 字符串中第二大的数字
public class SecondHighest_S_1796 {
    public int secondHighest(String s) {
        int maxFirst = -1;
        int maxSecond = -1;

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (!(num >= 0 && num <= 9)) {
                continue;
            }

            if (num > maxFirst) {
                maxSecond = maxFirst;
                maxFirst = num;
            } else if (num > maxSecond && num < maxFirst) {
                maxSecond = num;
            }
        }
        return maxSecond;
    }
}
