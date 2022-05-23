package zyj.yihong.leetcode.mid.String;


/**
 * 647. 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSubstrings647 {
    public int countSubstrings(String s) {
        // 中心扩张
        int ans = 0;
        int length = s.length();
        for (int i = 0; i < 2 * length - 1; i++) {
            // 计算起始点：left\right
            int left = i/2;
            int right = i/2+i%2;
            while (left>=0&&right<length&&s.charAt(left)==s.charAt(right)){
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
