package week7_22_8_25_AdjacencyList_Matrix_DFS_BFS;

public class Main3 {
    public static void main(String[] args) {
//        AdjacencyMatrix adj = new AdjacencyMatrix(5);
//        adj.SetEdge(0,1);
//        adj.printGraph();
//        AdjacencyList adj = new AdjacencyList(5);
//        adj.SetEdge(0,1);
//        adj.printGraph();
        //DFS
//        AdjacencyMatrix G = new AdjacencyMatrix(5);
//        G.SetEdge(0,1);
//        G.SetEdge(0,3);
//
//        G.SetEdge(1,2);
//
//        G.SetEdge(1,4);
//
//        G.SetEdge(2,1);
//
//        G.SetEdge(2,4);
//
//        G.SetEdge(4,3);
//        G.printGraph();
//        G.DFSinit(0);

        AdjacencyList G = new AdjacencyList(5);
        G.SetEdge(0,1);
        G.SetEdge(0,3);

        G.SetEdge(1,2);

        G.SetEdge(1,4);

        G.SetEdge(2,1);

        G.SetEdge(2,4);

        G.SetEdge(4,3);
        G.printGraph();
        G.DFSinit(0);



    }
}
