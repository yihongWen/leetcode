package zyj.yihong.leetcode.special.top.prefix_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1395. 统计作战单位数
 *  n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 * <p>
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 * <p>
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 */
public class NumTeams_M_1395 {
    // 直接使用暴力进行枚举
    public int numTeams(int[] rating) {
        int ans = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    int valueI = rating[i];
                    int valueJ = rating[j];
                    int valueK = rating[k];
                    if ((valueI > valueJ && valueJ > valueK) || (valueI < valueJ && valueJ < valueK)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }


    public int numTeams2(int[] rating) {
        // 将暴力枚举进行改进，枚举中间值
        int ans = 0;
        for (int j = 1; j < rating.length - 1; j++) {
            // 计算左边的结果
            int leftLt = 0;
            int leftGt = 0;
            int rightGt = 0;
            int rightLt = 0;
            int curValue = rating[j];
            for (int i = 0; i < j; i++) {
                if (rating[i] > curValue) {
                    leftGt++;
                } else if (rating[i] < curValue) {
                    leftLt++;
                }
            }

            // 计算右边的结果
            for (int k = j + 1; k < rating.length; k++) {
                if (rating[k] > curValue) {
                    rightGt++;
                } else if (rating[k] < curValue) {
                    rightLt++;
                }
            }

            // 计算当前中间节点的结果
            ans += leftLt * rightGt + leftGt * rightLt;
        }

        return ans;
    }


    public static int numTeams3(int[] rating) {
        // 对于枚举中间节点，需要计算当前中间节点左侧跟右侧数据，来计算当前结果，然后当前中间节点
        // 在往后移动，此时前面跟后面存在一大部分数据已经重复计算过，使用两次树状数组，分别统计左侧跟右侧的数据
        // 由于分数的值数据相差较大，而实际的数据量小，可以优化空间

        // 树状数组的长度 树状数组从1开始，在多加一位是为了离散化处理
        int treeArrLength = rating.length+1;
        TreeArr treeArr = new TreeArr(treeArrLength);

        // 离散化处理
        List<Integer> disc = new ArrayList<>();
        for (int i = 0; i < rating.length; ++i) {
            disc.add(rating[i]);
        }
        disc.add(-1);
        Collections.sort(disc);

        int[] iLess = new int[rating.length];
        int[] iMore = new int[rating.length];
        int[] kLess = new int[rating.length];
        int[] kMore = new int[rating.length];

        for (int i = 0; i < rating.length; ++i) {
            int index = getId(rating[i],disc);
            iLess[i] = treeArr.get(index);
            iMore[i] = treeArr.get(rating.length) - treeArr.get(index);
            treeArr.add(index, 1);
        }

        // 处理右侧，需要清空，并且从右往左
        treeArr.reset();
        for (int i = rating.length - 1; i >= 0; --i) {
            int id = getId(rating[i],disc);
            kLess[i] = treeArr.get(id);
            kMore[i] = treeArr.get(rating.length) - treeArr.get(id);
            treeArr.add(id, 1);
        }

        int ans = 0;
        for (int i = 0; i < rating.length; ++i) {
            ans += iLess[i] * kMore[i] + iMore[i] * kLess[i];
        }

        return ans;

    }

    public static int getId(int target, List<Integer> disc) {
        int low = 0, high = disc.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (disc.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static class TreeArr{
        int[] treeArr;

        public TreeArr(int length) {
            this.treeArr = new int[length];
        }

        public void reset(){
            Arrays.fill(treeArr,0);
        }

        private int lowBit(int x){
            return x&(-x);
        }

        private void add(int index,int value){
            int curIndex = index;
            while (curIndex<treeArr.length) {
                treeArr[curIndex] += value;
                curIndex += lowBit(curIndex);
            }
        }

        public int get(int index){
            int ans = 0;
            int curIndex = index;
            while (curIndex > 0) {
                ans += treeArr[curIndex];
                curIndex -= lowBit(curIndex);
            }
            return ans;
        }
    }




    public static void main(String[] args) {
        int[] arr = {2,5,3,4,1};
        int i = numTeams3(arr);
        System.out.println(i);
    }
}
