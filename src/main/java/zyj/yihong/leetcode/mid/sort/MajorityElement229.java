package zyj.yihong.leetcode.mid.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 求众数2：给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */
public class MajorityElement229 {

    /**
     * 摩尔消除法:结果最大只能是2个数
     * 通过抵消的方式找到这两个候选结果，然后在判断候选结果是否满足条件
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {
        // 定义抵消过程的变量:第一、二个抵消元素的值、数量
        int e1 = 0;
        int e2 = 0;
        int n1 = 0;
        int n2 = 0;

        // 抵消的过程
        for (int num : nums) {
            if (n1>0 && e1==num){
                n1++;
            }else if (n2>0 && e2==num) {
                n2++;
            }else if (n1==0){
                n1++;
                e1 = num;
            }else if (n2 == 0){
                n2++;
                e2 = num;
            }else {
                n1--;
                n2--;
            }
        }

        // 判断是否满足条件
        int e1AllCount = 0;
        int e2AllCount = 0;
        for (int num : nums) {
            if (n1!=0 && num==e1){
                e1AllCount++;
            }
            if (n2!=0 && num==e2){
                e2AllCount++;
            }
        }

        List<Integer> retList = new ArrayList<>();
        if (e1AllCount>nums.length/3){
            retList.add(e1);
        }

        if (e2AllCount> nums.length/3){
            retList.add(e2);
        }


        return retList;
    }

    public static void main(String[] args) {
        int[] testArr = {0,0,0};
        List<Integer> list = majorityElement(testArr);
        System.out.println(list);
    }
}
