package lang.graph;

/**
 * Adjacency Matrix Graph 邻接矩阵
 *  有向网/无向网  有弧顶点为权， 无弧顶点间 权为最大值
 *  有向图/无向图  有边顶点权为1，无边顶点间 权为0，
 * V 顶点(vertex)  A 弧(arc)
 * 邻接矩阵（一维数组+二维数组）
 * 			优点：
 * 				直观、简单、好理解
 * 				方便检查任意一对顶点间是否存在边
 * 				方便找任一顶点的所有 邻接点
 * 				方便计算任一顶点的度
 * 					无向图：对应行（列）非0元素个数
 * 					有向图：对应行非0元素的个数为 “出度”
 * 							对应列非0元素的个数为 “入度”
 * 			缺点：
 * 				不便于新增和删除顶点
 * 				浪费空间，存稀疏图（点很多，边很少）有大量无效元素，对稠密图（特别是完全图）还是很合算的
 * 				浪费时间：统计稀疏图中一共有多少条边
 */
public class AMGraph<V, A> {
    // 顶点数
//    private int verNum;
    // 边/弧数
    private int arcNum;
    // 顶点数组
    private V[] vers;
    // 边/弧数组
    private A[][] arcs;

    public AMGraph(int arcNum, V[] vers, A[][] arcs) {
        this.arcNum = arcNum;
        this.vers = vers;
        this.arcs = arcs;
    }

    public int getArcNum() {
        return arcNum;
    }

    public void setArcNum(int arcNum) {
        this.arcNum = arcNum;
    }

    public V[] getVers() {
        return vers;
    }

    public void setVers(V[] vers) {
        this.vers = vers;
    }

    public A[][] getArcs() {
        return arcs;
    }

    public void setArcs(A[][] arcs) {
        this.arcs = arcs;
    }
}
