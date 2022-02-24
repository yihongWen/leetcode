package zyj.yihong.design.principles.demeter.good;

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

        revenueClerk.settle(user, 100);
    }
}
