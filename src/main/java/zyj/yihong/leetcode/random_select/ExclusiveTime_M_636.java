package zyj.yihong.leetcode.random_select;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// 636. 函数的独占时间
public class ExclusiveTime_M_636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        // 使用栈的方式
        Stack<ExecuteNode> stack = new Stack<>();
        int[] ans = new int[n];

        for (String log : logs) {
//            0:start:0
            String[] splitLog = log.split(":");
            int sId = Integer.parseInt(splitLog[0]);
            String state = splitLog[1];
            int time = Integer.parseInt(splitLog[2]);

            if (state.equals("start")){
                // 新的执行node进栈，判断是否存在递归调用
                ExecuteNode executeNode = new ExecuteNode();
                executeNode.sid = sId;
                executeNode.startTime = time;
                if (!stack.isEmpty()){
                    // 计算上一个的执行时间
                    int curExecuteTime = time - stack.peek().startTime;
                    ans[stack.peek().sid] += curExecuteTime;
                }
                stack.push(executeNode);
            }else {
                // 如果是结束状态
                ExecuteNode pop = stack.pop();
                ans[pop.sid] += time- pop.startTime+1;
                if (!stack.isEmpty()){
                    stack.peek().startTime = time+1;
                }
            }
        }

        return ans;

    }


    // 执行节点的表示
    class ExecuteNode{
        public int sid;
        public int startTime;
    }


    public static void main(String[] args) {
//        输入：n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
        ExclusiveTime_M_636 exclusiveTime_m_636 = new ExclusiveTime_M_636();
        List<String> strings = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");

        int[] ints = exclusiveTime_m_636.exclusiveTime(2, strings);
        System.out.println(Arrays.toString(ints));
    }
}
