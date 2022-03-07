package zyj.yihong.leetcode.simple.stack;

import java.util.Stack;

/**
 * 227. 基本计算器 II
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * "3+2*2"
 */
public class Calculate227 {
    public static int calculate(String s) {
        int retValue = 0;
        Stack<Integer> numStack = new Stack<>();
        char sign = '+';
        int curNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) ) {
                curNum = curNum * 10 + (s.charAt(i) - '0');
            }

            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i==s.length()-1) {
                if (sign == '+') {
                    numStack.push(curNum);
                } else if (sign == '-') {
                    numStack.push(curNum * (-1));
                } else if (sign == '*') {
                    numStack.push(numStack.pop() * curNum);
                } else if (sign == '/') {
                    numStack.push(numStack.pop() / curNum);
                }
                curNum = 0;
                sign = s.charAt(i);
            }
        }

        for (Integer value : numStack) {
            retValue+= value;
        }
        return retValue;
    }

    public static void main(String[] args) {
        int calculate = calculate("12+4*6");
        System.out.println(calculate);
    }
}
