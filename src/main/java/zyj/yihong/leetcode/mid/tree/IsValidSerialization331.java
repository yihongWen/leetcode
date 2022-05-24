package zyj.yihong.leetcode.mid.tree;

import java.util.Objects;

/**
 * 331. 验证二叉树的前序序列化
 */
public class IsValidSerialization331 {
    // 输入: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
    public static boolean isValidSerialization(String preorder) {
        // 满二叉树中sum(非叶子节点)+1 = sum(叶子节点)
        String[] split = preorder.split(",");
        int slot = 1;
        for (String s : split) {
            if (slot==0){
                return false;
            }
            if (Objects.equals(s, "#")){
                slot--;
            }else {
                slot++;
            }
        }

        return slot==0;

    }

    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean validSerialization = isValidSerialization(s);
        System.out.println(validSerialization);
    }
}
