package zyj.yihong.leetcode.mid.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 1352. 最后 K 个数的乘积
 * 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
 * <p>
 * 1. add(int num)
 * <p>
 * 将数字 num 添加到当前数字列表的最后面。
 * 2. getProduct(int k)
 * <p>
 * 返回当前数字列表中，最后 k 个数字的乘积。
 * 你可以假设当前列表中始终 至少 包含 k 个数字。
 * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-the-last-k-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ProductOfNumbers1352 {
    private List<Integer> preMulSum;
    private int validLength;

    public ProductOfNumbers1352() {
        preMulSum = new ArrayList<>();
        validLength = 0;
    }

    public void add(int num) {
        if (num == 0) {
            validLength = 0;
            preMulSum.add(0);
            return;
        }
        if (validLength == 0) {
            preMulSum.add(num);
            validLength++;
        } else {
            preMulSum.add(num * preMulSum.get(preMulSum.size() - 1));
            validLength++;
        }
    }

    public int getProduct(int k) {
        if (k > validLength) {
            return 0;
        } else {
            if (k==validLength){
                return preMulSum.get(preMulSum.size() - 1);
            }
            return preMulSum.get(preMulSum.size() - 1) / preMulSum.get(preMulSum.size() - 1 - k);
        }
    }

    public static void main(String[] args) {
//        ["ProductOfNumbers","add","getProduct","getProduct","getProduct","add","add","add"]
//[[],[1],[1],[1],[1],[7],[6],[7]]
        ProductOfNumbers1352 productOfNumbers1352 = new ProductOfNumbers1352();
        productOfNumbers1352.add(1);
        productOfNumbers1352.getProduct(1);
        productOfNumbers1352.getProduct(1);
        productOfNumbers1352.getProduct(1);


        productOfNumbers1352.add(7);
        productOfNumbers1352.add(6);
        productOfNumbers1352.add(7);

    }

}
