package zyj.yihong.leetcode.mid.sliding;


/**
 * 1763. 最长的美好子字符串
 * 当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，因为 'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。
 *
 * 给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。
 */
public class LongestNiceSubstring1763 {


    /**
     * 枚举+双指针
     * @param s
     * @return
     */
    public String longestNiceSubstring(String s) {
        int bestLeft = 0;
        int bestRight = 0;

        // 计算字符串的种类数，使用位运算进行标记（0-26位进行标记）
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int position = Character.toLowerCase(s.charAt(i)) - 'a';
            count = count | (1<<position);
        }
        count = Integer.bitCount(count);

        // 枚举
        for (int curCount = 1; curCount <= count ; curCount++) {
            // 定义左右指针、当前字母出现的个数、当前左右指针包含的字符个数
            int left = 0;
            int right = 0;
            int[] upperCount = new int[26];
            int[] lowerCount = new int[26];
            int countOfSubString = 0;
            int niceCount = 0;

            // 双指针
            while (right<s.length()){
                char c = s.charAt(right);
                int index = Character.toLowerCase(s.charAt(right))-'a';
                if (Character.isUpperCase(c)){
                    upperCount[index]++;
                    // 是否是美好字符
                    if (upperCount[index]==1&&lowerCount[index]>0){
                        niceCount++;
                    }
                }else {
                    lowerCount[index]++;
                    if (lowerCount[index]==1 && upperCount[index]>0){
                        niceCount++;
                    }
                }

                countOfSubString=countOfSubString+ (lowerCount[index]+upperCount[index]==1?1:0);


                // 不满足左指针移动
                while (countOfSubString>curCount){
                    char c1 = s.charAt(left);
                    int leftIndex = Character.toLowerCase(s.charAt(left)) - 'a';
                    countOfSubString-= lowerCount[leftIndex]+upperCount[leftIndex]==1?1:0;
                    if (Character.isUpperCase(c1)){
                        upperCount[leftIndex]--;
                        if (upperCount[leftIndex]==0 && lowerCount[leftIndex]>0){
                            niceCount--;
                        }
                    }else {
                        lowerCount[leftIndex]--;
                        if (lowerCount[leftIndex]==0 && upperCount[leftIndex]>0){
                            niceCount--;
                        }
                    }
                    left++;
                }


                if (niceCount==curCount && (bestRight-bestLeft+1)<(right-left+1)){
                    bestLeft = left;
                    bestRight = right;
                }
                right++;
            }
        }
        if (bestLeft!=bestRight) {
            return s.substring(bestLeft, bestRight + 1);
        }
        return "";
    }

    public static void main(String[] args) {
        LongestNiceSubstring1763 longestNiceSubstring1763 = new LongestNiceSubstring1763();
        String yazaAay = longestNiceSubstring1763.longestNiceSubstring("YazaAay");
        System.out.println(yazaAay);

    }

}
