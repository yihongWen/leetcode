package zyj.yihong.leetcode.mid.divide_and_conquer;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute241 {
    public List<Integer> diffWaysToCompute(String expression) {
        return divideAndConquer(expression);
    }

    private List<Integer> divideAndConquer(String expression){
        List<Integer> ans = new ArrayList<>();
        // 如果当前仅仅只是一个数字，那么直接返回,划分的最小粒度
        boolean curStringIsDigit = true;
        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i))){
                curStringIsDigit = false;
                break;
            }
        }

        if (curStringIsDigit){
            ans.add(Integer.parseInt(expression));
            return ans;
        }

        //如果当前包含运算符、此时根据运算符进行划分
        for (int i = 0; i <expression.length() ; i++) {
            // 如果当前值为运算符号
            if (!Character.isDigit(expression.charAt(i))){
                // 划分为left、right两个子表达式
                String leftExpression = expression.substring(0, i);
                String rightExpression = expression.substring(i + 1);
                // 分别对两个子表达式进行划分
                List<Integer> leftAns = divideAndConquer(leftExpression);
                List<Integer> rightAns = divideAndConquer(rightExpression);

                // 计算当前结果：
                for (Integer leftAn : leftAns) {
                    for (Integer rightAn : rightAns) {
                        if (expression.charAt(i)=='+'){
                            ans.add(leftAn+rightAn);
                        }else if (expression.charAt(i)=='*'){
                            ans.add(leftAn*rightAn);
                        }else if (expression.charAt(i)=='-'){
                            ans.add(leftAn-rightAn);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
