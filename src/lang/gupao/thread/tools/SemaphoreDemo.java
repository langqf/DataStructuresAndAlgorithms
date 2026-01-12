package lang.gupao.thread.tools;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // 创建信号量，允许3个线程同时访问
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 15; i++) {
            new Thread(new Worker(semaphore, i)).start();
        }
    }

    static class Worker implements Runnable {
        private Semaphore semaphore;
        private int workerId;

        public Worker(Semaphore semaphore, int workerId) {
            this.semaphore = semaphore;
            this.workerId = workerId;
        }

        @Override
        public void run() {
            try {
                System.out.println("工人 " + workerId + " 等待获取机器...");
                semaphore.acquire();  // 获取许可
                System.out.println("工人 " + workerId + " 获取到机器，开始工作");
                Thread.sleep(2000);  // 模拟工作
                System.out.println("工人 " + workerId + " 工作完成，释放机器");
                semaphore.release();  // 释放许可
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
