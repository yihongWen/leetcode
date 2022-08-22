package zyj.yihong.leetcode.random_select.aug;

// 477. 汉明距离总和
public class TotalHammingDistance_M_477 {
    public static int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int bit0 = 0;
            int bit1 = 0;
            for (int j = 0; j < nums.length; j++) {
                int num = nums[j];
                if (((1<<i)&num)==0){
                    bit0++;
                }else {
                    bit1++;
                }
            }
            ans += bit0*bit1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,14,2};
        int i = totalHammingDistance(arr);
        System.out.println(i);
    }
}
