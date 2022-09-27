package zyj.yihong.leetcode.random_select.seg;


// m 17.19. 消失的两个数字
public class MissingTwo_H_M1719 {
    public  int[] missingTwo(int[] nums) {
        // 假设缺失的数字为x1,x2
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            x = x ^ nums[i];
        }

        for (int i = 1; i <= nums.length + 2; i++) {
            x = x ^ i;
        }

        // 计算出不同位的值
        int y = x==Integer.MIN_VALUE?Integer.MIN_VALUE:x&(-x);

        // 基于y,将num中的数据分为两组
        int x1 = 0;
        int x2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((y&nums[i])==0){
                x1 = x1^nums[i];
            }else {
                x2 = x2^nums[i];
            }
        }

        for (int i = 1; i <= nums.length+2; i++) {
            if ((y&i)==0){
                x1=x1^i;
            }else {
                x2 = x2^i;
            }
        }

        return new int[]{x1,x2};
    }
}
