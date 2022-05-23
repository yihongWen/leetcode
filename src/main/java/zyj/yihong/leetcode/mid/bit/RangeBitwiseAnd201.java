package zyj.yihong.leetcode.mid.bit;

/**
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 *  201. 数字范围按位与
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/bitwise-and-of-numbers-range
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RangeBitwiseAnd201 {
    public int rangeBitwiseAnd(int left, int right) {
        // 公共前缀
        while (left<right){
            right = right&right-1;
        }
        return right;
    }
}
