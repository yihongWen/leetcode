package zyj.yihong.leetcode.random_select.oct;

// 1790. 仅执行一次字符串交换能否使两个字符串相等
public class AreAlmostEqual_S_1790 {
    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int count = 0;
        int[] indexArr = new int[2];
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                if (count >= 2) {
                    return false;
                }
                indexArr[count] = i;
                count++;
            }
        }
        if (count == 1) {
            return false;
        }

        if (count==0){
            return true;
        }

        return s1.charAt(indexArr[0]) == s2.charAt(indexArr[1]) && s1.charAt(indexArr[1]) == s2.charAt(indexArr[0]);
    }

    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "bank";
        boolean b = areAlmostEqual(s1, s2);
        System.out.println(b);
    }
}
