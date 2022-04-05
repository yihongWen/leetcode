package zyj.yihong.leetcode.simple.brain;

/**
 * 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * 在比较时，字母是依序循环出现的。举个例子：
 *
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreatestLetter744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0 ;
        int right = n-1;

        while (left<=right){
            int mid = (left + right) / 2;
            if (letters[mid]==target){
                if (mid+1<n&&letters[mid+1]==target){
                    left = mid+1;
                    continue;
                }
                return letters[(mid+1)%n];
            }else if (letters[mid]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        return letters[left%n];
    }

    public static void main(String[] args) {
        char[] arr = {'e','e','e','e','e','e','n','n','n','n'};
        char target = 'e';
        char c = nextGreatestLetter(arr, target);
        System.out.println(c);
    }
}
