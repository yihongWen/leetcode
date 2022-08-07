package zyj.yihong.leetcode.random_select;

public class GenerateTheString_S_1374 {
    public String generateTheString(int n) {
        if (n == 1) {
            return "a";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            stringBuilder.append("a");
        }
        if ((n & 1) == 0) {
            stringBuilder.append("a");
        } else {
            stringBuilder.append("b");
        }
        return stringBuilder.toString();
    }
}
