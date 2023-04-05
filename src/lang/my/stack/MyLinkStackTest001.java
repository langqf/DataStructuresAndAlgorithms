package lang.my.stack;

public class MyLinkStackTest001 {

    public static void main(String[] args) {
        MyLinkStack<Integer> ms = new MyLinkStack();
        System.out.println("ms.isEmpty(): " + ms.isEmpty());
        System.out.println("ms.length(): " + ms.length());
        System.out.println("ms.getTop(): " + ms.getTop());
        System.out.println("ms.pop(): " + ms.pop());
        ms.push(1);
        ms.push(2);
        ms.push(3);
        System.out.println("ms.isEmpty(): " + ms.isEmpty());
        System.out.println("ms.length(): " + ms.length());
        System.out.println("ms.getTop(): " + ms.getTop());
        System.out.println("ms.pop(): " + ms.pop());
        System.out.println("ms.getTop(): " + ms.getTop());
        ms.push(4);
        ms.push(5);
        ms.push(3);
        System.out.println("ms.isEmpty(): " + ms.isEmpty());
        System.out.println("ms.length(): " + ms.length());
        System.out.println("ms.getTop(): " + ms.getTop());
        ms.pop();
        ms.pop();
        ms.pop();
        ms.pop();
        ms.pop();
        System.out.println("ms.isEmpty(): " + ms.isEmpty());
        System.out.println("ms.length(): " + ms.length());
        System.out.println("ms.getTop(): " + ms.getTop());
        ms.pop();
        System.out.println("ms.isEmpty(): " + ms.isEmpty());
        System.out.println("ms.length(): " + ms.length());
        System.out.println("ms.getTop(): " + ms.getTop());
        System.out.println("ms.pop(): " + ms.pop());
        System.out.println("ms.getTop(): " + ms.getTop());
        System.out.println("===========上面都没有问题了==========");
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        ms.push(5);
        System.out.println("ms.isEmpty(): " + ms.isEmpty());
        System.out.println("ms.length(): " + ms.length());
        System.out.println("ms.getTop(): " + ms.getTop());
        ms.push(6);
        System.out.println("ms.isEmpty(): " + ms.isEmpty());
        System.out.println("ms.length(): " + ms.length());
        System.out.println("ms.getTop(): " + ms.getTop());
    }

}
