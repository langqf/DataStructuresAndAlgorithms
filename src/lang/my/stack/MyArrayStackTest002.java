package lang.my.stack;

public class MyArrayStackTest002 {

    public static void main(String[] args) {
        MyArrayStack<StackObject> ms = new MyArrayStack(5);
        System.out.println("ms.isEmpty(): " + ms.isEmpty());
        System.out.println("ms.length(): " + ms.length());
        System.out.println("ms.getTop(): " + ms.getTop());
        System.out.println("ms.pop(): " + ms.pop());
        ms.push(new StackObject(1));
        ms.push(new StackObject(2));
        ms.push(new StackObject(3));
        System.out.println("ms.isEmpty(): " + ms.isEmpty());
        System.out.println("ms.length(): " + ms.length());
        System.out.println("ms.getTop(): " + ms.getTop());
        System.out.println("ms.pop(): " + ms.pop());
        System.out.println("ms.getTop(): " + ms.getTop());
        ms.push(new StackObject(4));
        ms.push(new StackObject(5));
        ms.push(new StackObject(3));
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
        ms.push(new StackObject(1));
        ms.push(new StackObject(2));
        ms.push(new StackObject(3));
        ms.push(new StackObject(4));
        ms.push(new StackObject(5));
        System.out.println("ms.isEmpty(): " + ms.isEmpty());
        System.out.println("ms.length(): " + ms.length());
        System.out.println("ms.getTop(): " + ms.getTop());
        ms.push(new StackObject(6));
        System.out.println("ms.isEmpty(): " + ms.isEmpty());
        System.out.println("ms.length(): " + ms.length());
        System.out.println("ms.getTop(): " + ms.getTop());
    }

}
