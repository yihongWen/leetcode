package zyj.yihong.leetcode.mid.other;

import java.util.Random;

/**
 * 478. 在圆内随机生成点
 */
public class RandPoint478 {
    private double radius;
    private double x_center;
    private double y_center;
    private Random random = new Random();
    public RandPoint478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble()*(2*radius)-radius;
            double y = random.nextDouble()*(2*radius)-radius;
            if (x*x+y*y<=radius*radius){
                return new double[]{x_center+x,y_center+y};
            }
        }
    }
}
