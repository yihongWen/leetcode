package zyj.yihong.leetcode.random_select.dec;

public class BrokenCalc_M_991 {
    public static int brokenCalc(int startValue, int target) {
        // 贪心
        // 正向操作
        if (startValue >= target) {
            return target - startValue;
        }

        //  乘2操作
        int c1 = 0;
        while (startValue < target) {
            startValue = startValue * 2;
            c1++;
        }

        // 减少操作
        int c2 = 0;
        int diff = startValue - target;
        for (int i = c1; i >=0 ; i--) {
            int num = 1 << i;
            int add = diff / num;
            diff = diff % num;
            c2+=add;
        }
        return c1+c2;
    }

    public static void main(String[] args) {
        int calc = brokenCalc(2, 38);
        System.out.println(calc);
    }
}
