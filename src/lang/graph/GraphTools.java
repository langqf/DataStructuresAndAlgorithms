package lang.graph;

import java.util.LinkedList;

public class GraphTools {

    /** 邻接矩阵 图的遍历 深度遍历DFS Depth_First Search   时间复杂度O(n^2)
     * @param visited  记录顶点是否访问过
     * @param i  从第几个顶点开始遍历
     */
    public static void dfsAMGraph(AMGraph<String, Integer> amG, int[] visited, int i){
        String[] vers = amG.getVers();
        if(i < 0 || i > vers.length -1){
            throw new IndexOutOfBoundsException("顶点不存在");
        }
        String ver = vers[i];
        System.out.print(ver+"、");
        visited[i] = 1;
        Integer[][] arcs = amG.getArcs();
        for (int j = 0; j < arcs[i].length; j++) {
            if(arcs[i][j] != 0 && visited[j] != 1){ // i,j两顶点间有边 && j顶点没有访问过
                dfsAMGraph(amG, visited, j);
            }
        }
    }

    /** 邻接矩阵 图的遍历 广度遍历BFS Breadth_First Search 时间复杂度O(n^2)
     * @param inQueue  记录顶点是否已入队
     * @param visited 记录顶点是否访问过
     * @param i 从第几个顶点开始遍历
     */
    public static void bfsAMGraph(AMGraph<String, Integer> amG, int[] inQueue, int[] visited, int i){
        String[] vers = amG.getVers();
        if(i < 0 || i > vers.length -1){
            throw new IndexOutOfBoundsException("顶点不存在");
        }
        LinkedList<Integer> queue = new LinkedList();
        queue.offer(i);
        inQueue[i] = 1;
        while(!queue.isEmpty()){
            i = queue.poll();
            String ver = vers[i];
            System.out.print(ver+"、");
            visited[i] = 1;
            Integer[][] arcs = amG.getArcs();
            for (int j = 0; j < arcs[i].length; j++) {
                if(arcs[i][j] != 0 && inQueue[j] != 1 && visited[j] != 1 ){ // i,j两顶点间有边 && j顶点没入队 && j顶点没有访问过
                    queue.offer(j);
                    inQueue[j] = 1;
                }
            }
        }
    }

    /**  创建一个邻接矩阵表示的无向图
     *   V1---------v2
     *   |       /  |
     *   |    v3    |
     *   |  /   \   |
     *  v4        v5
     *  --               --
     *  |  0  1  0  1  0  |
     *  |  1 0   1  0  1  |
     *  |  0  1  0  1  1  |
     *  |  1  0  1  0  0  |
     *  |  0  1  1  0  0  |
     *  --               --
     */
    public static AMGraph createAMGraph(){
        int n = 5;
        String[] vers = new String[n];
        vers[0] = "V1";
        vers[1] = "V2";
        vers[2] = "V3";
        vers[3] = "V4";
        vers[4] = "V5";
        Integer[][] arcs = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arcs[i][j] = 0;
            }
        }
        arcs[0][1] = arcs[1][0] = 1;
        arcs[0][3] = arcs[3][0] = 1;
        arcs[1][2] = arcs[2][1] = 1;
        arcs[1][4] = arcs[4][1] = 1;
        arcs[2][3] = arcs[3][2] = 1;
        arcs[2][4] = arcs[4][2] = 1;
        AMGraph<String, Integer> g = new AMGraph<>(6, vers, arcs);
        return g;
    }

    /** 邻接表 图的遍历 深度遍历DFS Depth_First Search   时间复杂度O(n+e)
     * @param visited  记录顶点是否访问过
     * @param i  从第几个顶点开始遍历
     */
    public static void dfsALGraph(ALGraph<String, Object> alG, int[] visited, int i){
        ALGraph.VerNode[] vers = alG.getVerNodes();
        if(i < 0 || i > vers.length -1){
            throw new IndexOutOfBoundsException("顶点不存在");
        }
        ALGraph.VerNode node = vers[i];
        System.out.print(node.getVal() + "、");
        visited[i] = 1;
        ALGraph.ArcNode arcNode = node.getFirstArcNode();
        while(arcNode != null){
            if(visited[arcNode.getI()] != 1){
                dfsALGraph(alG, visited, arcNode.getI());
            }
            arcNode = arcNode.getNext();
        }
    }

    /** 邻接表 图的遍历 广度遍历BFS Breadth_First Search 时间复杂度O(n+e)
     * @param inQueue  记录顶点是否已入队
     * @param visited 记录顶点是否访问过
     * @param i 从第几个顶点开始遍历
     */
    public static void bfsALGraph(ALGraph<String, Object> alG, int[] inQueue, int[] visited, int i){
        ALGraph.VerNode[] vers = alG.getVerNodes();
        if(i < 0 || i > vers.length -1){
            throw new IndexOutOfBoundsException("顶点不存在");
        }
        LinkedList<Integer> queue = new LinkedList();
        queue.offer(i);
        inQueue[i] = 1;
        while(!queue.isEmpty()){
            i = queue.poll();
            System.out.print(vers[i].getVal() +"、");
            visited[i] = 1;
            ALGraph.ArcNode arcNode = vers[i].getFirstArcNode();
            while(arcNode != null){
                int j = arcNode.getI();
                if(visited[j] != 1 && inQueue[j] != 1){
                    queue.offer(j);//  j顶点没入队 && j顶点没有访问过
                    inQueue[j] = 1;
                }
                arcNode = arcNode.getNext();
            }
        }
    }

    /**  创建一个邻接表表示的无向图
     *   V1---------v2
     *   |       /  |
     *   |    v3    |
     *   |  /   \   |
     *  v4        v5
     *    数组
     *  v1 0--1--3
     *  v2 1--0--2--4
     *  v3 2--1--3--4
     *  v4 3--0--2
     *  v5 4--1--2
     *
     */
    public static ALGraph createALGraph(){
        int n = 5;
        ALGraph.VerNode<String>[] verNodes = new ALGraph.VerNode[n];
        for (int i = 0; i < n; i++) {
            verNodes[i] = new ALGraph.VerNode(null, null);
        }
        verNodes[0].setVal("V1");
        ALGraph.ArcNode firstArcNode0_1 = new ALGraph.ArcNode(3, null, null);
        ALGraph.ArcNode firstArcNode0 = new ALGraph.ArcNode(1, firstArcNode0_1, null);
        verNodes[0].setFirstArcNode(firstArcNode0);
        verNodes[1].setVal("V2");
        ALGraph.ArcNode firstArcNode1_2 = new ALGraph.ArcNode(4, null, null);
        ALGraph.ArcNode firstArcNode1_1 = new ALGraph.ArcNode(2, firstArcNode1_2, null);
        ALGraph.ArcNode firstArcNode1 = new ALGraph.ArcNode(0, firstArcNode1_1, null);
        verNodes[1].setFirstArcNode(firstArcNode1);
        verNodes[2].setVal("V3");
        ALGraph.ArcNode firstArcNode2_2 = new ALGraph.ArcNode(4, null, null);
        ALGraph.ArcNode firstArcNode2_1 = new ALGraph.ArcNode(3, firstArcNode2_2, null);
        ALGraph.ArcNode firstArcNode2 = new ALGraph.ArcNode(1, firstArcNode2_1, null);
        verNodes[2].setFirstArcNode(firstArcNode2);
        verNodes[3].setVal("V4");
        ALGraph.ArcNode firstArcNode3_1 = new ALGraph.ArcNode(2, null, null);
        ALGraph.ArcNode firstArcNode3 = new ALGraph.ArcNode(0, firstArcNode3_1, null);
        verNodes[3].setFirstArcNode(firstArcNode3);
        verNodes[4].setVal("V5");
        ALGraph.ArcNode firstArcNode4_1 = new ALGraph.ArcNode(2, null, null);
        ALGraph.ArcNode firstArcNode4 = new ALGraph.ArcNode(1, firstArcNode4_1, null);
        verNodes[4].setFirstArcNode(firstArcNode4);

        ALGraph<String, Object> g = new ALGraph<>(6, verNodes);
        return g;
    }
}
