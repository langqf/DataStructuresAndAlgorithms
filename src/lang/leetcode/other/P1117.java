package lang.leetcode.other;

import java.util.concurrent.*;

/** H2O 生成
 * 现在有两种线程，氧 oxygen 和氢 hydrogen，你的目标是组织这两种线程来产生水分子。
 *
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 *
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 *
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 *
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 *
 * 换句话说:
 *
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 *
 *
 *
 * 示例 1:
 *
 * 输入: water = "HOH"
 * 输出: "HHO"
 * 解释: "HOH" 和 "OHH" 依然都是有效解。
 * 示例 2:
 *
 * 输入: water = "OOHHHH"
 * 输出: "HHOHHO"
 * 解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
 *
 *
 * 提示：
 *
 * 3 * n == water.length
 * 1 <= n <= 20
 * water[i] == 'O' or 'H'
 * 输入字符串 water 中的 'H' 总数将会是 2 * n 。
 * 输入字符串 water 中的 'O' 总数将会是 n 。
 *
 */
public class P1117 {

    //    public static ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 1L, TimeUnit.MINUTES, new ArrayBlockingQueue<>(100));
//        public static ExecutorService service = Executors.newFixedThreadPool(3);
    public static ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(2);
    static String waters = "OHOHHHOHHHOHOHHOHH";

    //TODO 多线程问题
    public static void main(String[] args) throws InterruptedException {
       /* P1117 h2O = new P1117();
//        while(!water.equals("")){
            pool.submit(()->{
                try {
                    h2O.hydrogen(new ReleaseHydrogen());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            pool.submit(()->{
                try {
                    h2O.hydrogen(new ReleaseHydrogen());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            pool.submit(()->{
                try {
                    h2O.oxygen(new ReleaseOxygen());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
//            System.out.println("water is : " + water);
//        }
        System.out.println(pool.getActiveCount());
//        pool.shutdown();*/

        P1117 h2o = new P1117();


        for (int i = 0; i < waters.length(); i++) {
            int finalI = i;
            new Thread(()->{
                if(waters.charAt(finalI)=='H'){
                    try {
                        h2o.hydrogen(()->System.out.print("H"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if(waters.charAt(finalI)=='O'){
                    try {
                        h2o.oxygen(()->System.out.print("O"));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    throw new RuntimeException("'water' must consist of values in ['H', 'O'] only");
                }
            }).start();
        }

    }

    public P1117() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        //请求一个信号量，这时候信号量个数-1，当减少到0的时候，下一次acquire不会再执行，只有当执行一个release()的时候，信号量不为0的时候才可以继续执行acquire
        h.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
//        new Thread(releaseHydrogen).start();
        releaseHydrogen.run();
        //释放一个信号量，这时候信号量个数+1，
        o.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
//        new Thread(releaseOxygen).start();
        releaseOxygen.run();
        h.release(2);
    }
/*
    static class ReleaseHydrogen implements Runnable{
        @Override
        public void run() {
            System.out.println("H");
//            water = water.replaceFirst("H", "");
        }
    }

    static class ReleaseOxygen implements Runnable{

        @Override
        public void run() {
            System.out.println("O");
//            water = water.replaceFirst("O", "");
        }
    }*/
}

