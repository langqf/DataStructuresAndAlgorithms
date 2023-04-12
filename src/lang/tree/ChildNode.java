package lang.tree;

// 孩子链表法  孩子节点对象
public class ChildNode<T> {
    int i; // 当前节点所在数组下标
    ChildNode next; // 双亲节点下一个孩子节点

    public ChildNode(int i, ChildNode next) {
        this.i = i;
        this.next = next;
    }

}
