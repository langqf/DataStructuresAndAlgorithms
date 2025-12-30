package lang.tree.gupao;

import lang.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode left1 = new TreeNode(6);
        TreeNode right1 = new TreeNode(14);
        TreeNode right2 = new TreeNode(8);
        TreeNode left2 = new TreeNode(12);
        root.setLeft(left1);
        root.setRight(right1);
        left1.setRight(right2);
        right1.setLeft(left2);
        //      10
        // 6         14
        //    8    12
        List<Integer> preList = preOrderTraversal(root);
        System.out.println(preList.toString());
        List<Integer> inList = inOrderTraversal(root);
        System.out.println(inList.toString());
        List<Integer> postList = postOrderTraversal(root);
        System.out.println(postList.toString());
    }

    // 前序 TODO 递归
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<Integer> left = preOrderTraversal(root.getLeft());
        List<Integer> right = preOrderTraversal(root.getRight());
        result.add((Integer)root.getRoot());
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    // 中序 TODO 递归
    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<Integer> left = inOrderTraversal(root.getLeft());
        List<Integer> right = inOrderTraversal(root.getRight());
        result.addAll(left);
        result.add((Integer)root.getRoot());
        result.addAll(right);
        return result;
    }

    // 后序 TODO 递归
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<Integer> left = postOrderTraversal(root.getLeft());
        List<Integer> right = postOrderTraversal(root.getRight());
        result.addAll(left);
        result.addAll(right);
        result.add((Integer)root.getRoot());
        return result;
    }

}
