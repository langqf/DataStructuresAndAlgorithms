package lang.gupao.thread.service;

import java.util.concurrent.Callable;

public class StockService  implements Callable<String> {

    public String call() throws InterruptedException {
        Thread.sleep(1000);
        return "库存：80";
    }
}
