package zyj.yihong.leetcode.mid.bisection;

/**
 * 2226. 每个小孩最多能分到多少糖果
 * 给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆 ，但 无法 再将两堆合并到一起。
 *
 * 另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。
 *
 * 返回每个小孩可以拿走的 最大糖果数目 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-candies-allocated-to-k-children
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumCandies2226 {

    public int maximumCandies(int[] candies, long k) {
        // 使用二分法
        long total = 0;
        for (int i = 0; i < candies.length; i++) {
            total+= candies[i];
        }

        if (k>total){
            return 0;
        }
        long left = 1;
        long right = total;
        while (left<=right){
            long mid = (left + right) / 2;
            if (canAllocation(candies,k,mid)){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return (int)left-1;
    }

    // 判断是否能分配count个
    private boolean canAllocation(int[] candies,long k,long count){
        for (int candy : candies) {
            if (candy<count){
                continue;
            }else{
                k = k-candy/count;
            }
        }
        return k<=0;
    }

    public static void main(String[] args) {
        MaximumCandies2226 maximumCandies2226 = new MaximumCandies2226();
        int[] arr = {5,6,8};
        int candies = maximumCandies2226.maximumCandies(arr, 3);
        System.out.println(candies);
    }
}
