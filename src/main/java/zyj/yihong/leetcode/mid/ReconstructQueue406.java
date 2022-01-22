package zyj.yihong.leetcode.mid;

import java.util.Arrays;

/**
 * 根据身高重建队列：
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 */
public class ReconstructQueue406 {
    /**
     * 排序+插队的方式
     * @param people 给定二维数组
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {

        //排序 根据p[i][0] 降序 p[i][1] 升序
        Arrays.sort(people,(i1,i2)->{
            if (i1[0]!=i2[0]){
                return i2[0]-i1[0];
            }else {
                return i1[1]-i2[1];
            }
        });

        // 将当前数据插入到适合的位置
        for (int i = 1; i < people.length; i++) {
            int curIndex = people[i][1];
            if (curIndex<i){
                int[] temp = people[i];
                int tempIndex = i;
                while(tempIndex>curIndex){
                    people[tempIndex] = people[tempIndex-1];
                    tempIndex--;
                }
                people[curIndex] = temp;
            }
        }

        return people;
    }

    public static void main(String[] args) {
//        [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
        int[][] test = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        test = reconstructQueue(test);
        for (int[] ints : test) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
