package lang.tree;

// 孩子链表法  双亲节点对象
public class ChildParentNode<T> {
    int i; // 这个表示双亲节点下标
    ChildNode firstChild; // 第一个孩子节点对象

    public ChildParentNode(int i, ChildNode firstChild) {
        this.i = i;
        this.firstChild = firstChild;
    }
}
