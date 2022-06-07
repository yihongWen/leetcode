package zyj.yihong.leetcode.special.top.bit;

/**
 * 剑指 Offer II 002. 二进制加法
 */
public class AddBinary_S_m002 {

    // 如果太大会造成溢出（可以考虑python），主要是思想
    public static String addBinary(String a, String b) {
        //将二进制字符串转化成int
        long ia = Integer.parseInt(a,2);
        long ib = Integer.parseInt(b,2);

        while (ib!=0){
            long temp = ia;
            ia = ia^ib;
            ib = (temp&ib)<<1;
        }
        return Long.toBinaryString(ia + ib);
    }

    public static void main(String[] args) {
        String s = addBinary("110", "1001");
        System.out.println(s);
    }
}
