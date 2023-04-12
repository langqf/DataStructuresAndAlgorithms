package lang.tree;

/** 双亲孩子表示法树结构
 *              0	A  -1
 * 				1	B  0
 * 				2   C  1
 * 				3   D  1
 * 	特点：找双亲容易，找孩子难
 */
public class ParentTree {

    int r; // 根节点下标
    int n; // 节点数量
    ParentNode[] pt; // 节点元素  该数组大小为n

    public ParentTree(int r, int n, ParentNode pn) {
        this.r = r;
        this.n = n;
        this.pt = new ParentNode[n];
        this.pt[r] = pn;// 根节点元素
    }

}
