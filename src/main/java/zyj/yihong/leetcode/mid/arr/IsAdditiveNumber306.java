package zyj.yihong.leetcode.mid.arr;

/**
 * 306. 累加数
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。
 *
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 *
 * 说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsAdditiveNumber306 {
    public static boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length() - 1; i++) {
            // 特殊情况处理：如果第一为为0，那么第二位的开始的坐标只能为1
            if (num.charAt(0)=='0'&&i!=1){
                break;
            }

            for (int j = i; j < num.length()-1; j++) {
                // 如果第二位的起点为0
                if (num.charAt(i)=='0'&&j!=i){
                    break;
                }
                if (dfs(num,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(String num,int secondStart,int secondEnd){
        // 已知当前a+b中b的索引，此时a为0-b(start-1),计算a+b的结果，推算出下一位
        // 如果满足，则往前进一位
        int firstStart = 0;
        int firstEnd = secondStart-1;
        while (secondEnd<num.length()) {
            String third = add(num, firstStart, firstEnd, secondStart, secondEnd);
            if (secondEnd + third.length() >= num.length() || !third.equals(num.substring(secondEnd + 1, secondEnd +1+ third.length()))) {
                return false;
            }

            // 如果当前到了最后一位,返回true
            if (third.length() + secondEnd == num.length() - 1) {
                return true;
            }

            // 否则往前走一位
            firstStart = secondStart;
            firstEnd = secondEnd;
            secondStart = secondEnd + 1;
            secondEnd = secondEnd + third.length();
        }

        return false;
    }


    // 两个字符串 进行数字相加
    public static String add(String num,int firstStart,int firstEnd,int secondStart,int secondEnd){
        StringBuilder ans = new StringBuilder();

        // 知道最后一个较长的字符串遍历完成
        int carryBit = 0;
        while (firstEnd>=firstStart||secondEnd>=secondStart){
            int curAns = carryBit;
            if (firstEnd>=firstStart){
                curAns = num.charAt(firstEnd)-'0'+curAns;
                firstEnd--;
            }

            if (secondEnd>=secondStart){
                curAns = num.charAt(secondEnd)-'0'+curAns;
                secondEnd--;
            }

            // 判断是否产生进位
            carryBit = curAns/10;
            ans.insert(0,curAns%10);
        }

        // 如果最后产生进位
        if (carryBit==1){
            ans.insert(0,carryBit);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "111";
        Boolean add = IsAdditiveNumber306.isAdditiveNumber(s);
        System.out.println(add);
    }
}
