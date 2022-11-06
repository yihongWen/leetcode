package zyj.yihong.leetcode.random_select.nov;

// 1678. 设计 Goal 解析器
public class Interpret_S_1678 {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int len = command.length();
        for (int i = 0; i < len; i++) {
            char c = command.charAt(i);
            if (c=='G'){
                sb.append("G");
            }else if (c==')'){
                if (command.charAt(i-1)=='('){
                    sb.append("o");
                }else {
                    sb.append("al");
                }
            }
        }

        return sb.toString();
    }
}
