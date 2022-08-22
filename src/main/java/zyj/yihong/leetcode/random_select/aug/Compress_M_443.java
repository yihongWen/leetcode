package zyj.yihong.leetcode.random_select.aug;

// 443. 压缩字符串
public class Compress_M_443 {
    public static int compress(char[] chars) {
        char curChar = chars[0];
        int curCharCount = 1;
        int ans = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == curChar) {
                curCharCount++;
                continue;
            }

            chars[ans] = curChar;
            ans++;
            if (curCharCount != 1) {
                String s = curCharCount + "";
                for (int j = 0; j < s.length(); j++) {
                    chars[ans] = s.charAt(j);
                    ans++;
                }
            }
            curChar = chars[i];
            curCharCount = 1;
        }

        chars[ans] = curChar;
        ans++;
        if (curCharCount != 1) {
            String s = curCharCount + "";
            for (int j = 0; j < s.length(); j++) {
                chars[ans] = s.charAt(j);
                ans++;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int compress = compress(arr);
        System.out.println(compress);
    }
}
