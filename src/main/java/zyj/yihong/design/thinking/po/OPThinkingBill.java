package zyj.yihong.design.thinking.po;

import java.util.Random;

/**
 * 模拟面向过程的方式实现需求：
 * - 根据单价、数量进行结算
 * - 七夕节所有的商品打折77
 * - 中秋节满399-100，国庆节100内10%的机会免单
 * - 七夕节，情侣购物满99 随机送小礼品（鲜花、巧克力 9.9元抵扣）之前77折也限制
 * @author yihong
 */
public class OPThinkingBill {


    private static double getAllPrice() {

        double allPrice;
        int count = getCount();
        int unit = getUnitPrice();

        // 第一版根据单价数量进行结算
        double realAllPrice = count*unit;
        allPrice = realAllPrice;

        // 第二版：打折
        if (valentineDay()) {
            allPrice = (realAllPrice* 0.7);
        }

        // 第三版：国庆+中秋的处理方式
        if (nationalDay() && realAllPrice <= 100) {
            allPrice = new Random().nextInt(10) == 0 ? 0 : realAllPrice;
        }

        if (midAutumnDay() && realAllPrice >= 399) {
            allPrice = realAllPrice - 100;
        }

        // 第四版
        if (valentineDay()&&lover()&&realAllPrice>=99){
            System.out.println("随机赠送礼物："+new Random().nextInt(4));
            allPrice = (realAllPrice * 0.7);

        }

        return allPrice;
    }

    /**
     * 获取数量
     *
     * @return int
     */
    private static int getCount() {
        return new Random().nextInt(15);
    }

    /**
     * 获取单价
     *
     * @return
     */
    private static int getUnitPrice() {
        return new Random().nextInt(25);
    }


    private static boolean valentineDay() {
        return new Random().nextInt(25) % 2 == 0;
    }


    private static boolean midAutumnDay() {
        return new Random().nextInt(25) % 2 == 0;
    }


    private static boolean nationalDay() {
        return new Random().nextInt(25) % 2 == 0;
    }

    private static boolean lover() {
        return new Random().nextInt(25) % 2 == 0;
    }
}
