package zyj.yihong.design.principles.demeter.good;

public class User {

    private Wallet wallet;

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public void pay(double totalPrice){
        double v = this.getWallet().subMoney(totalPrice);
    }
}
