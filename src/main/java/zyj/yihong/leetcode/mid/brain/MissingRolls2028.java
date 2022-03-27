package zyj.yihong.leetcode.mid.brain;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 2028. 找出缺失的观测数据
 * 现有一份 n + m 次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。观测数据中缺失了 n 份，你手上只拿到剩余 m 次投掷的数据。幸好你有之前计算过的这 n + m 次投掷数据的 平均值 。
 *
 * 给你一个长度为 m 的整数数组 rolls ，其中 rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。
 *
 * 返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。如果存在多组符合要求的答案，只需要返回其中任意一组即可。如果不存在答案，返回一个空数组。
 *
 * k 个数字的 平均值 为这些数字求和后再除以 k 。
 *
 * 注意 mean 是一个整数，所以 n + m 次投掷的总和需要被 n + m 整除。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-missing-observations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MissingRolls2028 {

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        // 计算总数、以及剩下n个数据的总数
        int sum = (n+rolls.length)*mean;
        int sumOfRolls = 0;
        for (int i = 0; i < rolls.length ; i++) {
            sumOfRolls += rolls[i];
        }
        int sumOfN = sum - sumOfRolls;

        // 存在有超过6的情况，直接返回空数组
        if (sumOfN<0 || sumOfN>6*n || sumOfN<n){
            return new int[0];
        }

        // 计算结果
        int average = sumOfN / n;
        int remind= sumOfN % n;
        int[] result = new int[n];
        Arrays.fill(result,average);

        for (int i = 0; i < remind; i++) {
            result[i]++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3};
        int mean = 2;
        int n = 53;
        int[] ints = missingRolls(arr, mean, n);
        System.out.println(Arrays.toString(ints));
    }
}
