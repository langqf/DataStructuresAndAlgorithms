package lang.leetcode.tree;

/** 二叉树剪枝
 *
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 *
 * 示例 1：
 *    1
 *   nil 0
 *     0   1
 * 输入：root = [1,null,0,0,1]
 * 输出：[1,null,0,null,1]
 * 解释：
 * 只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
 * 示例 2：
 *           1
 *        0     1
 *      0  0  0   1
 * 输入：root = [1,0,1,0,0,0,1]
 * 输出：[1,null,1,null,1]

 * 示例 3：
 *           1
 *        1     0
 *      1  1  0   1
 *    0
 * 输入：root = [1,1,0,1,1,0,1,0]
 * 输出：[1,1,0,1,1,null,1]
 *
 * 提示：
 * 树中节点的数目在范围 [1, 200] 内
 *
 * Node.val 为 0 或 1
 *
 */
public class P0814 {

    public static long pre = Long.MIN_VALUE;

    public static void main(String[] args) {

        /**
         * 示例 2：
         *           1
         *        0     1
         *      0  0  0   1
         */
        TreeNode l3 = new TreeNode(0);
        TreeNode l2 = new TreeNode(0);
        TreeNode l1 = new TreeNode(0, l2, l3);
        TreeNode r3 = new TreeNode(1);
        TreeNode r2 = new TreeNode(0);
        TreeNode r1 = new TreeNode(0, r2, r3);
        TreeNode root1 = new TreeNode(1, l1, r1);
        /**
         * 示例 3：
         *           1
         *        1     0
         *      1  1  0   1
         *    0
         */
        TreeNode l2_4 = new TreeNode(0);
        TreeNode l2_3 = new TreeNode(1, l2_4, null);
        TreeNode l2_2 = new TreeNode(1);
        TreeNode l2_1 = new TreeNode(1, l2_2, l2_3);
        TreeNode r2_3 = new TreeNode(1);
        TreeNode r2_2 = new TreeNode(0);
        TreeNode r2_1 = new TreeNode(0, r2_2, r2_3);
        TreeNode root2 = new TreeNode(1, l2_1, r2_1);
        TreeNode treeNode1 = pruneTree(root1);
        System.out.println(treeNode1.val);
        TreeNode treeNode2 = pruneTree(root2);
        System.out.println(treeNode2.val);
    }
    // 递归求解
    public static TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        return root;
    }

}
