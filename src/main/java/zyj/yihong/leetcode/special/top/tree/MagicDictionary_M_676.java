package zyj.yihong.leetcode.special.top.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 676. 实现一个魔法字典
 */
public class MagicDictionary_M_676 {

    // 使用map存储相同长度的word
    Map<Integer, List<String>> lengthWordListMap;

    public MagicDictionary_M_676() {
        lengthWordListMap = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        lengthWordListMap.clear();
        for (String word : dictionary) {
            if (!lengthWordListMap.containsKey(word.length())){
                lengthWordListMap.put(word.length(),new ArrayList<>());
            }
            lengthWordListMap.get(word.length()).add(word);
        }
    }

    public boolean search(String searchWord) {
        if (!lengthWordListMap.containsKey(searchWord.length())){
            return false;
        }
        List<String> words = lengthWordListMap.get(searchWord.length());
        for (String word : words) {
            int diff = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i)!=searchWord.charAt(i)){
                    diff++;
                }

                if (diff>1){
                    break;
                }
            }
            if (diff==1){
                return true;
            }
        }

        return false;
    }

}
