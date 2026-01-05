package lang.gupao.thread.watting;

import java.util.concurrent.locks.LockSupport;

// park()
// 被中断时不会抛异常，会直接返回,并且不会清除中断标志
// 但是Thread.interrupted()会返回当前线程的中断状态，并且会清除中断状态（即重置为false）
// 判定中断状态应该用
public class ParkInterruptedExample {
    public static void main(String[] args) {
        Thread t1 = new Thread((
        )->{
            System.out.println("子线程执行，即将进入等待状态");
            LockSupport.park();// 当前线程进入waitting状态
            System.out.println("子线程被唤醒，继续执行.中断状态：" + Thread.currentThread().isInterrupted());
        });
        t1.start();
        System.out.println("1秒后，主线程发送中断信号给子线程");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=======================");
        // 只响应中断才退出
        Thread t2 = new Thread((
        )->{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("子线程执行中，即将进入等待状态，中断状态：" + Thread.currentThread().isInterrupted());
                LockSupport.park();// 当前线程进入waitting状态
                System.out.println("子线程被唤醒，继续执行.中断状态：" + Thread.currentThread().isInterrupted());
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("检测到中断，退出。中断状态：" + Thread.currentThread().isInterrupted());
                }
            }
        });
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <=5; i++) {
            if(i < 5){
                LockSupport.unpark(t2);
                try {
                    Thread.sleep(1000);// 每隔一秒唤醒一次
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                t2.interrupt();// 最后一次发送中断通知
            }
        }

        // 忽略中断，继续park
        Thread t3 = new Thread((
        )->{
            while(true){
                LockSupport.park();// 当前线程进入waitting状态
                System.out.println("被唤醒了，但是我会再次park");
                Thread.interrupted();// 清除中断标记
            }
        });
        t3.start();

        for (int i = 0; i < 3; i++) {
            LockSupport.unpark(t3);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程结束");
    }
}