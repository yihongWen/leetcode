package zyj.yihong.leetcode.mid.stack;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 注意 两个整数之间的除法只保留整数部分。
 * <p>
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 */
public class EvalRPN150 {
    //    tokens = ["2","1","+","3","*"]
//    输出：9
//    解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
    public static int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")){
                Integer pop = numStack.pop();
                Integer pop1 = numStack.pop();
                numStack.push(pop1+pop);
            }else if (token.equals("-")){
                Integer pop = numStack.pop();
                Integer pop1 = numStack.pop();
                numStack.push(pop1-pop);
            }else if (token.equals("*")){
                Integer pop = numStack.pop();
                Integer pop1 = numStack.pop();
                numStack.push(pop1*pop);
            }else if (token.equals("/")){
                Integer pop = numStack.pop();
                Integer pop1 = numStack.pop();
                numStack.push(pop1/pop);
            }else {
                numStack.push(Integer.parseInt(token));
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        int i = evalRPN(tokens);
        System.out.println(i);
    }
}
