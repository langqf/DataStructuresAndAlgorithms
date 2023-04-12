package lang.tree;

import java.util.Scanner;

public class BinaryTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the characters to build the binary tree: ");
        String input = sc.nextLine();
        BinaryTree tree = new BinaryTree();
        // FBDCEAG 小于根放左子树，大于根放右子树
        for (int i = 0; i < input.length(); i++) {
            tree.insert(input.charAt(i));// 小于根放左子树，大于根放右子树，方便中序遍历时，按顺序输出
        }
        System.out.print("Inorder traversal of the constructed binary tree: ");
        tree.inorder();// 中序遍历
    }

    Node root;

    BinaryTree() {
        root = null;
    }

    void insert(char key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, char key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }


}
