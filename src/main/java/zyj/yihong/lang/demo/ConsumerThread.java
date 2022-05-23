package zyj.yihong.lang.demo;

public class ConsumerThread implements Runnable{
    public ConsumerThread(FoodPool food) {
        this.food = food;
    }

    public FoodPool food;

    @Override
    public void run() {
        while (true){
            if (food.getAllFood().size()>0){
                System.out.println("eat food..."+food.getAllFood().get(0));
                food.getAllFood().remove(food.getAllFood().size()-1);
            }
        }
    }
}
