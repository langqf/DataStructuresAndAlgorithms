package lang.my.queue;

interface MyQueue<T> {

    void enEueue(T t);

    T deQueue();

    T getHead();

    int length();

    Boolean isEmpty();

}
