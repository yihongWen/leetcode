package zyj.yihong.leetcode.hard.tree;

/**
 * 440. 字典序的第K小数字
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 */
public class FindKthNumber440 {
    public  int findKthNumber(int n, int k) {
        int curNode = 1;

        // 从节点1-到节点9依次遍历，每个节点所包含的个数，
        // 如果个数超过可K,那么此时，找到当前节点下子树中的具体节点返回
        while (k>1){
            int count = calCountOfCurTree(curNode, n);
            // 当前节点的子树的节点树少时，选择下一个节点树
            if (k>count){
                k = k-count;
                curNode++;
            }else {
                // 如果当前子树的节点数多时，从左节点依次找
                curNode = curNode*10;
                k--;
            }
        }

        return curNode;
    }

    /**
     * 计算当前节点为根节点的的子树所包含节点的个数
     * @param head
     * @param n
     * @return
     */
    public  int calCountOfCurTree(int head, long n) {
        int count = 0;
        long curMin = head;
        long curMax = head;
        // 循环计算每一层的个数
        while(curMin<=n){
            long curLevelCount = Math.min(curMax, n) - curMin + 1;
            count = (int)(count+curLevelCount);

            // 计算下一层的最小值，最大值
            curMin = curMin*10;
            curMax = curMax*10+9;
        }

        return count;
    }

    public static void main(String[] args) {
//        int kthNumber = findKthNumber(127, 46);
//        System.out.println(kthNumber);
    }

}
