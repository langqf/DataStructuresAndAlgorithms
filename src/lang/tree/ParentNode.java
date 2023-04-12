package lang.tree;

public class ParentNode<T> {
    T data; // 当前数据域
    int i; // 双亲下标

    public ParentNode(T data, int i) {
        this.data = data;
        this.i = i;
    }
}
