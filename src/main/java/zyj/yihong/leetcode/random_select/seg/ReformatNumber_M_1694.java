package zyj.yihong.leetcode.random_select.seg;

// 1694. 重新格式化电话号码
public class ReformatNumber_M_1694 {
    public static String reformatNumber(String number) {
        char[] numberCharArr = number.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberCharArr.length; i++) {
            if (numberCharArr[i] != ' ' && numberCharArr[i] != '-') {
                stringBuilder.append(numberCharArr[i]);
            }
        }

        int length = stringBuilder.length();
        if (length <= 3) {
            return stringBuilder.toString();
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (i != 0 && i % 3 == 0) {
                ans.append("-");
            }
            ans.append(stringBuilder.charAt(i));
        }


        if (length % 3 == 1) {
            ans.setCharAt(ans.length()-2,ans.charAt(ans.length()-3));
            ans.setCharAt(ans.length()-3,'-');
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "9964-";
        String s1 = reformatNumber(s);
        System.out.println(s1);
    }
}
