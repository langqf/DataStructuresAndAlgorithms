package lang.tree;

import java.util.Stack;

// 一棵树
// 二叉链表表示法
public class TreeNode<T> {

    private T root;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode() {
    }

    public TreeNode(T root) {
        this.root = root;
        this.left = null;
        this.right = null;
    }

    public TreeNode(T root, TreeNode<T> left, TreeNode<T> right) {
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

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
