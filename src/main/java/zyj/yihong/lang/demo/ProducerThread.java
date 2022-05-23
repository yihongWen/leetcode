package zyj.yihong.lang.demo;

import lombok.SneakyThrows;

public class ProducerThread implements Runnable{
    public ProducerThread(FoodPool food) {
        this.food = food;
    }

    public FoodPool food;
    @SneakyThrows
    @Override
    public void run() {
        while (true){
            Thread.sleep(1000);
            genFood();
        }
    }

    private void genFood(){
        if (food.getAllFood().size()==0){
            long l = System.currentTimeMillis();
            System.out.println("gen food:"+l);
            food.getAllFood().add(String.valueOf(l));
        }
    }
}
