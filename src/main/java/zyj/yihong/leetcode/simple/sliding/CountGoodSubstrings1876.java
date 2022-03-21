package zyj.yihong.leetcode.simple.sliding;

/**
 * 1876. 长度为三且各字符不同的子字符串
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
 *
 * 给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。
 *
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 *
 * 子字符串 是一个字符串中连续的字符序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substrings-of-size-three-with-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountGoodSubstrings1876 {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length()-2; i++) {
            if (s.charAt(i)!=s.charAt(i+1) && s.charAt(i)!= s.charAt(i+2) && s.charAt(i+1)!=s.charAt(i+2)){
                count++;
            }
        }
        return count;
    }
}
