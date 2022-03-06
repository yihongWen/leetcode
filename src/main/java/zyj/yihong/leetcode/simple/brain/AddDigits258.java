package zyj.yihong.leetcode.simple.brain;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 */
public class AddDigits258 {

    /**
     * 循环将各个位数相加
     *
     * @param num
     * @return
     */
    public static int addDigits(int num) {
        int ret = num;
        while (num>9) {
            ret = 0;
            while (num > 0) {
                ret += num % 10;
                num = num / 10;
            }
            num = ret;
        }
        return ret;
    }

    /**
     * 数学推导
     * @param num
     * @return
     */
    public static int addDigits2(int num) {
        return num%9==0?9:num%9;
    }

    public static void main(String[] args) {
        int i = addDigits(38);
        System.out.println(i);
    }
}
