package zyj.yihong.leetcode.simple.arr;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome409 {
    public static int longestPalindrome(String s) {
        // 使用贪心的策略，如果字符出现次数为双数，那么都可以添加，如果单数，此时的结果为双数
        // 则单数都可添加，如果此时结果为单数，那么可添加的数量为 num-1;
        // 小写字母97  大写字母为65

        int[] alphabetCountArr = new int[52];

        // 统计数字
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (c>=97){
                c= c-'a'+26;
            }else {
                c = c-'A';
            }

            alphabetCountArr[c]++;
        }

        int ans = 0;

        for (int i = 0; i < alphabetCountArr.length; i++) {
            int curCount = alphabetCountArr[i];
            if (curCount==0){
                continue;
            }
            ans += (curCount/2)*2;

            if ((ans&1)==0&&(curCount&1)!=0){
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        int i = longestPalindrome(s);
        System.out.println(i);
    }
}
