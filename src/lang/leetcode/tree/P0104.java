package lang.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/** 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class P0104 {

    public static void main(String[] args) {

        TreeNode l3 = new TreeNode(4);
        TreeNode l2 = new TreeNode(3, l3, null);
        TreeNode l1 = new TreeNode(2, l2, null);

        TreeNode r2 = new TreeNode(6);
        TreeNode r1 = new TreeNode(5,null,r2);

        TreeNode root = new TreeNode(1, l1, r1);

        System.out.println(maxDepth3(root));
    }

    // 递归方法  DFS
    public static int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    // 使用循环 队列层次遍历 BFS
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    // 使用栈，计算每一个节点的深度，取最大值 BFS
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            if (node.left == null && node.right == null) {
                maxDepth = Math.max(maxDepth, depth);
            }
            if (node.right != null) {
                stack.push(new Pair<>(node.right, depth + 1));
            }
            if (node.left != null) {
                stack.push(new Pair<>(node.left, depth + 1));
            }
        }
        return maxDepth;
    }

    // 使用队列 BFS
    public static int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int depth = pair.getValue();
            if (node.left == null && node.right == null) {
                maxDepth = Math.max(maxDepth, depth);
            }
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, depth + 1));
            }
        }
        return maxDepth;
    }

}
