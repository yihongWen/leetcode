package zyj.yihong.leetcode.simple.stack;

import java.util.Stack;

/**
 * 682. 棒球比赛
 * <p>
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * <p>
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * <p>
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 */
public class CalPoints682 {
    /**
     * 使用栈：模拟实现
     *
     * @param ops
     * @return
     */
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (op.equals("+")) {
                Integer pop = stack.pop();
                Integer peek = stack.peek();
                int cur = peek + pop;
                stack.push(pop);
                stack.push(cur);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                Integer cur = Integer.parseInt(op);
                stack.push(cur);
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum+= stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] arr =  {"5","2","C","D","+"};
        int score = calPoints(arr);
        System.out.println(score);
    }
}
