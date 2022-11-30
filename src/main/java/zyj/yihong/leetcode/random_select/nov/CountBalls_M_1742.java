package zyj.yihong.leetcode.random_select.nov;

// 1742. 盒子中小球的最大数量
public class CountBalls_M_1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] countArr = new int[46];
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int num = i;
            int curAns = 0;
            while (num != 0) {
                curAns += num % 10;
                num = num / 10;
            }
            countArr[curAns]++;
            max = Math.max(max, countArr[curAns]);
        }
        return max;
    }
}
