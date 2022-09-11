package zyj.yihong.leetcode.random_select.seg;

// 844. 比较含退格的字符串
public class BackspaceCompare_S_844 {
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        while (i >= 0 || j >= 0) {
            int sNum = 0;

            // 计算出每一个需要比较的char
            while (i >= 0) {
                char c = s.charAt(i);
                if (c == '#') {
                    sNum++;
                    i--;
                } else if (sNum > 0) {
                    sNum--;
                    i--;
                } else {
                    break;
                }
            }


            int tNum = 0;
            while (j >= 0) {
                char c = t.charAt(j);
                if (c == '#') {
                    tNum++;
                    j--;
                } else if (tNum > 0) {
                    tNum--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }

            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bbbextm";
        String t = "bbb#extm";
        boolean b = backspaceCompare(s, t);
        System.out.println(b);

    }
}
