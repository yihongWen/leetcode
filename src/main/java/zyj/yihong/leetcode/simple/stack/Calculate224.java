package zyj.yihong.leetcode.simple.stack;


import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 */
public class Calculate224 {
    public static int calculate(String s) {
        int n = s.length();
        int retValue = 0;
        Stack<Integer> signStack = new Stack<>();
        int sign = 1;
        signStack.add(sign);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c==' '){
                continue;
            }
            if (c=='+'){
                sign = signStack.peek();
            }else if (c=='-'){
                sign = (signStack.peek())*(-1);
            }else if (c=='('){
                signStack.push(sign);
            }else if (c==')'){
                signStack.pop();
            }else {
                // 计算出当前数字
                int cur = 0;

                while (i<n&&Character.isDigit(s.charAt(i))){
                    cur = cur*10+(s.charAt(i)-'0');
                    i++;
                }
                i--;

                retValue = retValue+cur*sign;
            }
        }

        return retValue;
    }

    public static void main(String[] args) {
        int calculate = calculate("- (3 + (4 + 5))");
        System.out.println(calculate);
    }
}
