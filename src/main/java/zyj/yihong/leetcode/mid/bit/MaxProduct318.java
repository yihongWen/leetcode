package zyj.yihong.leetcode.mid.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 318. 最大单词长度乘积
 * 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProduct318 {
    public int maxProduct(String[] words) {
        // 使用bit表示每个单词出现的字母位置，相同保留长度最长的即可
        Map<Integer,Integer> bitWordLengthMap = new HashMap<>();

        // 结果
        int ans = 0;

        // 就算每个相同bit表示且长度最长的word
        for (String word : words) {
            int bitNum = 0;
            int curWordLength = word.length();
            for (int j = 0; j < word.length(); j++) {
                int index = word.charAt(j) - 'a';
                bitNum = bitNum | (1 << index);
            }
            Integer existLength = bitWordLengthMap.getOrDefault(bitNum, -1);
            if (curWordLength > existLength) {
                bitWordLengthMap.put(bitNum, curWordLength);
            }
        }
        for (Integer num1 : bitWordLengthMap.keySet()) {
            for (Integer num2 : bitWordLengthMap.keySet()) {
                if ((num1&num2)==0){
                    ans = Math.max(ans,bitWordLengthMap.get(num1)*bitWordLengthMap.get(num2));
                }
            }
        }

        return ans;
    }
}
