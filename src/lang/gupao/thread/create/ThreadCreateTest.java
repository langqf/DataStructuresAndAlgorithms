package lang.gupao.thread.create;

import lang.gupao.thread.service.PriceService;
import lang.gupao.thread.service.ProductService;
import lang.gupao.thread.service.StockService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCreateTest {
    //52m36s
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //方法一、通过实现Runnable接口实现 启动线程用start()方法，不是run()方法
        new Thread(new RunnableDmo(),"这是自定义的，实现了Runnable的线程 还是 主线程main 执行了？").run();
        new Thread(new RunnableDmo(),"自定义的，实现了Runnable的线程").start();

        // 方法二、通过集成Thread类，重写run方法
        ThreadDemo td = new ThreadDemo();
        td.setName("继承Thread类的线程实例");
        td.start();

        // 方法三、callable/futuretask  可以获取线程返回数据
        ProductService productService = new ProductService();
        PriceService priceService = new PriceService();
        StockService stockServie = new StockService();
        try {
            System.out.println(productService.call() + priceService.call() + stockServie.call());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        FutureTask<String> productTask = new FutureTask(productService);
        FutureTask<String> priceTask = new FutureTask(priceService);
        FutureTask<String> stockTask = new FutureTask(stockServie);

        new Thread(productTask).start();
        new Thread(priceTask).start();
        new Thread(stockTask).start();
        System.out.println(productTask.get()+ priceTask.get() + stockTask.get());
        System.out.println("主线程结束！");
    }


}
