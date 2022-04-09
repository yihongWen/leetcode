package zyj.yihong.leetcode.mid.divide_and_conquer;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 */
public class MyPow50 {
    public static double myPow(double x, int n) {
        // 使用分治的思想：迭代版本
        // 当n为负数最小值时需要特殊处理
        long longN = n;
        boolean neg = false;
        if (longN<0){
            neg = true;
            longN = -longN;
        }
        double ans = 1;
        double curNum = x;
        while (longN>0){
            if (longN%2==1){
                ans*=curNum;
            }
            curNum*=curNum;
            longN=longN/2;
        }
        return neg?1/ans:ans;
    }

    public static void main(String[] args) {
        double v = myPow(2.00000, -2147483648);
        System.out.println(v);
    }
}
