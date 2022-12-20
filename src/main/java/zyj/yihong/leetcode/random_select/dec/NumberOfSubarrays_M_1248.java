package zyj.yihong.leetcode.random_select.dec;

// 1248. 统计「优美子数组」
public class NumberOfSubarrays_M_1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int oddCount = 0;
        int[] pos = new int[nums.length+1];
        pos[0] = 1;
        for (int num : nums) {
            oddCount += num & 1;
            if (oddCount >= k) {
                ans += pos[oddCount - k];
            }
            pos[oddCount]++;
        }
        return ans;
    }
}
