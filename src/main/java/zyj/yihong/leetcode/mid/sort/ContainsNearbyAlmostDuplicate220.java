package zyj.yihong.leetcode.mid.sort;

import java.util.TreeSet;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 */
public class ContainsNearbyAlmostDuplicate220 {

    /**
     * 使用滑动窗口的方式
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        // 定义treeSet结构进行存储数据
        TreeSet<Long> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            // 最小和最大范围确定有没有数据
            Long ceilingNumI = treeSet.ceiling((long)nums[i]-(long)t);
            if (ceilingNumI!=null && ceilingNumI<= (long)nums[i]+(long)t){
                return true;
            }
            // 判断当前的边界
            treeSet.add((long)nums[i]);
            if (i-k>=0){
                treeSet.remove((long)nums[i-k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] test = {2147483640,2147483641};
        boolean b = containsNearbyAlmostDuplicate(test, 1, 100);
        System.out.println(b);
    }



}
