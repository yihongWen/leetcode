package zyj.yihong.leetcode.mid.brain;

public class FindTheWinner1823 {
    // 约瑟夫环问题
    public static int findTheWinner(int n, int k) {
        // 使用递归的方式
        if (n==1){
            return 1;
        }

        int ans = (findTheWinner(n - 1, k) + k) % (n);
        return ans==0?n:ans;
    }

    public static void main(String[] args) {
        int theWinner = findTheWinner(5, 2);
        System.out.println(theWinner);
    }
}
