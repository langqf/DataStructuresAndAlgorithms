package lang.gupao.thread.service;

import java.util.concurrent.Callable;

public class ProductService implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(5000);
        return "商品：羽绒服";
    }

}
