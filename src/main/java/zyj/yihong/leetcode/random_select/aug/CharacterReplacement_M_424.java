package zyj.yihong.leetcode.random_select.aug;

// 424. 替换后的最长重复字符
public class CharacterReplacement_M_424 {
    public static int characterReplacement(String s, int k) {
        //滑动窗口 枚举右端点
        int[] arr = new int[26];
        int left = 0;
        int right = 0;
        int maxCount = 0;

        while (right<s.length()){
            int index = s.charAt(right) - 'A';
            arr[index]++;
            maxCount = Math.max(maxCount,arr[index]);

            // 右移动不满足时，左端点往右边移动
            if (right-left+1-maxCount>k){
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right-left;
    }

    public static void main(String[] args) {
        int length = characterReplacement("AABABBA", 1);
        System.out.println(length);
    }
}
