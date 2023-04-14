package lang.leetcode.tree;

import java.util.ArrayDeque;

/** 二叉搜索树中的搜索
 *
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 *
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 *
 * 示例 2：
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 *
 * 提示：
 *
 * 数中节点数在 [1, 5000] 范围内
 * 1 <= Node.val <= 10^7
 * root 是二叉搜索树
 * 1 <= val <= 10^7
 *
 */
public class P0700 {

    public static long pre = Long.MIN_VALUE;

    public static void main(String[] args) {

        TreeNode l3 = new TreeNode(4);
        TreeNode l2 = new TreeNode(3, l3, null);
        TreeNode l1 = new TreeNode(2, l2, null);

        TreeNode r2 = new TreeNode(6);
        TreeNode r1 = new TreeNode(5,null,r2);

        TreeNode root = new TreeNode(1, l1, r1);
        /*       1
              2     5
            3         6
          4
        */
        System.out.println(searchBST(root,2));
    }

    // 迭代
    public static TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(val == root.val){
                return root;
            }else if(val < root.val){
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return root;
    }

    // 递归
    public static TreeNode searchBST1(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(val == root.val){
            return root;
        }else if(val < root.val){
            return searchBST(root.left, val);
        }else {
            return searchBST(root.right, val);
        }
    }
}
