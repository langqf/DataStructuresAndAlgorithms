package lang.tree;

// 二叉链表表示法  孩子兄弟表示法
// 特点：找孩子容易，找兄弟容易，找双亲难
public class ChildBrotherNode<T> {
    private T root;
    private ChildBrotherNode<T> child;  // 孩子
    private ChildBrotherNode<T> brother; // 兄弟
}
