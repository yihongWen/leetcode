package zyj.yihong.leetcode.random_select.dec;

// 1684. 统计一致字符串的数目
public class CountConsistentStrings_S_1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] arr = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            arr[allowed.charAt(i) - 'a'] = true;
        }

        int ans = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!arr[word.charAt(i) - 'a']) {
                    break;
                }
                if (i==word.length()-1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
