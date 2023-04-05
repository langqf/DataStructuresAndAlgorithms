package lang.array.and.linklist;

public class LinkList<T> implements MyList<T>{
    public static int MAX_SIZE = Integer.MAX_VALUE;
    private Node<T> head;
    private Node<T> tail;
    private int size;
    private String instanceName;

    public LinkList(String instanceName) {
        this.instanceName = instanceName;
        head = new Node(null, null);
        tail = head;
        size = 0;
    }

    // 尾插法，追加到链表末尾
    public void listAdd(T e){
        tail.next = new Node(e, null);
        tail = tail.next;
        size++;
    }

    public void listInsert(int i, T e){
        if(i < 0 || i > this.size){
            throw new IndexOutOfBoundsException("下标越界size:" + this.size + ",i=" + i);
        }
        // 获取i-1位置的元素
        Node<T> el;
        if(i == 0){
            el = head;
        }else if(i == this.size){
            el = tail;
        } else{
            el = getElementByIndex(i - 1);
        }
        Node<T> te = new Node<>(e, null);
        te.next = el.next;
        el.next = te;
        if(i == this.size){
            tail = te;
        }
        size++;
    }

    public T getElement(int i){
        if(i < 0 || i >= this.size || head.next == null){
            return null;
        }
        Node<T> p = head.next;
        int cnt = 0;
        while(null != p && cnt < i){
            p = p.next;
            cnt++;
        }
        /*if(p == null || cnt > i){
            return null;
        }*/
        return p.e;
    }

    public void listDelete(int i){
        if(i < 0 || i >= this.size){
            throw new IndexOutOfBoundsException("下标越界size:" + this.size + ",i=" + i);
        }
        // 获取i-1位置的元素
        Node<T> el;
        if(i == 0){
            el = head;
        }else{
            el = getElementByIndex(i - 1);
        }
        el.next = el.next.next;
        if(i == this.size - 1){
            tail = el;
        }
        size--;
    }

    public int locateList(T t){
        int idx = -1;
        if(t == null || head.next == null){
            return idx;
        }
        Node<T> p = head;
        do{
            p = p.next;
            idx++;
        }while(p!= null && t != p.e);
        if(p != null){
            return idx;
        }else{
            return -1;
        }
    }

    private Node<T> getElementByIndex(int i){
        if(i < 0 || i > this.size){
            throw new IndexOutOfBoundsException("下标越界size:" + this.size);
        }
        Node<T> p = head.next;
        int cnt = 0;
        while(cnt < i){
            p = p.next;
            cnt++;
        }
        return p;
    }

    public T getLast(){
        T t = null;
        if(size > 0){
            t = tail.e;
        }
        return t;
    }

    public int listSize(){
        return this.size;
    }

    public void listAll(){
        System.out.println("=============<< instanceName:" + instanceName + " >>============");
        Node<T> p = head.next;
        /*if(p == null || size == 0){
            System.out.println("链表为空");
            return;
        }*/
        while(null != p){
            System.out.print(p.e + "、");
            p = p.next;
        }
        System.out.println();
    }

    public Boolean isEmpty(){
        return  this.size > 0 ? Boolean.FALSE: Boolean.TRUE;
    }

    public int listLength(){
        return this.size;
    }

    public Node<T> getHead() {
        return head;
    }

    public static class Node<E>{
        private E e;
        private Node<E> next;

        public Node(E t, Node<E> next) {
            this.e = t;
            this.next = next;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getNext() {
            return next;
        }
    }
}
