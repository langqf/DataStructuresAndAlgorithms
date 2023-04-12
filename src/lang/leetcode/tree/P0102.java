package lang.leetcode.tree;

import java.util.*;

/** 二叉树的层序遍历
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例 1：
 *
 *       3
 *   9      20
 *        15  7
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 *
 */
public class P0102 {

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
        System.out.println(levelOrder1(root));
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, 0, result);
        return result;
    }

    private static  void dfs(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<List<Integer>> l = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> l1 = new ArrayList<>(size);
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                l1.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            l.add(l1);
        }
        return l;
    }
}
