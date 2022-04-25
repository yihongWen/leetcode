package zyj.yihong.leetcode.mid.graph;

import java.util.Objects;

/**
 * 990. 等式方程的可满足性
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EquationsPossible990 {
    public boolean equationsPossible(String[] equations) {
        // 并查集
        // 初始化parent，将每个节点指向其自身
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // 根据==条件建立联通图
        for (String equation : equations) {
            if (Objects.equals(equation.charAt(1),'=')){
                union(parent,equation.charAt(0),equation.charAt(3));
            }
        }

        // 根据!=的情况，判断是否存在矛盾的情况
        for (String equation : equations) {
            // 两者不想等，证明两者的连通不在同一个根节点
            if (Objects.equals(equation.charAt(1),'!')){
                if (find(parent,equation.charAt(0))==find(parent,equation.charAt(3))){
                    return false;
                }
            }
        }
        return true;
    }


    public void union(int[] parent, int index1, int index2) {
        // 合并操作,index1指向index2
        // 将index1的父节点执行index2的根节点即可
        parent[find(parent,index1)] = find(parent,index2);

    }

    public int find(int[] parent, int index) {
        index = index-'a';
        // 查找index的根节点，使用隔代压缩
        while (parent[index]!=index){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }


    public static void main(String[] args) {
        String[] arr = {"a==b", "a==c", "a==e"};
        EquationsPossible990 equationsPossible990 = new EquationsPossible990();
        boolean b = equationsPossible990.equationsPossible(arr);
        System.out.println(b);
    }

}
