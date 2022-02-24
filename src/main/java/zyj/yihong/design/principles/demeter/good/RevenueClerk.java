package zyj.yihong.design.principles.demeter.good;

/**
 * 收营员
 * @author yihong
 */
public class RevenueClerk {

    public boolean settle(User user,double totalPrice){
        user.pay(totalPrice);
        return true;
    }
}
