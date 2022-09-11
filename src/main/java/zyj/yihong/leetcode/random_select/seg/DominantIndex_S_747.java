package zyj.yihong.leetcode.random_select.seg;

public class DominantIndex_S_747 {
    public static int dominantIndex(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        int[][] arr = new int[2][2];
        if (nums[0]>nums[1]){
            arr[0][0] = nums[0];
            arr[0][1] = 0;
            arr[1][0] = nums[1];
            arr[1][1] = 1;
        }else {
            arr[0][0] = nums[1];
            arr[0][1] = 1;
            arr[1][0] = nums[0];
            arr[1][1] = 0;
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i]>arr[0][0]){
                arr[1][0] = arr[0][0];
                arr[1][1] = arr[0][1];
                arr[0][0] = nums[i];
                arr[0][1] = i;
            } else if (nums[i]<arr[0][0] && nums[i]>arr[1][0]){
                arr[1][0] = nums[i];
                arr[1][1] = i;
            }
        }

        if (arr[0][0]>=arr[1][0]*2){
            return arr[0][1];
        }

        return -1;
    }

    public static void main(String[] args) {
//        [0,0,3,2]
        int[] arr = new int[]{0,0,3,2};
        int i = dominantIndex(arr);
        System.out.println(i);
    }
}
