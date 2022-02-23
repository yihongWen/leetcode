package zyj.yihong.leetcode.mid.sort;

import java.util.Arrays;

/**
 * 在一条单行道上，有 n 辆车开往同一目的地。目的地是几英里以外的 target 。
 *
 * 给定两个整数数组 position 和 speed ，长度都是 n ，其中 position[i] 是第 i 辆车的位置， speed[i] 是第 i 辆车的速度(单位是英里/小时)。
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车 以相同的速度 紧接着行驶。此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * 返回到达目的地的 车队数量 。
 */
public class CarFleet853 {

    /**
     * 由于不会超过前面的车，所以先根据目标位置排序，判断后一个到达target跟前一个到达target的时间关系
     * 去判断是否是同一个车队
     * @param target
     * @param position
     * @param speed
     * @return
     */
    public static int carFleet(int target, int[] position, int[] speed) {
        int retFleetCount = 0;

        // 构造二元数组
        int[][] carInfo = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            carInfo[i][0] = position[i];
            carInfo[i][1] = speed[i];
        }

        // 排序
        Arrays.sort(carInfo,(o1,o2)-> o2[0]-o1[0]);

        double v1 = -1;
        for (int i = 0; i < carInfo.length; i++) {
            double v =  ((double)(target - carInfo[i][0]) / carInfo[i][1]);
            if (v>v1) {
                retFleetCount++;
                v1 = v;
            }
        }
        return retFleetCount;

    }

    public static void main(String[] args) {
        int target = 10;
        int[] position = {0,4,2};
        int[] speed = {2,1,3};
        int i = carFleet(target, position, speed);
        System.out.println(i);
    }
}
