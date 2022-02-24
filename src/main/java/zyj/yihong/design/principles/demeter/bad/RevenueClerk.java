package zyj.yihong.design.principles.demeter.bad;

/**
 * 收营员
 * @author yihong
 */
public class RevenueClerk {

    public boolean settle(Wallet wallet,double totalPrice){
        if (wallet.getMoney()>totalPrice){
            wallet.subMoney(totalPrice);
            return true;
        }

        return false;
    }
}
