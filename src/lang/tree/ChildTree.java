package lang.tree;

/**
 *
 * 孩子链表法树结构：
 * 			每个节点都构建一个链表，存储其孩子节点
 * 			和HashMap的数据结构类型 数组+链表存储
 * 				0	A  ——>1
 * 				1	B  ——>2——>3
 * 				2   C  ——> null
 * 				3   D  ——> null
 * 	特点：找孩子都容易，找双亲难
 * 	其实，ChildParentNode对象加上双亲下标，找双亲也容易了
  */
public class ChildTree {
    int r; // 根节点下标
    int n; // 节点数量
    ChildParentNode[] pt; // 双亲节点对象 该数组大小为n

    public ChildTree(int r, int n, ChildParentNode pn) {
        this.r = r;
        this.n = n;
        this.pt = new ChildParentNode[n];
        this.pt[r] = pn;// 根节点元素
    }
}
