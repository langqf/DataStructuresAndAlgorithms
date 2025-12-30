package lang.my.stack;

import java.util.ArrayDeque;

public class MyTwoQueueImpStackTest {

    public static void main(String[] args) {
        MyTwoQueueImpStack<Integer> mtqis = new MyTwoQueueImpStack();
        mtqis.push(1);
        mtqis.push(2);
        mtqis.pop();
        mtqis.push(3);
        mtqis.push(4);
        mtqis.pop();
        mtqis.push(5);
        int length = mtqis.length();
//        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.println(mtqis.pop());
        }
//        System.out.println(mtqis.length());
    }
}
