package zyj.yihong.leetcode.special.top.d_point;

import java.util.Arrays;

/**
 * 1089. 复写零
 *
 */
public class DuplicateZeros1089 {
    public static void duplicateZeros(int[] arr) {
        // 双指针
        int left = 0;
        int right = 0;
        while (right<arr.length){
            if (arr[left]==0){
                right = right+2;
            }else {
                right = right+1;
            }
            left++;
        }

        // 对right在最后一步超出限制处理
        if (right==arr.length+1&&arr[left-1]!=0){
            left--;
            right=right-2;
        } else if (right== arr.length+1&&arr[left-1]==0) {
            arr[right-2] = 0;
            right = right-3;
            left = left-2;
        } else if (right==arr.length&&arr[left-1]==0){
            arr[right-1] = 0;
            arr[right-2] = 0;
            right = arr.length-3;
            left = left-2;
        }else if (right==arr.length&&arr[left-1]!=0){
            arr[right-1] = arr[left-1];
            right = arr.length-2;
            left = left-2;
        }

        for (int i = left; i >=0 ; i--) {
            if (arr[i]!=0){
                arr[right] = arr[i];
                right--;
            }else {
                arr[right] = 0;
                arr[right-1] = 0;
                right = right-2;
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] arr = {1,5,2,0,6,8,0,6,0};
        duplicateZeros(arr);

    }
}
