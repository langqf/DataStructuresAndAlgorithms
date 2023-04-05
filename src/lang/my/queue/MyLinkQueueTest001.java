package lang.my.queue;

public class MyLinkQueueTest001 {
    public static void main(String[] args) {
        MyQueue<Integer> q1 = new MyLinkQueue<>();
        System.out.println("q1.length() : " + q1.length());
        System.out.println("q1.isEmpty() : " + q1.isEmpty());
        System.out.println("q1.getHead()：" + q1.getHead());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        q1.enEueue(1);
        q1.enEueue(2);
        q1.enEueue(3);
        q1.enEueue(4);
        q1.enEueue(5);
        q1.enEueue(6);
        System.out.println("q1.length() : " + q1.length());
        System.out.println("q1.isEmpty() : " + q1.isEmpty());
        System.out.println("q1.getHead()：" + q1.getHead());

        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        q1.enEueue(1);
        q1.enEueue(2);
        q1.enEueue(3);
        q1.enEueue(4);
        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());

        System.out.println("q1.deQueue() : " +q1.deQueue());
        q1.enEueue(3);
        q1.enEueue(4);
        System.out.println("q1.length() : " + q1.length());
        System.out.println("q1.isEmpty() : " + q1.isEmpty());
        System.out.println("q1.getHead()：" + q1.getHead());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        System.out.println("q1.deQueue() : " +q1.deQueue());
        for(int i = 0 ; i <1000; i++){
            q1.enEueue(i);
        }
        System.out.println(q1.length());
    }
}
