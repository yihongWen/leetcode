package zyj.yihong.leetcode.mid.brain;

/**
 * 172. 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 */
public class TrailingZeroes172 {
    public static int trailingZeroes(int n) {
        int count = 0;
        int deviceNum = 5;
        int curCount = n/(deviceNum);
        while (curCount>0){
            count += curCount;
            deviceNum=deviceNum*5;
            curCount = n/deviceNum;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = trailingZeroes(200);
        System.out.println(i);
    }
}
