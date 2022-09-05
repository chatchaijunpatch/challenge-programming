package week7_22_8_25_AdjacencyList_Matrix_DFS_BFS;

public class AdjacencyMatrix {
    private int n;
    private int[][] adj;
    int[] visit;


    public AdjacencyMatrix(int n) {
        this.n = n;
        adj = new int[n][n];
        setGraph(n);
    }
    public void SetEdge(int FirstNode, int SecondNode){
        adj[FirstNode][SecondNode] = 1;
    }
    void setGraph(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = 0;
            }
        }
    }
    void DFS(int s){
        //set node แรกที่เลือกมาเป็น visit
        visit[s] = 1;
        System.out.println("visit : "+s);
        //cost n**2
        for (int i = 0; i < n; i++) {
            //adj[s][i] == 1 เช็คว่า มีเส้นเชื่อมระหว่าง Node หรือไม่
            // visit[i] == 0 คือยังไม่ได้มีการ access
            if ((adj[s][i]==1)&& visit[i]==0){
                DFS(i);
            }

        }

    }
    void DFSinit(int s){
        visit = new  int[n]; // สร้างการ visit ขึ้นมา
        //set ค่า visit
        for (int i = 0; i < n; i++) {
            visit[i] = 0;
        }
        DFS(s);
    }
    void printGraph(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j]);
            }
            System.out.println();
        }
    }

}
