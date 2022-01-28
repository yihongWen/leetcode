package zyj.yihong.leetcode.mid.sort;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class LargestNumber179 {

    /**
     * 使用自定义排序的方式：
     * 假设a = 9 b=24
     * 结果可以组成：9*100（取决于另一个数的位数）+24 = 924
     * 24*10+9 = 249
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        if (nums==null || nums.length==0){
            return null;
        }

        if (nums.length==1){
            return String.valueOf(nums[0]);
        }

        // 转化成包装类型，使用lambda进行排序
        Integer[] numsBoxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // 自定义排序
        Arrays.sort(numsBoxed,(a,b)->{
            int aLength = 10;
            int bLength = 10;
            while(aLength<=a){
                aLength = aLength*10;
            }

            while(bLength<=b){
                bLength = bLength*10;
            }

            return (b * aLength + a)-(a * bLength + b) ;
        });

        // 数组全是0
        if(numsBoxed[0]==0){
            return "0";
        }

        // 返回结果
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numsBoxed.length; i++) {
            stringBuilder.append(numsBoxed[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] testArr = {3,30,34,5,9};
        String s = largestNumber(testArr);
        System.out.println(s);
    }
}
