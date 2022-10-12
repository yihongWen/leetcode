package zyj.yihong.leetcode.random_select.oct;

// 376. 摆动序列
public class WiggleMaxLength_M_376 {
    public int wiggleMaxLength(int[] nums) {
        int[] dpDown = new int[nums.length];
        int[] dpUp = new int[nums.length];

        dpDown[0] = 1;
        dpUp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff > 0) {
                dpUp[i] = Math.max(dpUp[i - 1], dpDown[i - 1] + 1);
                dpDown[i] = dpDown[i - 1];
            } else if (diff < 0) {
                dpDown[i] = Math.max(dpDown[i - 1], dpUp[i - 1] + 1);
                dpUp[i] = dpUp[i - 1];
            } else {
                dpDown[i] = dpDown[i - 1];
                dpUp[i] = dpUp[i - 1];
            }
        }

        return Math.max(dpDown[nums.length - 1], dpUp[nums.length - 1]);
    }


    public int wiggleMaxLength2(int[] nums) {
        int dpDown = 1;
        int dpUp = 1;

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff > 0) {
                dpUp = Math.max(dpUp, dpDown + 1);
            } else if (diff < 0) {
                dpDown = Math.max(dpDown, dpUp + 1);
            }
        }
        return Math.max(dpDown, dpUp);
    }


    public static int wiggleMaxLength3(int[] nums) {
        if (nums.length==1){
            return 1;
        }
        int preDiff = nums[1] - nums[0];
        int ans = preDiff == 0 ? 1 : 2;

        for (int i = 2; i < nums.length; i++) {
            int curDiff = nums[i]-nums[i-1];
            if ((curDiff>0&&preDiff<=0)||(curDiff<0&&preDiff>=0)){
                ans++;
                preDiff = curDiff;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,3,2,5};
        int i = wiggleMaxLength3(arr);
        System.out.println(i);

    }
}
