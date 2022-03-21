package zyj.yihong.leetcode.mid.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 2043. 简易银行系统
 * 款）。银行共有 n 个账户，编号从 1 到 n 。每个账号的初始余额存储在一个下标从 0 开始的整数数组 balance 中，其中第 (i + 1) 个账户的初始余额是 balance[i] 。
 * <p>
 * 请你执行所有 有效的 交易。如果满足下面全部条件，则交易 有效 ：
 * <p>
 * 指定的账户数量在 1 和 n 之间，且
 * 取款或者转账需要的钱的总数 小于或者等于 账户余额。
 * 实现 Bank 类：
 * <p>
 * Bank(long[] balance) 使用下标从 0 开始的整数数组 balance 初始化该对象。
 * boolean transfer(int account1, int account2, long money) 从编号为 account1 的账户向编号为 account2 的账户转帐 money 美元。如果交易成功，返回 true ，否则，返回 false 。
 * boolean deposit(int account, long money) 向编号为 account 的账户存款 money 美元。如果交易成功，返回 true ；否则，返回 false 。
 * boolean withdraw(int account, long money) 从编号为 account 的账户取款 money 美元。如果交易成功，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/simple-bank-system
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Bank2043 {
    Map<Integer,Long> accountMoneyMap;
    public Bank2043(long[] balance) {
         accountMoneyMap = new HashMap<>();
        for (int i = 0; i < balance.length; i++) {
            accountMoneyMap.put(i+1,balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {

        if (account1<1 || account1>accountMoneyMap.size() || account2<1 || account2>accountMoneyMap.size()){
            return false;
        }
        if (money<0 || accountMoneyMap.get(account1)<money){
            return false;
        }
        accountMoneyMap.put(account1,accountMoneyMap.get(account1)-money);
        accountMoneyMap.put(account2,accountMoneyMap.get(account2)+money);
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account<1 || account>accountMoneyMap.size() ){
            return false;
        }
        if (money<0){
            return false;
        }
        accountMoneyMap.put(account,accountMoneyMap.get(account)+money);
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account<1 || account>accountMoneyMap.size() ){
            return false;
        }
        if (money<0 || accountMoneyMap.get(account)<money){
            return false;
        }
        accountMoneyMap.put(account,accountMoneyMap.get(account)-money);
        return true;
    }




}
