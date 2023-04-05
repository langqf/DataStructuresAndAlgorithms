package lang.my.stack;

public class MyLinkStack<T> implements MyStack<T>{

    private int size;

    private Element<T>  topNode;
    
    @Override
    public void push(T t) {
        if(this.size == 0){
            topNode = new Element<T>(t, null);
        }else{
            Element<T> pushNode = new Element<T>(t, topNode);
            pushNode.setNext(topNode);
            topNode = pushNode;
        }
        this.size++;
    }

    @Override
    public T pop(){
        if(this.size == 0){
            System.out.println("栈空了");
            return null;
        }
        T e = topNode.getE();
        topNode = topNode.next;
        this.size--;
        return e;
    }

    @Override
    public T getTop(){
        if(this.size == 0){
            return  null;
        }
        return topNode.getE();
    }

    @Override
    public int length(){
        return this.size;
    }

    @Override
    public Boolean isEmpty(){
        return this.size == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    private class Element<E>{

        private E e;

        private Element<E> next;

        public Element(E t, Element<E> next) {
            this.e = t;
            this.next = next;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        public Element<E> getNext() {
            return next;
        }

        public void setNext(Element<E> next) {
            this.next = next;
        }
    }
}
