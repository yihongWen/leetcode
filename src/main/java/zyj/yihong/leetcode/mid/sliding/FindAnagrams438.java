package zyj.yihong.leetcode.mid.sliding;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class FindAnagrams438 {

    // 仅仅只包含小写字母
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length()<p.length()){
            return ans;
        }
        int pLen = p.length();
        int[] curExistCount = new int[26];

        for (int i = 0; i < pLen; i++) {
            char curPChar = p.charAt(i);
            char curSChar = s.charAt(i);
            curExistCount[curPChar-'a']--;
            curExistCount[curSChar-'a']++;
        }

        // 判断当前的结果是否满足
        int diff = 0;
        for (int i = 0; i < curExistCount.length; i++) {
            if (curExistCount[i]!=0){
                diff++;
            }
        }

        if (diff==0){
            ans.add(0);
        }
        // 当前的left = 0,right = pLen-1.使用滑动窗口进行遍历
        int left = 0;
        int right = pLen;
        while (right < s.length()) {

            // 新添加一个值时，left先往右边移动，挤出一个位置
            int leftIndex = s.charAt(left) - 'a';
            int curLeftCount = curExistCount[leftIndex];
            if (curLeftCount==0){
                diff++;
            }else if (curLeftCount==1){
                // s中多出一个值，此时移走了，差异减1
                diff--;
            }

            curExistCount[leftIndex]-=1;

            // 右边移动加入元素
            int rightIndex = s.charAt(right)-'a';
            int curRightCount = curExistCount[rightIndex];
            if (curRightCount==-1){
                diff--;
            }else if (curRightCount==0){
                diff++;
            }

            curExistCount[rightIndex]+=1;

            if (diff==0){
                ans.add(left+1);
            }

            right++;
            left++;

        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }

}
