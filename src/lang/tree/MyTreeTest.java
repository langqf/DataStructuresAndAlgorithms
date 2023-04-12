package lang.tree;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 *                 A
 *              B
 *         C       D
 *       1  2   E     F
 *                G
 */
public class MyTreeTest {
    public static void main(String[] args) throws IOException {
        System.out.println("开始通过数组构建一棵二叉树");
        Object[] arr = new Object[]{5,1,4,null,null,3,6};
        System.out.println("构建的二叉树层次遍历:");
        TreeNode<Object> root = TreeTool.createTree(arr);
        TreeTool.levelOrderByQueue(root);
        System.out.println();
        String s1 = "ABC##DE#G##F###";
        String s = "ABC1##2##DE#G##F###";
        TreeNode<Character> tree1 = TreeTool.createTree1(s);
        TreeTool.preOrderTraverse(tree1); // ABC12DEGF
        System.out.println("\n前序遍历");
        TreeTool.preOrderTraverseByStack(tree1); // ABC12DEGF
        System.out.println();
        TreeTool.inOrderTraverseByStack1(tree1); // 1C2BEGDFA
        System.out.println("\n中序遍历");
        TreeTool.inOrderTraverse(tree1); // 1C2BEGDFA
        System.out.println();
        TreeTool.postOrderTraverse(tree1); // 12CGEFDBA
        System.out.println("\n后序遍历");
        TreeTool.postOrderTraverseByStack(tree1); // 12CGEFDBA
        System.out.println("\n层次遍历");
        TreeTool.levelOrderByQueue(tree1);  // ABCD12EFG
        TreeNode targetTree = TreeTool.copy(tree1);
        System.out.println("\n前序遍历");
        TreeTool.preOrderTraverse(targetTree);
        System.out.println("\n节点总数");
        int nums = TreeTool.countNode(targetTree);
        System.out.println(nums);
        System.out.println("叶子节点总数");
        int numsLeaf = TreeTool.countLeafNode(targetTree);
        System.out.println(numsLeaf);
/*        System.out.println("开始构建哈夫曼树：");
        HuffmanNode[] huffmanTree = TreeTool.createHuffmanTree(Arrays.asList(5,29,7,8,14,23,3,11));
        for (int i = 0; i < huffmanTree.length; i++) {
            if(huffmanTree[i] != null){
                System.out.println(huffmanTree[i].toString(i));
            }
        }*/
        /*System.out.println("开始构建哈夫曼树：");
        HuffmanNode[] huffmanTree1 = TreeTool.createHuffmanTree(Arrays.asList(7,19,2,6,32,3,21,10));
        for (int i = 0; i < huffmanTree1.length; i++) {
            if(huffmanTree1[i] != null){
                System.out.println(huffmanTree1[i].toString(i));
            }
        }*/
        System.out.println("开始构建哈夫曼编码树：");
        // [{'A',0.4},{'B',0.3},{'C',0.15},{'D',0.05},{'E',0.04},{'F',0.03},{'G',0.03},}]
        HuffmanPair pA = new HuffmanPair('A', 0.4f);
        HuffmanPair pB = new HuffmanPair('B', 0.3f);
        HuffmanPair pC = new HuffmanPair('C', 0.15f);
        HuffmanPair pD= new HuffmanPair('D', 0.05f);
        HuffmanPair pE = new HuffmanPair('E', 0.04f);
        HuffmanPair pF = new HuffmanPair('F', 0.03f);
        HuffmanPair pG = new HuffmanPair('G', 0.03f);
        HuffmanCodeNode[] huffmanCodeTree = TreeTool.createHuffmanCodeTree(Arrays.asList(pA, pB, pC, pD, pE, pF, pG));
        for (int i = 0; i < huffmanCodeTree.length; i++) {
            if(huffmanCodeTree[i] != null){
                System.out.println(huffmanCodeTree[i].toString(i));
            }
        }
        // 通过哈夫曼树求哈夫曼编码集，加密，解密
        // A '0'
        // B '11'
        // C '101'
        // D '10011'
        // E '10010'
        // F '10001'
        // G '10000'
        Map<Character, String> huffmanCodeMap = TreeTool.getHuffmanCodeList(huffmanCodeTree);
        System.out.println(huffmanCodeMap);
        String source = "FEDGDEAB";
        String target = "";
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            target += huffmanCodeMap.get(chars[i]);
        }
        System.out.println(target); // 100011001010011100001001110010011
        String cryde = "100011001010011100001001110010011";
        String decode = TreeTool.decodeByHuffmanCodeTree(huffmanCodeTree, cryde);
        System.out.println("哈夫曼树译码结果：" + decode);
        /*  通过map解码，效率太低
        String result = "";
        while(!cryde.equals("")){
            for (Character c : huffmanCodeMap.keySet()) {
                String val = huffmanCodeMap.get(c);
                if(cryde.startsWith(val)){
                    result += c;
                    cryde = cryde.substring(val.length());
                }
            }
        }
        System.out.println(result);// FEDGDEAB
        */


//        TreeNode<Character> tree2 = TreeTool.createTree2();
    }

}
