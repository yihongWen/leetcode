package zyj.yihong.leetcode.mid.sliding;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDuplicate287 {

    /**
     * 问题转化：floyd判圈、转化成环形链表的相交点
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (fast!=slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = nums[0];
        fast = nums[fast];
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        int duplicate = findDuplicate(arr);
        System.out.println(duplicate);

    }
}
