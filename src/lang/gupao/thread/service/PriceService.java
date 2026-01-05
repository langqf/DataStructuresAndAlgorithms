package lang.gupao.thread.service;

import java.util.concurrent.Callable;

public class PriceService  implements Callable<String> {
    public String call() throws InterruptedException {
        Thread.sleep(3000);
        return "单价：1000元";
    }
}
