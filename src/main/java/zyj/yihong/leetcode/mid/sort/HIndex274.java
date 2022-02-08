package zyj.yihong.leetcode.mid.sort;

import java.util.Arrays;

/**
 * h指数：
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * 指数的定义：h 代表“高引用次数”，一名科研人员的 h指数是指他（她）的 （n 篇论文中）有 h 篇论文分别被引用了至少 h 次。
 */
public class HIndex274 {

    /**
     * 排序+倒序遍历
     * @param citations
     * @return
     */
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i]>h){
                h++;
            }else {
                return h;
            }
        }
        return h;
    }


    /**
     * 计数排序
     * @param citations
     * @return
     */
    public static int hIndex2(int[] citations) {
        int[] countingArr = new int[citations.length];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i]>= citations.length){
                countingArr[countingArr.length-1]++;
                continue;
            }
            if (citations[i]==0){
                continue;
            }
            countingArr[citations[i]-1]++;
        }

        int count = 0;
        for (int i = countingArr.length - 1; i >= 0; i--) {
            count += countingArr[i];
            if (count>=i+1){
                return i+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] testArr =  {3,0,6,1,5};
        int hIndex2 = hIndex2(testArr);
        System.out.println(hIndex2);
    }
}
