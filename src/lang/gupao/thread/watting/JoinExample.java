package lang.gupao.thread.watting;
// join方法的用法：
// join方法是Thread类的方法
// 线程A调用某个线程B的join(),意味着线程A会进入waitting状态，等待线程B执行完成
// 可以设置超时时间
// 被中断时会抛出InterruptedException异常
// 不涉及锁
public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread childThread1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程1执行完成");
        });
        Thread childThread2 = new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程2执行完成");
        });

        childThread1.start();
        childThread2.start();
        childThread1.join();// 主线程等子线程1执行完成
        System.out.println("子线程1执行完成，继续执行主线程");
        childThread2.join(1000);// 主线程等子线程2执行完成，最多等待1000ms
        System.out.println("主线程执行完成");
    }
}
