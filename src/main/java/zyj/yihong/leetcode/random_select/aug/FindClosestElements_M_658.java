package zyj.yihong.leetcode.random_select.aug;

import java.util.ArrayList;
import java.util.List;

// 658. 找到 K 个最接近的元素
public class FindClosestElements_M_658 {
    public  List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int valueIndex = getValueIndex(arr, x);
        int left = valueIndex-1;
        int right = valueIndex;

        while (k>0){
            if (left<0){
                right++;
            }else if (right>arr.length-1){
                left--;
            }else if (arr[right]-x>=x-arr[left]){
                left--;
            }else {
                right++;
            }
            k--;
        }

        for (int i = left+1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    private int getValueIndex(int[] arr,int x){
        int left = 0;
        int right = arr.length;
        while (left<right){
            int mid  = left+((right-left)>>1);
            if (arr[mid]>=x){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
//        [0,1,1,1,2,3,6,7,8,9]
//9
//4
        FindClosestElements_M_658 findClosestElements_m_658 = new FindClosestElements_M_658();
        int[] arr = {1,2,3,4,5};
        List<Integer> closestElements = findClosestElements_m_658.findClosestElements(arr, 4, 3);
        System.out.println(closestElements);
    }
}
