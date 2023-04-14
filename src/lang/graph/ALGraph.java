package lang.graph;

/**
 * Adjacency Link Graph 邻接矩阵
 *  邻接表（数组+链表  类似HashMap的结构）
 * 			数组保存顶点，数组元素作为链表的头节点，链表中除头结点之外，其他节点表示顶点（头结点）关联的边
 * 			有向图中，链表中节点只保存以顶点为弧首的边（出度边），也可以保存入度边（逆邻接表）
 * 			特点：
 * 				邻接表不唯一，链表表示边的节点位置可以互换
 * 				无向图：
 * 					若无向图中有n个顶点，e条边，则其邻接表需n个头结点和2e个链表节点，适合存储稀疏图
 * 					无向图中顶点Vi的度为第i个单链表中的节点数
 * 				有向图：
 * 					找出度容易，找入度难（逆邻接表相反）
 * 						顶点vi的出度为第i个单链表中的节点个数
 * 						顶点vi的入度为整个链表中邻接点域值是i-1的节点个数
 * 					若有向图中有n个顶点，e条边，则其邻接表需n个头结点和e个链表节点
 * 			特点：
 * 				1. 方便查找任意顶点的所有邻接点（两顶点之间有边）
 * 				2. 节约稀疏图的空间
 * 				3. 方便计算任一顶点的”度“
 * 					  对无向图：是的
 * 					  对有向图：只能方便计算出度，需要构建 逆邻接表 来方便计算 入度
 * 				4. 不方便计算任意顶点间是否存在边
 * 		邻接矩阵和邻接表：
 * 			区别：
 * 				1. 对于任一确定的无向图，邻接矩阵是唯一的（行列号与顶点编号一致），
 * 				但邻接表不唯一（链接次序与顶点编号无关）
 * 				2. 邻接矩阵的空间复杂度为O(n^2)，邻接表的空间复杂度为O(n+e)
 *
 * 			 有向图----缺点：求节点的度困难-----------十字链表
 * 			/
 * 		邻接表
 * 			\
 * 			 无向图-----缺点：每条边都要存储两遍------邻接多重表
 * 		十字链表：
 * 			顶点节点：data firstin firstout
 * 				data 顶点值
 * 				firstin:以顶点为入度的第一条边
 * 				firstout:以顶点为出度的第一条边
 * 			弧节点：tailvex headvex hlink tlink
 * 				tailvex：弧尾所在数组下标
 * 				headvex: 弧头所在数组下标
 * 				hlink：	 以headvex为弧头的下一个弧节点
 * 				tlink:	 以tailvex为弧尾的下一个弧节点
 * 		邻接多重表：
 * 			顶点节点： data firstedge
 * 				data:存放顶点值
 * 				firstedge：指向第一条依附于该顶点的边
 * 			弧节点： 	mark iverx ilink jvex jlink info
 * 				mark：标记此边是否被搜索过
 * 				iverx：该边依附的两个顶点在表头数组中的位置i
 * 				ilink：指向依附于iverx的下一条边
 * 				jverx：该边依附的两个顶点在表头数组中的位置j
 * 				ilink：指向依附于jverx的下一条边
 */
public class ALGraph<V, A> {

    // 边/弧数
    private int arcNum;

    // 顶点数组
    private VerNode<V>[] verNodes;

    public ALGraph(int arcNum, VerNode<V>[] verNodes) {
        this.arcNum = arcNum;
        this.verNodes = verNodes;
    }

    public int getArcNum() {
        return arcNum;
    }

    public void setArcNum(int arcNum) {
        this.arcNum = arcNum;
    }

    public VerNode<V>[] getVerNodes() {
        return verNodes;
    }

    public void setVerNodes(VerNode<V>[] verNodes) {
        this.verNodes = verNodes;
    }

    // 链表首节点
    public static class VerNode<V>{
        // 顶点元素值
        private V val;
        // 第一个条边节点
        private ArcNode firstArcNode;

        public V getVal() {
            return val;
        }

        public void setVal(V val) {
            this.val = val;
        }

        public ArcNode getFirstArcNode() {
            return firstArcNode;
        }

        public void setFirstArcNode(ArcNode firstArcNode) {
            this.firstArcNode = firstArcNode;
        }

        public VerNode(V val, ArcNode firstArcNode) {

            this.val = val;
            this.firstArcNode = firstArcNode;
        }
    }

    // 链表节点，边节点
    public static class ArcNode<A>{
        // 表示是和哪个顶点对应的边，在verNodes中的位置
        private int i;
        // 顶点关联的下一条边
        private ArcNode<A> next;
        // 权
        private A q;

        public ArcNode(int i, ArcNode<A> next, A q) {
            this.i = i;
            this.next = next;
            this.q = q;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public ArcNode<A> getNext() {
            return next;
        }

        public void setNext(ArcNode<A> next) {
            this.next = next;
        }

        public A getQ() {
            return q;
        }

        public void setQ(A q) {
            this.q = q;
        }
    }

}
