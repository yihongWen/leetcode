package zyj.yihong.datastruct;

import java.util.Arrays;

/**
 * 树状数组
 */
public class TreeArr {
    // 原始数组
    private int[] originArr;

    // 前缀和
    private int[] preSum;

    // 树状数组
    private int[] treeArr;

    public TreeArr(int[] originArr) {
        this.originArr = originArr;
        preSum = new int[originArr.length];

        // 计算前缀和
        preSum[0] = originArr[0];
        for (int i = 1; i < originArr.length; i++) {
            preSum[i] = originArr[i] + preSum[i - 1];
        }

        // 初始化树状数组
        treeArr = new int[originArr.length + 1];
        initTreeArr();

    }

    // 向上建树
    private void initTreeArr() {
        for (int i = 0; i < originArr.length; i++) {
            int index = i + 1;
            treeArr[index] += originArr[i];
            int upIndex = index + lowbit(index);
            if (upIndex <= originArr.length) {
                treeArr[upIndex] += treeArr[index];
            }
        }
    }

    // 使用前缀和进行建树
    private void initTreeArrByPreSum(){
        for (int i = 0; i < originArr.length; i++) {
            int index = i+1;
            treeArr[index] = preSum[i];
            int downIndex = index - lowbit(index);
            if (downIndex!=0){
                treeArr[index] -= preSum[downIndex-1];
            }
        }
    }


    // 单点修改,将某个节点的值进行添加
    private void addNodeValue(int index,int value){
        int treeArrIndex = index+1;
        treeArr[index]+=value;
        int curIndex = treeArrIndex;
        while (curIndex<treeArr.length){
            curIndex+=lowbit(curIndex);
            treeArr[curIndex]+=value;
        }
    }

    // 查询区间和
    private int querySectionSum(int left,int right){
        int treeArrLeftIndex = left+1;
        int treeArrRightIndex = right+1;
        return querySum(treeArrRightIndex)-querySum(treeArrLeftIndex-1);
    }

    private int querySum(int index){
        int treeArrIndex = index+1;
        int sum = treeArr[treeArrIndex];
        int curIndex = treeArrIndex;
        while (curIndex!=0){
            curIndex = curIndex - lowbit(curIndex);
            sum+=treeArr[curIndex];
        }

        return sum;
    }


    private int lowbit(int x) {
        return x & -x;
    }


    public static void main(String[] args) {
        int[] testArr = {1,3,4,7,5,9,12,6};
        TreeArr t = new TreeArr(testArr);
        System.out.println(Arrays.toString(t.treeArr));

    }


}
