package lang.gupao.thread.watting;

import static java.lang.Math.random;

// wait()适用场景 生产者-消费者模式
public class WaitSceneTest {
    public static void main(String[] args) {
        WaitScene ws = new WaitScene(100);
        System.out.println("开始。。。");
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    while(true){
                        int x = (int) (Math.random() * 1000);
                        Integer num = Integer.valueOf(x);
                        System.out.println("生产者" + Thread.currentThread().getName() + " 生产 "+ num);
                        ws.put(num);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    while(true){
                        Integer num = ws.take();
                        System.out.println("消费者" + Thread.currentThread().getName() + " 消费 "+ num);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
