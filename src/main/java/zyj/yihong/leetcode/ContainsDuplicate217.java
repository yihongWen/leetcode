package zyj.yihong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个数组判断是否存在重复元素
 * @author yihong
 */
public class ContainsDuplicate217 {

    /**
     * 使用set:空间复杂度较大
     * @param arr 给定数组
     * @return
     */
    public boolean judgeDuplicate1(int[] arr){
        Set<Integer> arrSet = new HashSet<Integer>();
        for (int i : arr) {
            if (arrSet.contains(i)){
                return true;
            }else {
                arrSet.add(i);
            }
        }
        return false;
    }

    /**
     * 在原数组排序的基础上进行
     * @param arr
     * @return
     */
    public boolean judgeDuplicate2(int[] arr){
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==arr[i+1]){
                return true;
            }
        }
        return false;
    }


    /**
     * 使用stream简单的写法
     * @param arr
     * @return
     */
    public boolean judgeDuplicate3(int[] arr){
        return Arrays.stream(arr).distinct().count()<arr.length;
    }

}
