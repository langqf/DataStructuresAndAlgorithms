package lang.leetcode.tree;

import java.util.Arrays;

/** 删除二叉搜索树中的节点
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 * 示例 2：
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 *
 * 示例 3：
 * 输入: root = [], key = 0
 * 输出: []
 *
 * 提示:
 * 节点数的范围 [0, 104].
 * -10^5 <= Node.val <= 10^5
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -10^5 <= key <= 10^5
 *
 * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 */
public class P0450 {

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
        TreeNode root = createTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode newTree = deleteNode(root, 3);
        System.out.println(newTree.val);
    }

    public static TreeNode createTree(Integer[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }
        TreeNode[] arr = new TreeNode[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != null){
                arr[i + 1] = new TreeNode(nums[i]);
            }else{
                arr[i + 1] = null;
            }
        }
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != null){
                if((2*i) < arr.length){
                    arr[i].left = arr[2*i];
                }
                if((2*i + 1) < arr.length){
                    arr[i].right = arr[2*i + 1];
                }
            }
        }
        return arr[1];
    }

    // 递归
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(root.val > key){
            root.left =  deleteNode(root.left, key);
            return root;
        }else if (root.val < key){
            root.right =  deleteNode(root.right, key);
            return root;
        }
        if(root.left == null){
            return root.right;
        }
        if(root.right == null){
            return root.left;
        }
        // 找左子树最大值节点
        TreeNode leftTree = root.left;
        if(leftTree.right == null){
            root.val = leftTree.val;
            root.left = leftTree.left;
            return root;
        }
        TreeNode parentNode = leftTree;
        TreeNode childNode = parentNode.right;
        while(childNode.right != null){
            parentNode = childNode;
            childNode = childNode.right;
        }
        root.val = childNode.val; // 直接将最大值赋给root,root的左右指针不变
        parentNode.right = childNode.left; // 将最大值节点删除
        return root;
    }

    // 一般方式：找要删除的节点，然后删除 代码冗余较多，可以优化
    public static TreeNode deleteNode1(TreeNode root, int key) {
        TreeNode delNode = root;// 要删除的节点
        TreeNode parentNode = null;// 删除节点的父节点
        // 1.找到要删除的节点
        while(delNode != null){
            if(key == delNode.val){
                break;
            }else if(key < delNode.val){
                parentNode = delNode;
                delNode = delNode.left;
            }else {
                parentNode = delNode;
                delNode = delNode.right;
            }
        }
        if(delNode != null){
            /**
             * 要删除节点位置分四种
             * 1. 是叶子节点
             * 2. 其左子树为空
             * 3. 其右子树为空
             * 4. 左右子树都不为空
             */
            if(delNode.left == null && delNode.right == null){
                if(delNode == root){
                    root = null;
                }else{
                    if(parentNode.left == delNode){
                        parentNode.left = null;
                    }else{
                        parentNode.right = null;
                    }
                }
            } else if(delNode.left == null && delNode.right != null){
                if(delNode == root){
                    root = root.right;
                }else{
                    // 可以不用判断是父节点左节点还是右节点,直接将右节点复制给要删除的节点 后面的类似
                    /*
                    delNode.val = delNode.right.val;
                    delNode.left = delNode.right.left;
                    delNode.right = delNode.right.right;
                    */
                    if(parentNode.left == delNode){
                        parentNode.left = delNode.right;
                    }else{
                        parentNode.right = delNode.right;
                    }
                }
            }else if(delNode.right == null && delNode.left != null){
                if(delNode == root){
                    root = root.left;
                }else{
                    if(parentNode.left == delNode){
                        parentNode.left = delNode.left;
                    }else{
                        parentNode.right = delNode.left;
                    }
                }
            }else if(delNode.left != null && delNode.right != null){
                // 找到左子树的最大值节点或者右子树的最小值节点
                TreeNode leftMaxNode = delNode.left;
                TreeNode leftMaxNodeParent = delNode; // 左子树最大值节点的父节点
                while(leftMaxNode.right != null){
                    leftMaxNodeParent = leftMaxNode;
                    leftMaxNode = leftMaxNode.right;
                }
                // 先切断左子树最大值节点和其父节点的关系
                if(leftMaxNodeParent.left == leftMaxNode){
                    leftMaxNodeParent.left = leftMaxNode.left;
                }else{
                    leftMaxNodeParent.right = leftMaxNode.left;
                }
                leftMaxNode.right = delNode.right;
                if(leftMaxNodeParent != delNode){
                    // 左子树最大值节点的父节点不是要删除的节点 leftMaxNodeParent != delNode
                    // 或者 左边最大值不是要删除节点的左孩子节点 leftMaxNode != delNode.left
                    leftMaxNode.left = delNode.left;
                }
                if(delNode == root){ // 删除根节点，将左边最大值的节点变为根节点
                    root = leftMaxNode;
                }else{
                    if(parentNode.left == delNode){
                        parentNode.left = leftMaxNode;
                    }else{
                        parentNode.right = leftMaxNode;
                    }
                }

            }
        }
        return root;
    }

}
