package lang.graph;

public class MyGraphTest {
    public static void main(String[] args) {

        // 邻接矩阵 构建一个固定的无向图
        /*
            [V1, V2, V3, V4, V5]
            [0, 1, 0, 1, 0]
            [1, 0, 1, 0, 1]
            [0, 1, 0, 1, 1]
            [1, 0, 1, 0, 0]
            [0, 1, 1, 0, 0]
            V1---------v2
            |       /  |
            |    v3    |
            |  /   \   |
            v4        v5
         */
        AMGraph<String, Integer> amGraph = GraphTools.createAMGraph();
        /*System.out.println(Arrays.toString(amGraph.getVers()));
        for (int i = 0; i < amGraph.getArcs().length; i++) {
            System.out.println(Arrays.toString(amGraph.getArcs()[i]));
        }*/
        int[] visited1 = new int[amGraph.getVers().length];
        int start1 = 1;
        System.out.println("邻接矩阵，从第 "+(start1+1)+ " 个顶点开始深度优先搜索：");
        GraphTools.dfsAMGraph(amGraph, visited1, start1); // V2、V1、V4、V3、V5、
        System.out.println();
        int start2 = 1;
        int[] visited2 = new int[amGraph.getVers().length];
        int[] inQueue1 = new int[amGraph.getVers().length];
        System.out.println("邻接矩阵，从第 "+(start2+1)+ " 个顶点开始广度优先搜索：");
        GraphTools.bfsAMGraph(amGraph, inQueue1, visited2, start2); // V2、V1、V3、V5、V4、
        // 邻接表 构建一个固定的无向图
        /*
            V1---------v2
            |       /  |
            |    v3    |
            |  /   \   |
            v4        v5
               数组
            V1: 0--1--3
            V2: 1--0--1--4
            V3: 2--1--3--4
            V4: 3--0--2
            V5: 4--1--2
         */
        System.out.println();
        ALGraph<String, Object> alGraph = GraphTools.createALGraph();
        /*ALGraph.VerNode<String>[] verNodes = alGraph.getVerNodes();
        for (int i = 0; i < verNodes.length; i++) {
            System.out.print(verNodes[i].getVal() + ": " + i + "--");
            if(verNodes[i].getFirstArcNode() != null){
                ALGraph.ArcNode arcNode = verNodes[i].getFirstArcNode();
                System.out.print(arcNode.getI());
                while(arcNode.getNext() != null){
                    System.out.print("--" + arcNode.getNext().getI());
                    arcNode = arcNode.getNext();
                }
            }
            System.out.println();
        }*/
        System.out.println();
        int[] visited3 = new int[alGraph.getVerNodes().length];
        int start3 = 3;
        System.out.println("邻接表，从第 "+(start3+1)+ " 个顶点开始深度优先搜索：");
        GraphTools.dfsALGraph(alGraph, visited3, start3); // V4、V1、V2、V3、V5、
        System.out.println();
        int start4 = 3;
        int[] visited4 = new int[alGraph.getVerNodes().length];
        int[] inQueue2 = new int[alGraph.getVerNodes().length];
        System.out.println("邻接表，从第 "+(start4 + 1)+ " 个顶点开始广度优先搜索：");
        GraphTools.bfsALGraph(alGraph, inQueue2, visited4, start4); // V2、V1、V3、V5、V4、

    }

}
