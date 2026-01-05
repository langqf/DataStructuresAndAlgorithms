package lang.gupao.thread.watting;

import java.util.concurrent.locks.LockSupport;

// park()是LockSupport类中的方法，LockSupport是java并发包中的类，提供的线程等待和唤醒的基本操作
// 直接调用 LockSupport.park()使当前线程进入waitting状态，
// 如果其他线程调用unpark(Thread thread)方法或者线程被中断，则该线程将恢复运行
// 被中断时不会抛异常，会直接返回
// 每个线程有一个"许可"（permit）机制,最多只能有一个
// 它基于一个隐式的“许可证”概念。unpark() 先于 park() 调用时，park() 会立即返回
// 可以设置超时时间 parkNanos(timeout)
// 不会释放锁（如果持有的话）
public class ParkExample {
    public static void main(String[] args) {
        Thread t = new Thread((
        )->{
            System.out.println("子线程执行，即将进入等待状态");
            LockSupport.park();// 当前线程进入waitting状态
            System.out.println("子线程被唤醒，继续执行");
        });
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("三秒后，主线程唤醒子线程");
        LockSupport.unpark(t);// 唤醒子线程
    }
}