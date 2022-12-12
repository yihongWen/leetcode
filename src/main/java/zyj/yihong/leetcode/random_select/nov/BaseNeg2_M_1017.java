package zyj.yihong.leetcode.random_select.nov;

//  1017. 负二进制转换
public class BaseNeg2_M_1017 {
    public String baseNeg2(int n) {
        // 生成1010101....表示正数的最大值
        int max = 1;
        while (max<n){
            max = (max<<2)+1;
        }
        return Integer.toBinaryString(max^(max-n));
    }
}
