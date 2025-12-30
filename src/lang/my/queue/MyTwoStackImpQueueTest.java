package lang.my.queue;

public class MyTwoStackImpQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> mtsiq = new MyTwoStackImpQueue();
        mtsiq.enEueue(1);
        mtsiq.enEueue(2);
        mtsiq.enEueue(3);
        System.out.println("mtsiq.deQueue()---" + mtsiq.deQueue());
        System.out.println("mtsiq.deQueue()---" + mtsiq.deQueue());
        mtsiq.enEueue(4);
        mtsiq.enEueue(8);
        mtsiq.enEueue(7);
        System.out.println("mtsiq.deQueue()---" + mtsiq.deQueue());
        System.out.println("mtsiq.deQueue()---" + mtsiq.deQueue());
        System.out.println("mtsiq.deQueue()---" + mtsiq.deQueue());
        System.out.println("mtsiq.deQueue()---" + mtsiq.deQueue());

    }
}
