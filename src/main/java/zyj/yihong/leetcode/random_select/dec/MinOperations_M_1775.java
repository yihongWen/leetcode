package zyj.yihong.leetcode.random_select.dec;

// 1775. 通过最少操作次数使数组的和相等
public class MinOperations_M_1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        // 判断无论如何都不可以处理的条件
        if (nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6) {
            return -1;
        }

        // 统计每个数组中的1-6每个数的个数是多少,以及两个数组的差值
        int[] count1 = new int[7];
        int[] count2 = new int[7];
        int diff = 0;

        for (int i = 0; i < nums1.length; i++) {
            count1[nums1[i]]++;
            diff += nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            count2[nums2[i]]++;
            diff -= nums2[i];
        }

        if (diff > 0) {
            return handle(count1, count2, diff);
        }

        return handle(count2, count1, -diff);

    }

    private int handle(int[] countArr1, int[] countArr2, int diff) {
        // Sum(arr1)>Sum(arr2)
        int ans = 0;
        if (diff == 0) {
            return ans;
        }

        // 使用贪心进行处理，arr1以及进行减操作（5-1），arr2可以进行加操作（5-1）
        int[] opt = new int[7];
        for (int i = 1; i <= 5; i++) {
            // -操作
            opt[i] += countArr1[i + 1];

            // +操作
            opt[i] += countArr2[6 - i];
        }

        for (int i = 5; i >= 1 && diff != 0; i--) {
            if (opt[i] * i <= diff) {
                ans += opt[i];
                diff -= opt[i] * i;
            } else {
                ans += (diff / i) + (diff % i == 0 ? 0 : 1);
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinOperations_M_1775 minOperations_m_1775 = new MinOperations_M_1775();
        int[] nums1 = {1,2,3,4,5,6};
        int[] nums2 = {1,1,2,2,2,2};
        int i = minOperations_m_1775.minOperations(nums1, nums2);
        System.out.println(i);

    }

}
