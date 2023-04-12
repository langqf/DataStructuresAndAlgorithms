package lang.tree;

// 线索二叉树节点
public class ThrededNode<T> {

    private T root;
    private ThrededNode<T> left;
    private boolean ltag; // ltag为0指向左孩子 为1指向前驱节点
    private ThrededNode<T> right;
    private boolean rtag; // rtag为0指向右孩子 为1指向后继节点

    public ThrededNode() {
    }

    public ThrededNode(T root) {
        this.root = root;
        this.left = null;
        this.right = null;
    }

    public ThrededNode(T root, ThrededNode<T> left, ThrededNode<T> right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    public T getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }

    public ThrededNode<T> getLeft() {
        return left;
    }

    public void setLeft(ThrededNode<T> left) {
        this.left = left;
    }

    public ThrededNode<T> getRight() {
        return right;
    }

    public void setRight(ThrededNode<T> right) {
        this.right = right;
    }
}
