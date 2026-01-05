package lang.gupao.thread.watting;

import java.util.ArrayList;
import java.util.List;

// join()适用场景，等待多个线程执行完成后再继续
public class JoinScene {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> list =new ArrayList();
        for (int i = 0; i < 5; i++) {
            String name = "thread" + i;
            Thread t = new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println( name + " 任务执行完毕!");
            });
            t.start();
            list.add(t);
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).join();
        }
        System.out.println("所有任务都完成，一起出发！");
    }
}
