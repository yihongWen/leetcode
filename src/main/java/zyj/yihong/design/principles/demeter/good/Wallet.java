package zyj.yihong.design.principles.demeter.good;

/**
 * 钱包
 * @author yihong
 */
public class Wallet {

    public double getMoney() {
        return money;
    }

    private double money = 100;

    public double addMoney(double add){
        money+= add;
        return money;
    }

    public double subMoney(double sub){
        money-= sub;
        return money;
    }


}
