package lang.leetcode.tree;

/** 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 * 示例 3：
 * 输入：root = []
 * 输出：true
 *
 * 提示：
 *
 * 树中的节点数在范围 [0, 5000] 内
 * -10^4 <= Node.val <= 10^4
 *
 */
public class P0110 {

    public static long pre = Long.MIN_VALUE;

    public static void main(String[] args) {

        TreeNode l3 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2, l3, null);
        TreeNode l1 = new TreeNode(3, l2, null);

        TreeNode r2 = new TreeNode(6);
        TreeNode r1 = new TreeNode(5,null,r2);

        TreeNode root1 = new TreeNode(4, l1, r1);
        /*       4
              3     5
            2         6
          1
        */

        /**
         * 5, 3, 6, 2, 4, null, 7
         *               5
         *           3      6
         *         2  4   nil 7
         */
        TreeNode l2_3 = new TreeNode(1);
        TreeNode l2_2 = new TreeNode(2);
        TreeNode l2_1 = new TreeNode(3, l2_2, l2_3);

        TreeNode r2_2 = new TreeNode(7);
        TreeNode r2_1 = new TreeNode(6,null, r2_2);

        TreeNode root2 = new TreeNode(5, l2_1, r2_1);
        System.out.println(isBalanced(root1));
        System.out.println(isBalanced(root2));
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isBalanced(root.left) || !isBalanced(root.right)){
            return false;
        }
        // 计算左子树高度
        int leftHigh = maxDepth(root.left);
        // 计算右子树高度
        int rightHigh = maxDepth(root.right);
        if(Math.abs(leftHigh - rightHigh) > 1){
            return false;
        }
        return true;
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
