package zyj.yihong.leetcode.random_select.seg;

import java.util.LinkedList;
import java.util.Queue;

// 1306. 跳跃游戏 III
public class CanReach_M_1306 {
    public static boolean canReach(int[] arr, int start) {
        Queue<Integer> queue  = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            Integer curIndex = queue.poll();
            if (arr[curIndex]<0){
                continue;
            }
            if (arr[curIndex]==0){
                return true;
            }
            if (curIndex+arr[curIndex]<arr.length && arr[curIndex+arr[curIndex]]>=0) {
                queue.add(curIndex+arr[curIndex]);
            }

            if (curIndex-arr[curIndex]>=0 && arr[curIndex-arr[curIndex]]>=0){
                queue.add(curIndex-arr[curIndex]);
            }

            arr[curIndex]-=arr.length;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,3,0,3,1,2};
        int start = 2;
        boolean b = canReach(arr, 5);
        System.out.println(b);
    }
}
