package lang.leetcode.tree;

/** 完全二叉树的节点个数
 *
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 *
 * 示例 2：
 * 输入：root = []
 * 输出：0
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 *
 * 提示：
 *
 * 树中节点的数目范围是[0, 5 * 10^4]
 * 0 <= Node.val <= 5 * 10^4
 * 题目数据保证输入的树是 完全二叉树
 *
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 *
 */
public class P0222 {

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
         *
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

        System.out.println(countNodes(root1));
        System.out.println(countNodes(root2));
    }

    // 通过比较左右子树层高，层高相等，左子树是满二叉树，否则右子树是满二叉树。计算满二叉树节点总数+1(root)，递归计算另外一棵树的节点总数
    public static int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lHigh = countLevel(root.left);
        int rHigh = countLevel(root.right);
        if(lHigh == rHigh){
            return 1 << lHigh + countNodes(root.right);
        }else{
            return 1 << rHigh + countNodes(root.left);
        }
    }

    public static int countLevel(TreeNode tree){
        int level = 0;
        while(tree != null){
            level++;
            tree = tree.left;
        }
        return level;
    }

    public static int countNodes1(TreeNode root) {
        return preOrderTree(root, 0);
    }

    public static int preOrderTree(TreeNode tree, Integer count){
        if(tree == null){
            return count;
        }else{
            count++;
            count = preOrderTree(tree.left, count);
            count = preOrderTree(tree.right, count);
        }
        return count;
    }

}
