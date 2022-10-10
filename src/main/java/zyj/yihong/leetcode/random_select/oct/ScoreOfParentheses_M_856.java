package zyj.yihong.leetcode.random_select.oct;

import java.util.Stack;

// 856. 括号的分数
public class ScoreOfParentheses_M_856 {
    public static int scoreOfParentheses(String s) {
        // 使用栈的方式
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('){
                stack.push(0);
            }else {
                Integer cur = stack.pop();
                Integer pre = stack.pop();
                stack.push(pre+Math.max(cur*2,1));
            }
        }
        return stack.pop();
    }

    public static int scoreOfParentheses2(String s) {
        int ans = 0;
        int bitLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('){
                bitLength++;
            }else {
                bitLength--;
                if (s.charAt(i-1)=='(') {
                    ans += 1 << bitLength;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "((()()))";
        int i = scoreOfParentheses2(s);
        System.out.println(i);
    }
}
