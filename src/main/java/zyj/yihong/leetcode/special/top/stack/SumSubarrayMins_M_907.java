package zyj.yihong.leetcode.special.top.stack;

import java.util.Stack;

/**
 * 907. 子数组的最小值之和
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 *
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 *
 */
public class SumSubarrayMins_M_907 {
    public static int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;

        Stack<Node> stack = new Stack();
        int ans = 0;
        int curMin = 0;
        for (int i = 0; i < arr.length; i++) {
            // 每次表示范围 0-i,对于每一个i需要计算，在范围0-i之间最小值
            // 以及arr[i]在0-i范围中的连续子集中为最小值的个数
            int curMinCount = 1;
            while (!stack.isEmpty()&&stack.peek().value>=arr[i]){
                Node node = stack.pop();
                curMinCount+=node.lessValueCount;
                curMin-= node.value* node.lessValueCount;
            }

            stack.push(new Node(arr[i],curMinCount));
            curMin+=arr[i]*curMinCount;
            ans+=curMin;
            ans=ans%MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,7,5,2,4,3,9};
        int i = sumSubarrayMins(arr);
        System.out.println(i);
    }


    static class Node {
        int value;
        int lessValueCount;
        Node(int value, int count) {
            this.value = value;
            lessValueCount = count;
        }
    }
}




