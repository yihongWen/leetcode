package zyj.yihong.leetcode.mid.sliding;

public class LongestSubstring395 {


    /**
     * 枚举+双指针
     * @param s
     * @param k
     * @return
     */
    public static int longestSubstring(String s, int k) {
        int maxLength = Integer.MIN_VALUE;

        // 枚举子串所有可能出现的结果
        for (int count = 1; count <= 26; count++) {
            // 定义左右 指针、每个字母出现的个数、未满足k的字母个数
            int left = 0;
            int right = 0;
            int[] alphabetCount = new int[26];
            int countOfLessK = 0;
            int countInCur = 0;

            // 右指针往前
            while (right<s.length()){
                int rightIndex = s.charAt(right) - 'a';
                alphabetCount[rightIndex]++;

                // 第一次出现
                if (alphabetCount[rightIndex]==1){
                    countInCur++;
                    countOfLessK++;
                }

                // 判断是否小于k
                if (alphabetCount[rightIndex]==k){
                    countOfLessK--;
                }

                // 判断当前子串中的字母个数跟遍历个数的关系,左指针移动的过程
                while(countInCur>count){
                    int leftIndex = s.charAt(left) - 'a';
                    alphabetCount[leftIndex]--;
                    if (alphabetCount[leftIndex]==k-1){
                        countOfLessK++;
                    }
                    if (alphabetCount[leftIndex]==0){
                        countInCur--;
                        countOfLessK--;
                    }
                    left++;
                }

                //如果此时countInCur==count,并且里面的字母的数量全部大于k 则比较当前结果
                if (countOfLessK==0) {
                    maxLength = Math.max(maxLength, right - left + 1);
                }

                // 右指针移动
                right++;
            }
        }
        return maxLength;

    }




    public static void main(String[] args) {
        String s = "ababbcc";
        int k = 2;
        int i = longestSubstring(s, k);
        System.out.println(i);
    }
}
