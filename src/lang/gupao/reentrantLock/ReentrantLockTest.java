package lang.gupao.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    ReentrantLock lock = new ReentrantLock();
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        System.out.println("KO!");
    }
}
