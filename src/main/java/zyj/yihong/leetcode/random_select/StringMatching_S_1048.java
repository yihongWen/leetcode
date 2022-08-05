package zyj.yihong.leetcode.random_select;

import java.util.ArrayList;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配
 */
public class StringMatching_S_1048 {
    public List<String> stringMatching(String[] words) {
        // 查询字符，可以使用字典树去查询，这里直接选择暴力枚举
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i!=j&&words[j].contains(words[i])){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
