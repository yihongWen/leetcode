package zyj.yihong.leetcode.mid.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DailyTemperatures739 {
    // 单调栈
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] retArr = new int[temperatures.length];
        Stack<Integer> tempIndexStack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!tempIndexStack.isEmpty()&&temperatures[i]>temperatures[tempIndexStack.peek()]){
                tempIndexStack.pop();
            }

            if (tempIndexStack.isEmpty()){
                retArr[i] = 0;
            }else {
                retArr[i] = tempIndexStack.peek()-i;
            }
            tempIndexStack.push(i);
        }
        return retArr;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] resultArr = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(resultArr));
    }
}
