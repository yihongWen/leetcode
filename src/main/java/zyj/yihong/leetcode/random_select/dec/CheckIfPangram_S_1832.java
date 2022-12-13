package zyj.yihong.leetcode.random_select.dec;

// 1832. 判断句子是否为全字母句
public class CheckIfPangram_S_1832 {
    public boolean checkIfPangram(String sentence) {
        boolean[] arr =new boolean[26];
        int count = 26;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (!arr[c-'a']){
                arr[c-'a'] = true;
                count--;
                if (count==0){
                    return true;
                }
            }
        }
        return false;
    }
}
