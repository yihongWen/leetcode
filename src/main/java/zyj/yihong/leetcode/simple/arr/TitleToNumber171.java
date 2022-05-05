package zyj.yihong.leetcode.simple.arr;

public class TitleToNumber171 {
    public static int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int culCount = columnTitle.charAt(i) - 'A'+1;
            ans = ans*26+culCount;
        }
        return ans;
    }

    public static void main(String[] args) {
        int zy = titleToNumber("ZY");
        System.out.println(zy);
    }
}
