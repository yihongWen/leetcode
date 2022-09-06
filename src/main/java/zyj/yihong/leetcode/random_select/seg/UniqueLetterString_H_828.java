package zyj.yihong.leetcode.random_select.seg;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 828. 统计子串中的唯一字符
public class UniqueLetterString_H_828 {
    public static int uniqueLetterString(String s) {
        // 统计每个字符出现的index
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                List<Integer> indexList = map.get(c);
                indexList.add(i);
            }else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(-1);
                indexList.add(i);
                map.put(c,indexList);
            }
        }

        int ans = 0;

        // 计算某个字符在子串中的唯一字符树
        for (Map.Entry<Character, List<Integer>> curEntry : map.entrySet()) {
            // 添加边界值
            List<Integer> curIndexList = curEntry.getValue();
            curIndexList.add(s.length());
            for (int i = 1; i < curIndexList.size()-1; i++) {
                Integer prevIndex = curIndexList.get(i - 1);
                Integer nextIndex = curIndexList.get(i + 1);
                Integer curIndex = curIndexList.get(i);
                ans += (curIndex-prevIndex)*(nextIndex-curIndex);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String abc = "ABC";
        int i = uniqueLetterString(abc);
        System.out.println(i);
    }
}
