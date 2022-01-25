package zyj.yihong.leetcode.simple;

public class IsPalindrome125 {
    /**
     * 验证s是否是回文串（数字和字母）
     * 使用双指针的形式
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s==null || s.length()==0){
            return false;
        }
        int start = 0;
        int end = s.length()-1;

        for (; start < end; ) {
            char startCharAscii = s.charAt(start);
            char endCharAscii = s.charAt(end);

            while(!((startCharAscii>=97 && startCharAscii<=122)
                    || (startCharAscii>=65 && startCharAscii<=90)
                    || (startCharAscii>=48 && startCharAscii<=57)) && start<end){
                start++;
                startCharAscii = s.charAt(start);
            }


            while(!((endCharAscii>=97 && endCharAscii<=122)
                    || (endCharAscii>=65 && endCharAscii<=90)
                    || (endCharAscii>=48 && endCharAscii<=57)) && end>start){
                end--;
                endCharAscii = s.charAt(end);
            }

            if (Character.toUpperCase(startCharAscii)==Character.toUpperCase(endCharAscii)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = ".,";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }
}
