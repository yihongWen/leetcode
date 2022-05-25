package zyj.yihong.leetcode.mid.arr;

/**
 * 467. 环绕字符串中唯一的子字符串
 * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
 *
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." . 
 * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/unique-substrings-in-wraparound-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubstringInWraproundString467 {

    public int findSubstringInWraproundString(String p) {
        // 计算每个字符的最大长度，然后就是一个顺序排列的的个数
        int[] alphabetLengthArr = new int[26];
        int curLength = 1;
        alphabetLengthArr[p.charAt(0)-'a']=1;
        for (int i = 1; i < p.length(); i++) {
            char curChar = p.charAt(i);
            char preChar = p.charAt(i - 1);
            // 处理最后一位za的关系，出现-25+26；
            if ((curChar-preChar+26)%26==1){
                curLength++;
            }else {
                curLength=1;
            }

            // 判断当前字符结尾的长度是否是当前最长
            alphabetLengthArr[curChar-'a'] = Math.max(alphabetLengthArr[curChar-'a'],curLength);
        }

        // 累计结果
        int ans = 0;
        for (int i : alphabetLengthArr) {
            ans+=i;
        }

        return ans;
    }
}
