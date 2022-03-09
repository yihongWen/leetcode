package zyj.yihong.leetcode.mid.stack;

/**
 * 402. 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 */
public class RemoveKdigits402 {
    public static String removeKdigits(String num, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int retIndex = 0;
        int curI = 0;
        int k1 = k;

        for (; curI < num.length() && k1>0; curI++) {
            char curNum = num.charAt(curI);
            while (retIndex>0 && curNum<stringBuilder.charAt(retIndex-1) && k1>0){
                retIndex--;
                k1--;
            }

            if (stringBuilder.length()<=retIndex) {
                stringBuilder.append(curNum);
            }else {
                stringBuilder.setCharAt(retIndex, curNum);
                stringBuilder = new StringBuilder(stringBuilder.substring(0,retIndex+1));
            }
            retIndex++;
        }
        if (curI<=num.length()-1){
            stringBuilder.append(num.substring(curI));
        }

        if (k1>0){
            stringBuilder = new StringBuilder(stringBuilder.substring(0,stringBuilder.length()-k1));
        }

        if (stringBuilder.toString().equals("")){
            return "0";
        }

        int indexZero = stringBuilder.length()-1;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i)!='0'){
                indexZero = i;
                break;
            }
        }
        String substring = stringBuilder.substring(indexZero, num.length() - k);
        return substring.equals("") ?"0":substring;
    }

    public static void main(String[] args) {
        String num = "10200";
        int k = 1;

        String num1 = "1234567890";
        int k1 = 10;
        String s = removeKdigits(num1, k1);
        System.out.println(s);
    }
}
