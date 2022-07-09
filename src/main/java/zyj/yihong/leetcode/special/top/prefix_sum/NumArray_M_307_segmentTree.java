package zyj.yihong.leetcode.special.top.prefix_sum;

// 使用线段树的方式实现
public class NumArray_M_307_segmentTree {

    SegmentTree segmentTree;
    public NumArray_M_307_segmentTree(int[] nums) {
        segmentTree = new SegmentTree(nums);
    }

    public void update(int index, int val) {
        segmentTree.update(index,index,val);
    }

    public int sumRange(int left, int right) {
         return segmentTree.segmentSum(left, right);
    }

    public static class SegmentTree {
        // 使用堆的方式建树
        int[] heapSegmentTreeArr;

        // 线段树整个区间的大小
        int sectionSize;

        // 构造函数初始化线段树属性
        public SegmentTree(int[] originArr) {
            this.sectionSize = originArr.length;
            heapSegmentTreeArr = new int[sectionSize*4];
            initSegmentTree(0,0,originArr.length-1,originArr);
        }


        /**
         * 已知的数据集，初始化线段树
         * @param curTreeNodeIndex 当前节点
         * @param start 当前节点代表的范围起点
         * @param end .....终点
         * @param originArr 原始数据
         */
        private void initSegmentTree(int curTreeNodeIndex,int start,int end,int[] originArr){

            // 处理叶子节点
            if (start==end){
                heapSegmentTreeArr[curTreeNodeIndex] = originArr[start];
                return;
            }

            // 递归的处理子节点：计算左右节点代表的范围
            int mid = start+((end-start)>>1);
            initSegmentTree((curTreeNodeIndex<<1)+1,start,mid,originArr);
            initSegmentTree((curTreeNodeIndex<<1)+2,mid+1,end,originArr);

            // 当前节点：非叶子节点和为两个子节点的和
            heapSegmentTreeArr[curTreeNodeIndex] = heapSegmentTreeArr[(curTreeNodeIndex<<1)+1]+heapSegmentTreeArr[(curTreeNodeIndex<<1)+2];
        }

        // 查找范围和
        public int segmentSum(int left,int right){
            return segmentSum(left,right,0,0,sectionSize-1);
        }

        private int segmentSum(int left,int right,int curNodeIndex,int curNodeStart,int curNodeEnd){
            // 如果当前节点是叶子节点,或者线段中存在left、right所在的范围和，直接返回结果
            if (left==curNodeStart&&right==curNodeEnd){
                return heapSegmentTreeArr[curNodeIndex];
            }

            // 计算终点，判断往那边走：（左、右、或者左右）
            int mid = curNodeStart+((curNodeEnd-curNodeStart)>>1);
            if (mid>=right){
                return segmentSum(left,right,(curNodeIndex<<1)+1,curNodeStart,mid);
            }else if (left>mid){
                return segmentSum(left,right,(curNodeIndex<<1)+2,mid+1,curNodeEnd);
            }

            return segmentSum(left,mid,(curNodeIndex<<1)+1,curNodeStart,mid)+segmentSum(mid+1,right,(curNodeIndex<<1)+2,mid+1,curNodeEnd);
        }


        // 查找范围和
        public void update(int left,int right,int val){
            for (int index = left; index <=right ; index++) {
                update(index,val,0,0,sectionSize-1);

            }
        }

        private void update(int index,int val,int curNodeIndex,int curNodeStart,int curNodeEnd){
            // 处理叶子节点
            if (curNodeEnd==curNodeStart){
                heapSegmentTreeArr[curNodeIndex] = val;
                return;
            }

            // 递归
            int mid = curNodeStart+((curNodeEnd-curNodeStart)>>1);
            if (mid>=index){
                update(index,val,(curNodeIndex<<1)+1,curNodeStart,mid);
            }else{
                update(index,val,(curNodeIndex<<1)+2,mid+1,curNodeEnd);
            }

            heapSegmentTreeArr[curNodeIndex] = heapSegmentTreeArr[(curNodeIndex<<1)+1]+heapSegmentTreeArr[(curNodeIndex<<1)+2];
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,3,5};
        NumArray_M_307_segmentTree numArrayM307segmentTree = new NumArray_M_307_segmentTree(arr);
        int i = numArrayM307segmentTree.sumRange(0, 2);
        numArrayM307segmentTree.update(1,2);
        int i1 = numArrayM307segmentTree.sumRange(0, 2);
        System.out.println(i);
        System.out.println(i1);
    }
}
