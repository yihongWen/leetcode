package zyj.yihong.leetcode.mid.brain;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 */
public class FractionToDecimal166 {
    public static String fractionToDecimal(int numerator, int denominator) {
        String ans = "";

        // 考虑除法可能会发生溢出的情况，转为long
        long numeratorLong = numerator;
        long denominatorLong = denominator;

        // 如果两个数是异号，那么结果为负数,使用异或
        if ((numeratorLong < 0 ^ denominatorLong < 0)&&numeratorLong!=0) {
            ans += "-";
            numeratorLong = Math.abs(numeratorLong);
            denominatorLong = Math.abs(denominatorLong);
        }

        // 如果可以整除
        ans+=numeratorLong/denominatorLong;
        if (numeratorLong%denominatorLong==0){
            return ans;
        }

        // 不能直接整除，计算小数部分
        ans+=".";
        String remainder = "";
        int index = 0;
        Map<Long,Integer> existRemainderMap = new HashMap<>();
        long curRemainder = numeratorLong % denominatorLong;
        while (curRemainder!=0&&!existRemainderMap.containsKey(curRemainder)){
            existRemainderMap.put(curRemainder,index);
            curRemainder = curRemainder * 10;
            long curValue = curRemainder / denominatorLong;
            curRemainder = curRemainder%denominatorLong;
            remainder+=curValue;
            index++;
        }

        // 结束
        if (curRemainder!=0) {
            Integer handlerIndex = existRemainderMap.get(curRemainder);
            String substring = remainder.substring(0, handlerIndex);
            String substring1 = remainder.substring(handlerIndex);
            substring += "(";
            substring1 += ")";
            remainder = substring + substring1;
        }

        return ans+remainder;
    }

    public static void main(String[] args) {
        String s = fractionToDecimal(0, -5);
        System.out.println(s);
    }
}
