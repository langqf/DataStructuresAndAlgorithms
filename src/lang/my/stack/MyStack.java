package lang.my.stack;

public interface MyStack<T> {
     void push(T t);
     T pop();
     T getTop();
     int length();
     Boolean isEmpty();
}
