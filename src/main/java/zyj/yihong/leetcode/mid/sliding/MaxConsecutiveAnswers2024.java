package zyj.yihong.leetcode.mid.sliding;

/**
 * 2024. 考试的最大困扰度
 * 一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
 *
 * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
 *
 * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
 * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxConsecutiveAnswers2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int tMax = maxConsecutiveAnswers(answerKey, k, 'T');
        int fMax = maxConsecutiveAnswers(answerKey, k, 'F');
        return Math.max(tMax,fMax);
    }


    public int maxConsecutiveAnswers(String answerKey, int k,char calChar) {
        // 使用双指针，计算出右端点的位置，当使用可K次不满足的情况时左端点向右边移动
        int curUseNum = 0;
        int curMaxLength = 0;
        int left = 0;
        int right = 0;

        for (; right < answerKey.length(); right++) {
            char c = answerKey.charAt(right);
            if (c!=calChar){
                curUseNum++;
            }
            while (curUseNum>k){
                char c1 = answerKey.charAt(left);
                if (c1!=calChar){
                    curUseNum--;
                }
                left++;
            }
            curMaxLength = Math.max(right-left+1,curMaxLength);
        }
        return curMaxLength;
    }

}
