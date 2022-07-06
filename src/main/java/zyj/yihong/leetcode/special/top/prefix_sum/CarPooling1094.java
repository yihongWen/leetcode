package zyj.yihong.leetcode.special.top.prefix_sum;

/**
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 *
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 *
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 105
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/car-pooling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CarPooling1094 {

    // 将实际问题抽象区间可变，单点查询问题（差分数组统计数据，前缀和计算单点是否满足）
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] diffArr = new int[1002];
        int[] prefixSum = new int[1002];

        for (int[] trip : trips) {
            int passenger = trip[0];
            int start = trip[1];
            int end = trip[2];
            diffArr[start+1]+=passenger;
            diffArr[end+1]-=passenger;
        }

        for (int i = 1; i < diffArr.length; i++) {
            prefixSum[i] = diffArr[i]+prefixSum[i-1];
            if (prefixSum[i]>capacity){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        [[9,0,1],[3,3,7]]
        int[][] trip = {{9,0,1},{3,5,7}};
        int capacity = 3;
        boolean b = carPooling(trip, capacity);
        System.out.println(b);
    }
}
