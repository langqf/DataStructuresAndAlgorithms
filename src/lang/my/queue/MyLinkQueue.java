package lang.my.queue;

// 每次出队都移动数组元素，时间复杂度太高
public class MyLinkQueue<T> implements MyQueue<T> {

    private int size = 0;
    private Element<T> head;
    private Element<T> tail;

    @Override
    public void enEueue(T t) {
        Element<T> e = new Element<>(t, null);
        if(this.size == 0){
            head = tail = e;
        }else{
            tail.next = e;
            tail = e;
        }
        this.size++;
    }

    @Override
    public T deQueue() {
        if(this.size == 0){
            System.out.println("队列已空");
            return null;
        }
        Element<T> e = head;
        head = head.next;
        this.size--;
        return e.e;
    }

    @Override
    public T getHead() {
        if (this.size == 0) {
            System.out.println("队列已空");
            return null;
        }
        return head.e;
    }

    @Override
    public int length() {
        return this.size;
    }

    @Override
    public Boolean isEmpty() {
        return this.size == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    private class Element<E> {

        private E e;

        private Element<E> next;

        public Element(E t, Element<E> next) {
            this.e = t;
            this.next = next;
        }

    }

}
