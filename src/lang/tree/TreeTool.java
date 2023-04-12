package lang.tree;

import java.util.*;

public class TreeTool {

    public static int index = 0; // 记录要处理元素位置

    // 通过数组树构建一棵二叉链表树，数组中元素按照完全二叉树序号编排 [5,1,4,null,null,3,6] 为null，说明该处无节点， 不使用0下标
    public static TreeNode createTree(Object[] obj){
        if(obj == null || obj.length == 0){
            return null;
        }
        TreeNode[] arr = new TreeNode[obj.length + 1];
        for (int i = 0; i < obj.length; i++) {
            if(obj[i] != null){
                arr[i + 1] = new TreeNode(obj[i]);
            }else{
                arr[i + 1] = null;
            }
        }
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != null){
                if((2*i) < arr.length){
                    arr[i].setLeft(arr[2*i]);
                }
                if((2*i + 1) < arr.length){
                    arr[i].setRight(arr[2*i + 1]);
                }
            }
        }
        return arr[1];
    }

    // 通过 先序遍历序列 ABC##DE#G##F### 构造一棵二叉树，#表示此处元素为空
    public static TreeNode<Character> createTree1(String s){
        if(index >= s.length() -1){
            return null;
        }
        char c = s.charAt(index);
        if(c  == '#'){
            return null;
        }else{
            TreeNode t = new TreeNode<>(c);
            index++;
            t.setLeft(createTree1(s));
            index++;
            t.setRight(createTree1(s));
            return t;
        }
    }

    // 通过输入字符，构建一颗二叉树
    public static TreeNode<Character> createTree2(){
        System.out.println("Please input a char:");
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        if(c == '#'){
            return null;
        }else{
            TreeNode<Character> t = new TreeNode<>(c);
            t.setLeft(createTree2());
            t.setRight(createTree2());
            return t;
        }
    }

    // 利用队列 层次遍历
    public static void levelOrderByQueue(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.getRoot());
            if(node.getLeft() != null){
                queue.offer(node.getLeft());
            }
            if(node.getRight() != null){
                queue.offer(node.getRight());
            }
        }
    }

    // 先序(根左右)遍历 递归
    public static void preOrderTraverse(TreeNode tree){
        System.out.print(tree.getRoot());
        if(tree.getLeft() != null){
            preOrderTraverse(tree.getLeft());
        }
        if(tree.getRight() != null){
            preOrderTraverse(tree.getRight());
        }
    }

    // 先序(根左右)遍历 使用栈
    public static void preOrderTraverseByStack(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()){
            TreeNode curNode = st.peek();
            st.pop(); // 根出栈
            System.out.print(curNode.getRoot());
            if(curNode.getRight() != null){ // 右孩子入栈
                st.push(curNode.getRight());
            }
            if(curNode.getLeft() != null){ // 左孩子入栈
                st.push(curNode.getLeft());
            }
        }
    }

    // 中序(左根右)遍历 递归 Recursion
    public static void inOrderTraverse(TreeNode tree){
        if(tree.getLeft() != null){
            inOrderTraverse(tree.getLeft());
        }
        System.out.print(tree.getRoot());
        if(tree.getRight() != null){
            inOrderTraverse(tree.getRight());
        }
    }

    // 中序(左根右)遍历 使用栈 网上代码
    // 这个代码的思路是使用一个栈来模拟递归过程，先将根节点和其左子树的所有节点都压入栈中，
    // 然后弹出栈顶元素并输出，再将其右子树的所有节点压入栈中，重复这个过程直到栈为空
    public static void inOrderTraverseByStack(TreeNode root){
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            System.out.print(current.getRoot() + " ");
            current = current.getRight();
        }
    }

    // 中序(左根右)遍历 使用栈 自己写的
    public static void inOrderTraverseByStack1(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        TreeNode curNode = root;
        while(!st.empty() || curNode != null){
            if(curNode != null){ // 将根节点和左子树入栈
                st.push(curNode);
                curNode = curNode.getLeft();
            }else{ // 左子树到达叶子节点后，弹出栈顶元素，将右子树入栈
                TreeNode pop = st.pop();
                System.out.print(pop.getRoot());
                curNode = pop.getRight();
            }
            // 下面这种是第一次写的，可以运行
            /*
            Stack<TreeNode> st = new Stack<>();
            TreeNode curNode = root;
            st.push(root);
            while(!st.empty() || curNode != null){
            if(curNode == null || curNode.getLeft() == null){ // 当前节点为空 或者 左孩子为空  出栈
                TreeNode top = st.pop();
                System.out.print(top.getRoot());
                curNode = top.getRight(); // 右孩子变为当前节点
                if(top.getRight() != null){ // 右孩子不为空 入栈
                    st.push(top.getRight());
                }
            }else if(curNode.getLeft() != null){ // 左孩子不为空入栈
                st.push(curNode.getLeft());
                curNode = curNode.getLeft();
            }*/
        }
    }

    // 后序(左右根)遍历 递归
    public static void postOrderTraverse(TreeNode tree){
        if(tree.getLeft() != null){
            postOrderTraverse(tree.getLeft());
        }
        if(tree.getRight() != null){
            postOrderTraverse(tree.getRight());
        }
        System.out.print(tree.getRoot());
    }

    // 后序(左右根)遍历 使用栈 网上代码
    public static void postOrderTraverseByStack1(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode prev = null; // 记录上一个出栈的节点
        while(!st.isEmpty()){
            TreeNode curr = st.peek();
            if(
                    (curr.getLeft() == null && curr.getRight() == null)
                || (prev != null && (prev == curr.getLeft() || prev == curr.getRight()))
            ){
                st.pop();
                System.out.print(curr.getRoot());
                prev = curr;
            }else{
                if(curr.getRight() != null){ // 右孩子不为空  入栈
                    st.push(curr.getRight());
                }
                if(curr.getLeft() != null){ // 左孩子不为空，入栈
                    st.push(curr.getLeft());
                }
            }
        }
    }

    // 后序(左右根)遍历 使用栈   自己写的 太复杂
    public static void postOrderTraverseByStack(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        TreeNode prev = null;
        while(!st.isEmpty()){
            TreeNode curr = st.peek();
            if(
                    (curr.getLeft() == null && curr.getRight() == null)
                    || ( prev != null && (prev == curr.getLeft() || prev == curr.getRight()) )
            ){ // 左右孩子都为空  出栈
                st.pop();
                System.out.print(curr.getRoot());
                prev = curr;
                /*if(!st.isEmpty()){
                    TreeNode peek = st.peek();
                    if(peek.getRight() != null && peek.getRight() != pop){ // 栈顶元素有右孩子，并且当前出栈元素不是其右孩子
                        st.push(peek.getRight());
                        curr = peek.getRight();
                    }else{
                        curr = null;
                    }
                }*/
                if(!st.isEmpty()){
                    curr = st.peek();
                    if(curr.getRight() != null && prev != curr.getRight()){ // 右孩子不为空  入栈
                        st.push(curr.getRight());
                        curr = curr.getRight();
                    }
                }

            }else if(curr.getLeft() != null){ // 左孩子不为空，入栈
                st.push(curr.getLeft());
                curr = curr.getLeft();
            }else if(curr.getRight() != null){ // 右孩子不为空  入栈
                st.push(curr.getRight());
                curr = curr.getRight();
            }
        }
        /*Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            if(root == null || (root.getLeft() == null && root.getRight() == null)){ // root == null  || 左右孩子都为空  出栈
                TreeNode pop = st.pop();
                System.out.print(pop.getRoot());
                if(!st.isEmpty()){
                    TreeNode peek = st.peek();
                    if(peek.getRight() != null && peek.getRight() != pop){ // 栈顶元素有右孩子，并且当前出栈元素不是其右孩子
                        st.push(peek.getRight());
                        root = peek.getRight();
                    }else{
                        root = null;
                    }
                }
            }else if(root.getLeft() != null){ // 左孩子不为空，入栈
                st.push(root.getLeft());
                root = root.getLeft();
            }else if(root.getRight() != null){ // 右孩子不为空  入栈
                st.push(root.getRight());
                root = root.getRight();
            }
        }*/
    }

    // 复制二叉树 递归
    public static TreeNode copy(TreeNode sourceTree){
        if(sourceTree == null){
            return sourceTree;
        }else{
            TreeNode targetTree = new TreeNode();
            targetTree.setRoot(sourceTree.getRoot());
            targetTree.setLeft(copy(sourceTree.getLeft()));
            targetTree.setRight(copy(sourceTree.getRight()));
            return targetTree;
        }
    }

    // 计算树的深度  参考P0104  还可用非递归方式计算
    // 递归方法  DFS  max(左子树高度，右子树高度)+1
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            return Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight())) + 1;
        }
    }

    // 计算树的节点数  左子树节点数 + 右子树节点数 + 1
    public static int countNode(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            return countNode(root.getLeft()) + countNode(root.getRight()) + 1;
        }
    }

    // 计算树的叶子节点数
    public static int countLeafNode(TreeNode root) {
        if(root == null){
            return 0;
        }else if(root.getLeft() == null && root.getRight() == null){
            return 1;
        }else{
            return countLeafNode(root.getLeft()) + countLeafNode(root.getRight());
        }
    }

    // 通过数组构建一棵哈夫曼树 n=8 [5,29,7,8,14,23,3,11] 哈夫曼树数组不使用0下标，大小 m= 2*n-1 + 1 = 16
    public static HuffmanNode[] createHuffmanTree(List<Integer> list) {
        int n = list.size();
        int m = 2 * n;// 哈夫曼树节点总数 = 叶子接点数*2 -1  + 1（空出来的0下标）
        HuffmanNode[] huffTree = new HuffmanNode[m];
        // 1. 前面n个节点赋初值，代表n棵二叉树
        for(int i = 1; i <= n; i++){
            huffTree[i] = new HuffmanNode(list.get(i-1), 0, 0, 0);
        }
        // 2. 每次从数组中找出2位最小的，构建新的二叉树，2位最小的节点从数组中删除，将新节点加入数组， 重复n-1次
        for (int i = n+1; i < m; i++) {
            List<Integer> minTwo = selectMinTwo(huffTree);
            HuffmanNode min1 = huffTree[minTwo.get(0)];
            HuffmanNode min2 = huffTree[minTwo.get(1)];
            huffTree[i] = new HuffmanNode(min1.getWeight() + min2.getWeight(), 0, minTwo.get(0), minTwo.get(1));// 表示新节点加入数组
            min1.setParent(i); // 表示从数组中删除
            min2.setParent(i);
        }
        return huffTree;
    }

    // 从哈夫曼树数组中选择2棵权最小的树 注意要从parent == 0中选取
    private static List<Integer> selectMinTwo(HuffmanNode[] huffTree){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            int minIndex = 0;
            HuffmanNode min = null;
            for (int j = 1; j < huffTree.length; j++) {
                if(huffTree[j] != null && huffTree[j].getParent() == 0){
                    if(min == null){
                         if(list.isEmpty() || j != list.get(0)){ // 必须初始化为没找过的元素，避免两次找到同一个最小的
                             min = huffTree[j];
                             minIndex = j;
                         }else{
                             continue;
                         }
                    }else if(huffTree[j].getWeight() <= min.getWeight() &&
                            (list.isEmpty() || j != list.get(0)) ){ // 避免两次找到同一个最小的
                        min = huffTree[j];
                        minIndex = j;
                    }
                }
            }
            list.add(minIndex);
        }
        return list;
    }

    // 通过数组构建一棵哈夫曼编码树 n=7 [{'A',0.4},{'B',0.3},{'C',0.15},{'D',0.05},{'E',0.04},{'F',0.03},{'G',0.03},}]
    public static HuffmanCodeNode[] createHuffmanCodeTree(List<HuffmanPair> list) {
        int n = list.size();
        int m = 2 * n;// 哈夫曼树节点总数 = 叶子接点数*2 -1  + 1（空出来的0下标）
        HuffmanCodeNode[] huffmanCodeTree = new HuffmanCodeNode[m];
        // 1. 前面n个节点赋初值，代表n棵二叉树
        for(int i = 1; i <= n; i++){
            HuffmanPair pair = list.get(i - 1);
            huffmanCodeTree[i] = new HuffmanCodeNode(pair.getData(),pair.getWeight(), 0, 0, 0);
        }
        // 2. 每次从数组中找出2位最小的，构建新的二叉树，2位最小的节点从数组中删除，将新节点加入数组， 重复n-1次
        for (int i = n+1; i < m; i++) {
            List<Integer> minTwo = selectMinTwo(huffmanCodeTree);
            HuffmanCodeNode min1 = huffmanCodeTree[minTwo.get(0)];
            HuffmanCodeNode min2 = huffmanCodeTree[minTwo.get(1)];
            huffmanCodeTree[i] = new HuffmanCodeNode(null,min1.getWeight() + min2.getWeight(), 0, minTwo.get(0), minTwo.get(1));// 表示新节点加入数组
            min1.setParent(i); // 表示从数组中删除
            min2.setParent(i);
        }
        return huffmanCodeTree;
    }

    // 从哈夫曼树数组中选择2棵权最小的树 注意要从parent == 0中选取
    private static List<Integer> selectMinTwo(HuffmanCodeNode[] huffCodeTree){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            int minIndex = 0;
            HuffmanCodeNode min = null;
            for (int j = 1; j < huffCodeTree.length; j++) {
                if(huffCodeTree[j] != null && huffCodeTree[j].getParent() == 0){
                    if(min == null){
                        if(list.isEmpty() || j != list.get(0)){ // 必须初始化为没找过的元素，避免两次找到同一个最小的
                            min = huffCodeTree[j];
                            minIndex = j;
                        }else{
                            continue;
                        }
                    }else if(huffCodeTree[j].getWeight() <= min.getWeight() &&
                            (list.isEmpty() || j != list.get(0)) ){ // 避免两次找到同一个最小的
                        min = huffCodeTree[j];
                        minIndex = j;
                    }
                }
            }
            list.add(minIndex);
        }
        return list;
    }

    // 根据哈夫曼编码树获取哈夫曼编码集
    public static Map<Character,String> getHuffmanCodeList(HuffmanCodeNode[] huffmanCodeTree){
        Map<Character, String> result = new HashMap<>();
        int n = huffmanCodeTree.length/2;
        for (int i = 1; i <= n; i++) {
            String code = "";
            HuffmanCodeNode huffmanCodeNode = huffmanCodeTree[i];
            Character key = huffmanCodeNode.getData();
            int index = i;
            while(huffmanCodeNode.getParent() != 0){
                HuffmanCodeNode parentNode = huffmanCodeTree[huffmanCodeNode.getParent()];
                if(parentNode.getLch() == index){
                    code = "0" + code;
                }else if(parentNode.getRch() == index){
                    code = "1" + code;
                }
                index = huffmanCodeNode.getParent();
                huffmanCodeNode = parentNode;
            }
            result.put(key, code);
        }
        return result;
    }

    // 根据哈夫曼编码树 译码  100011001010011100001001110010011
    public static String decodeByHuffmanCodeTree(HuffmanCodeNode[] huffmanCodeTree, String code){
        StringBuffer result = new StringBuffer();
        char[] chars = code.toCharArray();
        HuffmanCodeNode root = null;
        for (int i = 1; i < huffmanCodeTree.length; i++) {
            if(huffmanCodeTree[i].getParent() == 0){
                root = huffmanCodeTree[i];
            }
        }
        HuffmanCodeNode curr = root;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '0'){
                int lch = curr.getLch();
                curr = huffmanCodeTree[lch];
            }else if(chars[i] == '1'){
                int rch = curr.getRch();
                curr = huffmanCodeTree[rch];
            }else{
                System.out.println("非常规字符");
            }
            // 左右孩子都为空，到达叶子节点 获取叶子节点原字符，当前节点重置为根节点
            if(Integer.valueOf(0).equals(curr.getLch()) && Integer.valueOf(0).equals(curr.getRch()) ){
                result.append(curr.getData());
                curr = root;
            }
        }
        return result.toString();
    }
}
