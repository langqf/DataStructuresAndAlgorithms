package lang.gupao.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor tpool =
                new ThreadPoolExecutor(2, 10, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("拒绝！");
            }
        });
        tpool.execute(new TaskDemo());
    }
}
