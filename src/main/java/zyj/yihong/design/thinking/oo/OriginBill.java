package zyj.yihong.design.thinking.oo;

/**
 * 原生支付类
 * @author yihong
 */
public class OriginBill {
    /**
     * 获取数量
     * @return
     */
    public int getCount(){
        return 10;
    }

    /**
     * 获取单价
     * @return
     */
    public int getUnit(){
        return 10;
    }

    /**
     * 获取价格
     * @return
     */
    public double getAllPrice(){
        return discount();
    }

    /**
     * 打折，没有任何活动的情况下的打折
     * @return
     */
    public double discount(){
        return getCount()*getUnit();
    }
}
