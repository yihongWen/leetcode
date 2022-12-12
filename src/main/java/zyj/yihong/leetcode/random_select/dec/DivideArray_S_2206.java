package zyj.yihong.leetcode.random_select.dec;

// 2206. 将数组划分成相等数对
public class DivideArray_S_2206 {
    public boolean divideArray(int[] nums) {
        int[] map = new int[501];
        for (int num : nums) {
            map[num]++;
        }

        for (int m : map) {
            if ((m&1)!=0){
                return false;
            }
        }
        return true;
    }
}
