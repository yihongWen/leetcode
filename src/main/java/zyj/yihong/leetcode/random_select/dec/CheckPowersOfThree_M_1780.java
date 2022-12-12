package zyj.yihong.leetcode.random_select.dec;

// 1780. 判断一个数字是否可以表示成三的幂的和
public class CheckPowersOfThree_M_1780 {
    public static boolean checkPowersOfThree(int n) {
        String s = Integer.toString(n,3);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='2'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = checkPowersOfThree(6);
        System.out.println(b);
    }
}
