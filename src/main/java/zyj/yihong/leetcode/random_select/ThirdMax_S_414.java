package zyj.yihong.leetcode.random_select;

public class ThirdMax_S_414 {
    public int thirdMax(int[] nums) {
        long[] maxArr = {Long.MIN_VALUE,Long.MIN_VALUE,Long.MIN_VALUE};
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num>maxArr[0]){
                maxArr[2] = maxArr[1];
                maxArr[1] = maxArr[0];
                maxArr[0] = num;
            }else if (num>maxArr[1]&&num!=maxArr[0]){
                maxArr[2] = maxArr[1];
                maxArr[1] = num;
            }else if (num>maxArr[2]&&num!=maxArr[1]&&num!=maxArr[0]){
                maxArr[2] = num;
            }
        }
        return (int)(maxArr[2]!=Long.MIN_VALUE?maxArr[2]:maxArr[0]);
    }


    public int thirdMax02(int[] nums) {
       long[] maxArr = {Long.MIN_VALUE,Long.MIN_VALUE,Long.MIN_VALUE};

        for (int i = 0; i < 3; i++) {
            for (int num : nums) {
                if (i == 0) {
                    maxArr[i] = Math.max(num, maxArr[i]);
                } else if (i == 1 && num != maxArr[0]) {
                    maxArr[i] = Math.max(num, maxArr[i]);
                } else if (i == 2 && num != maxArr[0] && num != maxArr[1]) {
                    maxArr[i] = Math.max(num, maxArr[i]);
                }
            }
        }

        return (int)(maxArr[2]!=Long.MIN_VALUE?maxArr[2]:maxArr[0]);

    }

    public static void main(String[] args) {
        ThirdMax_S_414 thirdMax_s_414 = new ThirdMax_S_414();
        int[] arr = {1,2,2,5,3,5};
        int i = thirdMax_s_414.thirdMax(arr);
        System.out.println(i);
    }
}
