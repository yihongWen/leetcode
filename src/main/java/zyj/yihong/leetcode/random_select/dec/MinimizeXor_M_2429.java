package zyj.yihong.leetcode.random_select.dec;


// 2429. 最小 XOR
public class MinimizeXor_M_2429 {
    public static int minimizeXor(int num1, int num2) {
        int c1 = Integer.bitCount(num1);
        int c2 = Integer.bitCount(num2);
        boolean flag = false;
        if (c2 < c1) {
            flag = true;
        }
        int abs = Math.abs(c1 - c2);
        int ans = num1;
        for (int i = 0; i < 32 && abs > 0; i++) {
            if (!flag) {
                if ((num1 & (1 << i)) == 0) {
                    ans += (1 << i);
                    abs--;
                }
            } else {
                if ((num1 & (1 << i)) != 0) {
                    ans -= (1 << i);
                    abs--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        25
//72
        System.out.println(Integer.toBinaryString(79));
        System.out.println(Integer.toBinaryString(74));

        int i = minimizeXor(79,74);
        System.out.println(i);
    }
}
