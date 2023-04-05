package lang.array.and.linklist;

public class ArrayList<T> implements MyList<T>{
    public static int MAX_SIZE = Integer.MAX_VALUE;
    public static int DEFALUT_SIZE = 16;
    private int size = 0;
    private Object[] l;
    private String instanceName;

    public ArrayList(String instanceName){
        this.instanceName = instanceName;
        l = new Object[DEFALUT_SIZE];
    }

    public ArrayList(String instanceName, int initSize){
        if(initSize > MAX_SIZE){
            throw new RuntimeException("超出数组最大容量");
        }
        this.instanceName = instanceName;
        l = new Object[initSize];
    }

    // 销毁
    public void destroyList(){
        for(int i = 0; i < size; i++){
            l[i] = null;
        }
        this.l = null;
        this.size = 0;
    }

    // 清空
    public void clearList(){
        for(int i = 0; i < size; i++){
            l[i] = null;
        }
    }

    //新增
    public void listAdd(T e){
        // 判断是否需要数组扩容，超过一般就扩容到原来的3/2
        if(size >= l.length/2){
            reSize();
        }
        l[size++] = e;
    }
    //
    public void listInsert(int i, T e){
        if(i < 0 || i > size){
            throw new RuntimeException("位置不正确");
        }
        // 判断是否需要数组扩容，超过一般就扩容到原来的3/2
        if(size >= l.length/2){
            reSize();
        }
        // i后面的元素往后移  0 1 2 3 4 5
        for(int j = size -1 ; j >= i; j--){
            l[j+1] = l[j];
        }
        l[i] = e;
        size++;
    }

    private void reSize(){
        System.out.print("size = " + size + "，length=" + l.length + ",开始reSize.");
        int newSize = l.length + l.length / 2;
        Object[] newL = new Object[newSize];
        for(int i = 0 ; i < size; i++){
            newL[i] = l[i];
        }
        l = newL;
        System.out.println("reSize = " + l.length + "，结束reSize.");
    }
    //
    public void listDelete(int i){
        // i后面的元素往后移  0 1 2 3 4 5
        for(int j = i+1 ; j < size; j++){
            l[j-1] = l[j];
        }
        size--;
    }

    public Boolean isEmpty(){
        return  size > 0 ? Boolean.FALSE: Boolean.TRUE;
    }

    public int listLength(){
        return this.size;
    }

    public int locateList(T e){
        int index = -1;
        for(int i = 0; i < size; i++){
            if((T)l[i] == e){
                index = i;
                break;
            }
        }
        return index;
    }

    public T getElement(int i){
        if(i > size || i < 0){
            return null;
        }
        return (T)l[i];
    }

    public void listAll(){
        System.out.println("=============<< instanceName:" + instanceName + " >>============");
        if(l == null || size == 0){
            System.out.println("数组为空");
            return;
        }
        int len = this.listLength();
        for(int i = 0; i < len; i++){
            System.out.print(l[i] + "、");
        }
        System.out.println();
    }
}
