package zyj.yihong.leetcode.week.w288;

/**
 * 6038. 向表达式添加括号后的最小结果
 * 给你一个下标从 0 开始的字符串 expression ，格式为 "<num1>+<num2>" ，其中 <num1> 和 <num2> 表示正整数。
 * <p>
 * 请你向 expression 中添加一对括号，使得在添加之后， expression 仍然是一个有效的数学表达式，并且计算后可以得到 最小 可能值。左括号 必须 添加在 '+' 的左侧，而右括号必须添加在 '+' 的右侧。
 * <p>
 * 返回添加一对括号后形成的表达式 expression ，且满足 expression 计算得到 最小 可能值。如果存在多个答案都能产生相同结果，返回任意一个答案。
 * <p>
 * 生成的输入满足：expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimize-result-by-adding-parentheses-to-expression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimizeResult6038 {
    public static String minimizeResult(String expression) {
        int splitIndex = expression.indexOf("+");

        // 遍历每个位置的结果
        int curAns = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < splitIndex; i++) {
            for (int j = splitIndex + 1; j < expression.length(); j++) {
                String leftString = expression.substring(0, i);
                String midString = expression.substring(i, j+1);
                String rightString = expression.substring(j + 1);

                // 计算大小
                int left = 1;
                int right = 1;
                if (leftString.length()!=0){
                    left = Integer.parseInt(leftString);
                }
                if (rightString.length()!=0){
                    right = Integer.parseInt(rightString);
                }

                String[] split = midString.split("\\+");
                int cal = left * (Integer.parseInt(split[0]) + Integer.parseInt(split[1])) * right;
                if (cal<curAns){
                    curAns = cal;
                    ans = leftString+"("+midString+")"+rightString;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = minimizeResult("247+38");
        System.out.println(s);
    }
}
