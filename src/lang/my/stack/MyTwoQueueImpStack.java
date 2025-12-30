package lang.my.stack;


import java.util.ArrayDeque;
import java.util.ArrayList;

// 两个队列实现一个栈
// 思路：一个队列用来入栈，一个队列用来出栈。
//      入栈操作：将元素加入入栈队列，如果出栈队列不为空，就将所有出栈队列中的数据出列并依次加入入栈队列，直到出栈队列为空。
//       最后将入栈队列和出栈队列互换引用（入栈队列变为出栈队列，出栈队列变为入栈队列，这时入栈队列就为空，出栈队列已存放所有已入队的元素，并且按照入栈顺序排序好了）。
//      出栈操作：直接从出栈队列出栈
public class MyTwoQueueImpStack<E> implements MyStack<E> {
    private static int size = 0;
    private ArrayDeque<E> q = new ArrayDeque();
    private ArrayDeque<E>  q1 = new ArrayDeque();;

    @Override
    public void push(E e) {
        q1.offer(e);
        size++;
        while(!q.isEmpty()){
            q1.offer(q.poll());
        }
        ArrayDeque temp = q1;
        q1 = q;
        q = temp;

    }

    @Override
    public E pop() {
        if(!q.isEmpty()){
            size--;
            return q.poll();
        }
        return null;
    }

    @Override
    public E getTop() {
        return q.peek();
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
