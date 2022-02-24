package zyj.yihong.design.principles.demeter.bad;

public class Client {
    public static void main(String[] args) {
        // 模拟交易

        // 收营员
        RevenueClerk revenueClerk = new RevenueClerk();

        // 用户
        User user = new User();
        Wallet wallet = new Wallet();
        user.setWallet(wallet);

        // 用户努力赚钱
        user.getWallet().addMoney(1000);

        // 收营员拿到用户的钱包
        revenueClerk.settle(user.getWallet(), 100);
    }
}
