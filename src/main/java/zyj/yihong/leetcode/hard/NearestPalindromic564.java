package zyj.yihong.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class NearestPalindromic564 {
    public static String nearestPalindromic(String n) {
        // 构造候选边界值
        List<Long> selectList = new ArrayList<Long>(5);
        selectList.add((long) Math.pow(10, n.length() - 1) - 1);
        selectList.add((long) Math.pow(10, n.length()) + 1);

        int midIndex = (n.length() + 1) / 2;
        String prefix = n.substring(0, midIndex);
        long prefixLong = Long.parseLong(prefix);

        for (long i = prefixLong - 1; i <= prefixLong + 1; i++) {
            StringBuilder curResult = new StringBuilder();
            StringBuilder reverseSb = new StringBuilder();
            String curPrefix = String.valueOf(i);
            curResult.append(curPrefix);
            // 反转
            reverseSb.append(curPrefix).reverse();
            // 判断拼接的位数，如果是偶数，从头开始，如果是基数从第二位开始
            curResult.append(reverseSb.substring(n.length() & 1));
            selectList.add(Long.parseLong(curResult.toString()));
        }

        // 选择最佳的回文数
        long optValue = selectList.get(0);
        long longN = Long.parseLong(n);
        for (int i = 1; i < selectList.size(); i++) {
            if (selectList.get(i) == longN) {
                continue;
            }
            long compare = Math.abs(longN - optValue) - Math.abs(longN - selectList.get(i));
            if (compare > 0) {
                optValue = selectList.get(i);
            } else if (compare == 0) {
                optValue = optValue > selectList.get(i) ? selectList.get(i) : optValue;
            }
        }
        return String.valueOf(optValue);
    }
}
