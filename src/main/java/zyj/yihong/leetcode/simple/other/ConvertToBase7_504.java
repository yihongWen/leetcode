package zyj.yihong.leetcode.simple.other;

/**
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 */
public class ConvertToBase7_504 {

    public String convertToBase7(int num) {
        if (num==0){
            return "0";
        }

        // 判断正负号
        boolean ne = false;
        StringBuilder stringBuilder = new StringBuilder();
        if (num<0){
            ne = true;
            num = Math.abs(num);
        }

        while (num>0){
            stringBuilder.append(num % 7);
            num = num/7;
        }
        if (ne){
            stringBuilder.append("-");
        }

        return stringBuilder.reverse().toString();

    }
}
