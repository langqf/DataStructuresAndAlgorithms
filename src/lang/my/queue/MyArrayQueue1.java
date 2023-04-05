package lang.my.queue;

// 每次出队都移动数组元素，时间复杂度太高
public class MyArrayQueue1<T> implements MyQueue<T>{

    private int size;
    private T[] arr;

    public MyArrayQueue1(int length) {
        this.size = 0;
        arr = (T[])new Object[length];
    }

    @Override
    public void enEueue(T t) {
        if(this.size >= arr.length){
            System.out.println("队列满了");
            return;
        }
        arr[size] = t;
        this.size++;
    }

    @Override
    public T deQueue() {
        if(this.size == 0){
            System.out.println("队列已空");
            return null;
        }
        T t = arr[0];
        this.size--;
        // 移动数组元素
        for(int i = 0 ; i < this.size; i++){
            arr[i] = arr[i + 1];
        }
        arr[this.size] = null;
        return t;
    }

    @Override
    public T getHead() {
        if(this.size == 0){
            System.out.println("队列已空");
            return null;
        }
        return arr[0];
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
