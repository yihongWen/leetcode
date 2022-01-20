package zyj.yihong.leetcode.mid;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 */
public class CanCompleteCircuit134 {

    /**
     * 如果从点x能到达y,但是不能到达y+1,那么x到y中的任何点也是不能到达y+1
     * 此时只需要从index = 0开始遍历，如果不能到达y+1,那么就从不能到达的点开始，遍历，直到遍历完数组
     *
     * （也可以使用暴力方法，这样算法的复杂度将会高出一个量级）
     * @param gas 汽油容量
     * @param cost 消耗
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int curIndex = 0;
        while(curIndex<length){
            // 当前点curIndex,能够走的步数、汽油、消耗的总数
            int curStep = 0, sumGas = 0,sumCost = 0;

            // 计算curStep,如果curStep = length-1,证明已经能够走一圈了。
            while(curStep<length){
                // 计算sumGas
                sumGas += gas[(curIndex+curStep)%length];
                sumCost += cost[(curIndex+curStep)%length];
                // 无法到达的情况，退出循环
                if (sumCost>sumGas){
                    break;
                }
                curStep++;
            }

            // 判断当前curIndex 能否满足条件
            if (curStep==length){
                return curIndex;
            }

            // 跳跃到下一个不满足的节点开始
            curIndex = curIndex+curStep+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas  = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int arriveIndex = canCompleteCircuit(gas, cost);
        System.out.println(arriveIndex);
    }
}
