package zyj.yihong.leetcode.random_select.dec;

public class GetLucky_S_1945 {
    public static int getLucky(String s, int k) {
        int num = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i)-'a'+1);
        }
        s = stringBuilder.toString();
        for (int i = 0; i < k; i++) {
            num = 0;
            for (int j = 0; j < s.length(); j++) {
                num =num + s.charAt(j)-'0';
            }
            s = Integer.toString(num);
        }

        return num;
    }

    public static void main(String[] args) {
        int num = getLucky("leetcode", 2);
        System.out.println(num);
    }
}
