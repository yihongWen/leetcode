package zyj.yihong.leetcode.simple.binary;

/**
 * 868. 二进制间距
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 *
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryGap868 {
    public int binaryGap(int n) {
        int preOneIndex;
        int curOneIndex = 32;
        int ans = 0;

        for (int i = 0; i <= 32; i++) {
            if ((n&1)==1){
                preOneIndex = curOneIndex;
                curOneIndex = i;
                ans = Math.max(ans,curOneIndex-preOneIndex);
            }
            n = n>>1;
        }
        return ans;
    }
}
