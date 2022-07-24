package zyj.yihong.leetcode.random_select;

/**
 * 415. 字符串相加
 */
public class AddStrings_S_415 {
    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();

        int add = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        while (add!=0||i>=0||j>=0) {
            char n1 = i>=0?num1.charAt(i):'0';
            char n2 = j>=0?num2.charAt(j):'0';
            int curSum = n1-'0'+n2-'0'+add;
            int i1 = curSum % 10;
            stringBuilder.append(i1);
            add = curSum/10;
            i--;
            j--;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        AddStrings_S_415 addStrings_s_415 = new AddStrings_S_415();
        String s = addStrings_s_415.addStrings("9", "99");
        System.out.println(s);
    }
}
