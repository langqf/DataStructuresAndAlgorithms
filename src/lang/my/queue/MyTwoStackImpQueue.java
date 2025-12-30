package lang.my.queue;


import java.util.ArrayDeque;

// 两个栈实现一个队列

/**
 * 思路：使用两个栈，一个输入栈，一个输出栈
 * 入队操作：直接将元素压入输入栈
 * 出队操作：如果输出栈不为空，则从输出栈弹出，否则，将输入栈中的元素依次弹出并压入输出栈，然后从输出栈弹出栈顶元素
 *
 */
public class MyTwoStackImpQueue<E> implements MyQueue<E>{
    private static int size = 0;
    private ArrayDeque<E> inStack = new ArrayDeque();
    private ArrayDeque<E>  outStack = new ArrayDeque();;

    @Override
    public void enEueue(E e) {
        inStack.push(e);
        size++;
    }

    @Override
    public E deQueue() {
        if(!outStack.isEmpty()){
            E e = outStack.pop();
            size--;
            return e;
        }else{
            while(!inStack.isEmpty()){
                E e = inStack.pop();
                outStack.push(e);
            }
            if(!outStack.isEmpty()){
                E e = outStack.pop();
                size--;
                return e;
            }
        }
        return null;
    }

    @Override
    public E getHead() {
        if(size != 0){
            if(!outStack.isEmpty()){
                return outStack.peek();
            }else{
                while(!inStack.isEmpty()){
                    E e = inStack.pop();
                    outStack.push(e);
                }
                if(!outStack.isEmpty()){
                    return outStack.peek();
                }
            }
        }
        return null;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public Boolean isEmpty() {
        return size == 0;
    }
}
