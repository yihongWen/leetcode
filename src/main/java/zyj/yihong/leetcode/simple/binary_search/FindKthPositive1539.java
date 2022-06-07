package zyj.yihong.leetcode.simple.binary_search;

/**
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 *
 * 请你找到这个数组里第 k 个缺失的正整数。
 */
public class FindKthPositive1539 {
    public static int findKthPositive(int[] arr, int k) {
        // 特殊情况处理：
        // int[] arr = {2};
        // int k = 1
        if (arr[0] > k) {
            return k;
        }

        // 二分：找打某个位置index满足缺失超过>=k,arr[index-1]+some
        int left = 0;
        int right = arr.length;
        while (left<right){
            // 特殊情况处理：如果k比较大，index超出了数组的范围
            int mid = left + ((right - left) >> 1);
            int num = mid >= arr.length ? Integer.MAX_VALUE : arr[mid];
            if (num-mid-1>=k){
                right = mid;
            }else {
                left = mid+1;
            }
        }

        return k-(arr[left-1]-(left-1)-1)+arr[left-1];
    }

    public static void main(String[] args) {
        int[] arr = {2};
        int kthPositive = findKthPositive(arr, 1);
        System.out.println(kthPositive);
    }
}
