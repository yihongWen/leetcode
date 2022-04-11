package zyj.yihong.leetcode.week.w288;

/**
 * 6037. 按奇偶性交换后的最大数字
 */
public class LargestInteger6037 {
    public static int largestInteger(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                if ((chars[j]-chars[i])%2==0&&chars[j]>chars[i]){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }

        return Integer.parseInt(String.valueOf(chars));
    }

    public static void main(String[] args) {
        int i = largestInteger(247);
        System.out.println(i);
    }
}
