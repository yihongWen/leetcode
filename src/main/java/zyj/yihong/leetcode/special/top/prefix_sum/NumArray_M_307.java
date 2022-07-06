package zyj.yihong.leetcode.special.top.prefix_sum;

/**
 * 307. 区域和检索 - 数组可修改
 */
public class NumArray_M_307 {

    private int[] fenwickTreeArr;
    private int[] originNums;
    // 使用树状数组的方式实现
    public NumArray_M_307(int[] nums) {
        originNums = nums;
        fenwickTreeArr = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            init(i,nums[i]);
        }
    }

    public void init(int index,int val){
        index = index+1;
        while (index<fenwickTreeArr.length) {
            fenwickTreeArr[index]+=val;
            index = index + lowBit(index);
        }
    }

    public void update(int index, int val) {
        int temp = val;
        temp = temp-originNums[index];
        originNums[index] = val;
        index = index+1;
        while (index<fenwickTreeArr.length) {
            fenwickTreeArr[index]+=temp;
            index = index + lowBit(index);
        }
    }

    public int search(int index){
        index = index+1;
        int ans = 0;
        while (index!=0){
            ans+=fenwickTreeArr[index];
            index = index-lowBit(index);
        }
        return ans;
    }

    public int sumRange(int left, int right) {
        int rightValue = search(right);
        int leftValue = search(left - 1);
        return rightValue-leftValue;

    }

    private int lowBit(int index) {
        return index&(-index);
    }

    public static void main(String[] args) {
//        ["NumArray","sumRange","update","sumRange"]
//[[[1,3,5]],[0,2],[1,2],[0,2]]
//        ["NumArray","sumRange","update","update","update","update","sumRange"]
//[[[5,18,13]],[0,2],[1,-1],[2,3],[0,5],[0,-4],[0,2]]
        int[] arr = {5,18,13};
        NumArray_M_307 numArray_m_307 = new NumArray_M_307(arr);
        int i = numArray_m_307.sumRange(0, 2);
        System.out.println(i);
        numArray_m_307.update(0,2);
        numArray_m_307.update(1,-1);
        numArray_m_307.update(2,3);
        numArray_m_307.update(0,5);
        numArray_m_307.update(0,-4);

        int i1 = numArray_m_307.sumRange(0, 2);
        System.out.println(i1);
    }
}
