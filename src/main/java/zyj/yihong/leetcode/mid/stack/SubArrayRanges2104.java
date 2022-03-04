package zyj.yihong.leetcode.mid.stack;

import sun.applet.Main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SubArrayRanges2104 {
    public static long subArrayRanges(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(nums[j],max);
                min = Math.min(nums[j],min);
                sum+= max - min;
            }
        }
        return sum;
    }

    /**
     * 最小栈：
     * @param nums
     * @return
     */
    public static long subArrayRanges2(int[] nums) {
        // 定义数组：最大栈、最小栈，保存当前值为最小值的左边界、右边界，最大值的左边界、右边界
        Stack<Integer> maxStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        int[] maxLeft = new int[nums.length];
        int[] maxRight = new int[nums.length];
        int[] minLeft = new int[nums.length];
        int[] minRight = new int[nums.length];

        // 计算左边界： minLeft 、 maxLeft
        for (int i = 0; i < nums.length; i++) {
            // minLeft
            while (!minStack.isEmpty()&&nums[minStack.peek()]>nums[i]){
                minStack.pop();
            }
            minLeft[i] = minStack.isEmpty()?-1:minStack.peek();
            minStack.push(i);

            // maxLeft
            while (!maxStack.isEmpty()&&nums[maxStack.peek()]<=nums[i]){
                maxStack.pop();
            }
            maxLeft[i] = maxStack.isEmpty()?-1:maxStack.peek();
            maxStack.push(i);
        }
        // 清空栈
        minStack.clear();
        maxStack.clear();

        // 计算右边界
        for (int i = nums.length-1; i >=0; i--) {
            // minRight
            while (!minStack.isEmpty()&&nums[minStack.peek()]>=nums[i]){
                minStack.pop();
            }
            minRight[i] = minStack.isEmpty()?nums.length:minStack.peek();
            minStack.push(i);

            // maxRight
            while (!maxStack.isEmpty()&&nums[maxStack.peek()]<nums[i]){
                maxStack.pop();
            }
            maxRight[i] = maxStack.isEmpty()?nums.length:maxStack.peek();
            maxStack.push(i);
        }

        // 计算结果：
        long allMaxSum = 0;
        long allMinSum = 0;
        for (int i = 0; i < nums.length; i++) {
            allMaxSum+=(long)(i- maxLeft[i])*(maxRight[i]-i)*nums[i];
            allMinSum+=(long)(i- minLeft[i])*(minRight[i]-i)*nums[i];
        }

        return allMaxSum-allMinSum;

    }

    public static long subArrayRanges3(int[] nums) {
        int n = nums.length;
        int[] minLeft = new int[n];
        int[] minRight = new int[n];
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        Deque<Integer> minStack = new ArrayDeque<Integer>();
        Deque<Integer> maxStack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!minStack.isEmpty() && nums[minStack.peek()] > nums[i]) {
                minStack.pop();
            }
            minLeft[i] = minStack.isEmpty() ? -1 : minStack.peek();
            minStack.push(i);

            // 如果 nums[maxStack.peek()] == nums[i], 那么根据定义，
            // nums[maxStack.peek()] 逻辑上小于 nums[i]，因为 maxStack.peek() < i
            while (!maxStack.isEmpty() && nums[maxStack.peek()] <= nums[i]) {
                maxStack.pop();
            }
            maxLeft[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }
        minStack.clear();
        maxStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            // 如果 nums[minStack.peek()] == nums[i], 那么根据定义，
            // nums[minStack.peek()] 逻辑上大于 nums[i]，因为 minStack.peek() > i
            while (!minStack.isEmpty() && nums[minStack.peek()] >= nums[i]) {
                minStack.pop();
            }
            minRight[i] = minStack.isEmpty() ? n : minStack.peek();
            minStack.push(i);

            while (!maxStack.isEmpty() && nums[maxStack.peek()] < nums[i]) {
                maxStack.pop();
            }
            maxRight[i] = maxStack.isEmpty() ? n : maxStack.peek();
            maxStack.push(i);
        }

        long sumMax = 0, sumMin = 0;
        for (int i = 0; i < n; i++) {
            sumMax += (long) (maxRight[i] - i) * (i - maxLeft[i]) * nums[i];
            sumMin += (long) (minRight[i] - i) * (i - minLeft[i]) * nums[i];
        }
        return sumMax - sumMin;
    }


    public static void main(String[] args) {
        int[] arr = {44100,-56253,-87825,85180,9757,38400,-79790,70906,-84011,-47443,7591,51955,82857,88601,-40488,50522,67401,52187,-95259,29098,-90134,89896,-77967,-22428,-28532,-90237,-99696,-62447,87981,-12925,7985,39797,-47714,-63656,-74771,22170,-23500,93592,-4531,84380,-6001,85246,-97211,-59961,94258,61193,5647,50267,-84298,-74537,93428,-65618,65642,13034,29918,71695,-73036,-77551,534,-89410,-48966,75211,-58026,80627,15452,36970,8639,24721,-69696,53800,-31659,57435,-48166,-20745,45691,27731,-58085,84151,68345,89265,-86124,-62665,3042,-91274,778,13232,14311,16015,-53543,66854,-71929,84591,-12147,-92987,14605,48389,-58397,-77052,93904,-18773,-25516,-41432,82123,-21665,-54708,-12475,30278,-67332,-26924,-15315,8680,49804,19357,-90558,80541,21961,-54950,91191,82745,-81144,49588,49217,54596,-618,78471,-18303,78836,48380,-34052,83040,27224,93503,94966,-53188,-96363,22665,-53675,-36581,72081,90508,-18263,-84327,86545,-11804,-3786,78317,96389,68162,-14903,-62461,-55365,-66125,-82587,-4308,93327,-76806,17561};
        long l = subArrayRanges3(arr);
        System.out.println(l);
    }


}
