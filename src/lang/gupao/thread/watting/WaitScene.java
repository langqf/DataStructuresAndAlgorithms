package lang.gupao.thread.watting;

import java.util.LinkedList;
import java.util.Queue;

// wait()适用场景 生产者-消费者模式

// 需要注意一下虚假唤醒：
// 在Java线程中：
// 虚假唤醒是指线程在没有被明确通知（notify()/notifyAll()）的情况下，从 wait() 状态中自行恢复
// 这可能由底层操作系统或JVM内部实现引起

// 为什么会有虚假唤醒？
// 在Linux系统上，底层函数pthread_cond_wait()可能会因为信号等原因导致虚假唤醒。
// Java作为跨平台语言，为了适应不同操作系统的特性，所以在规范中允许了虚假唤醒。
// 因此，为了保证程序的正确性，我们应该总是在循环中调用wait()，并在循环中检查条件。
// 这样即使发生了虚假唤醒，我们也会再次检查条件，如果条件不满足，就继续等待。

public class WaitScene {

    // 因为synchronized是加在方法上，目前的模式生成者，消费者都是互斥的，
    // 可以加上两个细粒度锁，只有生产者-生产者互斥，消费者-消费者互斥。生产者和消费者之间不会抢占锁，生产者在生成时，消费者可以消费
    // private final Object putLock = new Object();
    // private final Object takeLock = new Object();
    // 更优的写法是利用并发包中的阻塞队列，比如ArrayBlockingQueue
    private Queue<Integer> q = new LinkedList<>();
    private int capacity;

    public WaitScene(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(Integer i) throws InterruptedException {
        while(q.size() == capacity){//使用while判定，防止虚假唤醒
            System.out.println("缓冲区满了，" + Thread.currentThread().getName() + " 无法生产了");
            wait(); // 缓冲区满，等待
        }
        q.add(i);
        notifyAll();  // 通知消费者
    }

    public synchronized Integer take() throws InterruptedException {
        while(q.isEmpty()){//使用while判定，防止虚假唤醒
            System.out.println("缓冲区是空的，" + Thread.currentThread().getName() + " 无法消费了");
            wait();// 缓冲区空，等待
        }
        Integer value = q.poll();
        notifyAll();  // 通知生产者
        return value;
    }
}
