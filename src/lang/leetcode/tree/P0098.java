package lang.leetcode.tree;

import java.util.*;

/** 验证二叉搜索树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1：
 * 输入：root = [2,1,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 *
 * 提示：
 *
 * 树中节点数目范围在[1, 104] 内
 * -2^31 <= Node.val <= 2^31 - 1
 *
 */
public class P0098 {

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
        System.out.println(isValidBST1(root));
    }

    // 递归
    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isBST(TreeNode node, long minVal, long maxVal) {
        if(node == null){
            return  true;
        }
        if( node.val <=  minVal || node.val >= maxVal){
            return false;
        }
        return isBST(node.left, minVal, node.val ) && isBST(node.right, node.val, maxVal);
    }

    // 递归 中序遍历，易理解
    public static boolean isValidBST1(TreeNode root) {
        if(root == null)
            return true;
        // 访问左子树
        if(!isValidBST1(root.left))
            return false;
        // 访问当前结点
        if (Long.valueOf(root.val) <= pre)
            return false;
        pre = Long.valueOf(root.val);
        // 访问右子树
        if(!isValidBST1(root.right))
            return false;
        // 均没问题 再返回true
        return true;
    }

    // 迭代
    public boolean isValidBST2(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
