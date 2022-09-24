package zyj.yihong.leetcode.random_select.seg;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

// 539. 最小时间差
public class FindMinDifference_M_539 {
    public static int findMinDifference(List<String> timePoints) {
        if (timePoints.size()>1440){
            return 0;
        }
        // 排序
        timePoints.sort((s1, s2) -> {
            for (int i = 0; i < s1.length(); i++) {
                if (i == 2) {
                    continue;
                }
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);

                if ((c1 - c2) != 0) {
                    return c1 - c2;
                }
            }
            return 0;
        });

        int ans = 12 * 60;
        for (int i = 0; i < timePoints.size(); i++) {
            String s1 = timePoints.get(i);
            String s2 = timePoints.get((i + 1) % timePoints.size());
            String[] split1 = s1.split(":");
            String[] split2 = s2.split(":");
            int i2 = Integer.parseInt(split2[0]);
            int i1 = Integer.parseInt(split1[0]);
            int curAns = (i2 - i1) * 60;

            int i22 = Integer.parseInt(split2[1]);
            int i12 = Integer.parseInt(split1[1]);
            curAns += i22 - i12;
            curAns = Math.abs(curAns);
            if (curAns>720){
                curAns = 1440-curAns;
            }
            ans = Math.min(ans, curAns);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> times = Arrays.asList("23:59", "00:00");
        int minDifference = findMinDifference(times);
        System.out.println(minDifference);

    }
}
