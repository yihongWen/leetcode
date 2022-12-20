package zyj.yihong.leetcode.random_select.dec;

// 1764. 通过连接另一个数组的子数组得到一个数组
// 子数组跟子序列的区别
public class CanChoose_M_1764 {

    public boolean canChoose(int[][] groups, int[] nums) {
        int k = 0;
        int i = 0;
        for (; i < groups.length && k<nums.length; i++) {
            if (check(groups[i], nums, k)){
                k=k+groups[i].length;
                i++;
                continue;
            }
            k++;
        }
        return i== groups.length;
    }

    private boolean check(int[] a,int[] b,int bIndex){
        // 优先判断长度
        if (a.length>b.length-bIndex){
            return false;
        }

        int i = 0;
        while (i<a.length && bIndex<b.length){
            if (a[i]!=b[bIndex]){
                return false;
            }
            i++;
            bIndex++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] group = {{1,2}};
        int[] num = {1,3,2};
        CanChoose_M_1764 canChoose_m_1764 = new CanChoose_M_1764();
        boolean b = canChoose_m_1764.canChoose(group, num);
        System.out.println(b);

    }
}
