package zyj.yihong.leetcode.simple.brain;

/**
 * 给你两个字符串 a 和 b，请返回 这两个字符串中 最长的特殊序列  的长度。如果不存在，则返回 -1 。
 *
 * 「最长特殊序列」 定义如下：该序列为 某字符串独有的最长子序列（即不能是其他字符串的子序列） 。
 */
public class FindLUSlength521 {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)){
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
