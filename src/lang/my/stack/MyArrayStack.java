package lang.my.stack;

public class MyArrayStack<T> implements MyStack<T>{
    private int stackSize;
    private T[] arr;
    private int size;
    private T top;
    public MyArrayStack(int stackSize) {
        this.stackSize = stackSize;
        this.arr = (T[])new Object[stackSize];
        this.size = 0;
        this.top = arr[0];
    }

    @Override
    public void push(T t) {
        if(this.size == stackSize){
            System.out.println("栈满了，清理一下空间吧");
            return;
        }
        arr[size]  = t;
        top = arr[size];
        this.size++;
    }

    @Override
    public T pop(){
        if(this.size == 0){
            System.out.println("栈是空的，需要先加点东西进来");
            return null;
        }
        T pop = arr[size-1];
        arr[size-1] = null;
        this.size--;
        if(this.size == 0){
            this.top = arr[size];
        }else{
            top = arr[size-1];
        }
        return pop;
    }

    @Override
    public T getTop(){
        if(this.size == 0){
            return  null;
        }
        return top;
    }

    @Override
    public int length(){
        return this.size;
    }

    @Override
    public Boolean isEmpty(){
        return this.size == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

}
