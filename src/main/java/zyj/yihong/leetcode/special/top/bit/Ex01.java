package zyj.yihong.leetcode.special.top.bit;

public class Ex01 {
    public static void main(String[] args) {
        int a = 5;
        int b = 11;

        // 补码的性质
        System.out.println(-a==(~a+1));

        // 异或实现交换：利用异或的性质
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a);
        System.out.println(b);


        // 位移操作：右边移动区分：符号有移、逻辑有移
        a = -5;
        System.out.println(a>>1);
        System.out.println(a>>>1);
        System.out.println(a<<1);


    }
}
