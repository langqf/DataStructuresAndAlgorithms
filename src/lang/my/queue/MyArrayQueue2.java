package lang.my.queue;

/** 循环队列
 * 队空时，head = tail,当循环队列只剩最后一个元素时，此时head=tail,如果最后一个元素再出队列 head+1
 * 此时，队列空了，并且 head !=tail  利用注释一、或者注释二 处理
 */


public class MyArrayQueue2<T> implements MyQueue<T>{

    private int size = 0;
    private T[] arr;
    private int head = 0;
    private int tail = 0;

    public MyArrayQueue2(int length) {
        arr = (T[])new Object[length];
    }

    @Override
    public void enEueue(T t) {
        if(this.size >= arr.length){
            System.out.println("队列满了");
            return;
        }
        if(this.size == 0){
            tail = head;// 注释一，强行使 tail和head 一致。否则，使用注释二
            arr[head] = t;
        }else{
            tail = (tail + 1)%arr.length;
            arr[tail] = t;
        }
        this.size++;
    }

    @Override
    public T deQueue() {
        if(this.size == 0){
            System.out.println("队列已空");
            return null;
        }
        T t = arr[head];
        /* 注释二
        if(this.size != 1){
            head = (head + 1)%arr.length;
        }*/
        head = (head + 1)%arr.length;
        this.size--;
        return t;
    }

    @Override
    public T getHead() {
        if(this.size == 0){
            System.out.println("队列已空");
            return null;
        }
        return arr[head];
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public Boolean isEmpty() {
        return this.size == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

}
