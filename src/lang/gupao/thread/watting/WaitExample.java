package lang.gupao.thread.watting;
// wait()是Object类的方法，主要用于线程间通信
// wait()方法必须在synchronized块中执行，必须配合notify/notiryAll使用
// wait()方法会释放锁，当前线程会进入waitting状态，直到其他线程调用同一个对象的notify()/notifyAll()方法或者被中断
// 可以设置等待时间
// 被中断时会抛出InterruptedException异常
// 会释放锁
public class WaitExample {
    public static void main(String[] args) {
        final Object lock = new Object();
        Thread t1 = new Thread(()->{
            synchronized(lock){
                System.out.println("线程1获取到锁，等待通知。。。");
                try {
                    lock.wait();// wait方法释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1收到通知，继续执行。。。");
            }
        });

        Thread t2 = new Thread(()->{
            synchronized(lock){
                System.out.println("线程2获取到锁，发送通知。。。");
                // 唤醒一个在lock上等待的线程
                // 注意：唤醒线程并不会立即释放锁，它会继续执行完同步块，然后释放锁。
                // 被唤醒的线程需要等到唤醒线程释放锁后才能重新获得锁并执行。
                lock.notify();
                // lock.notifyAll();
            }
        });

        t1.start();
        try {
            Thread.sleep(1000); // 确保t1先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
