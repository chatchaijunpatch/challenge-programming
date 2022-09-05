package week7_22_8_25_AdjacencyList_Matrix_DFS_BFS;

import java.util.ArrayList;

public class AdjacencyList {
    private  int n;
    int[] visit;
    private ArrayList<ArrayList<Integer>> adj;

    public AdjacencyList(int n) {
        this.n = n;
        adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }
    public void SetEdge(int Firstnode,int Secondnode){
        adj.get(Firstnode).add(Secondnode);
    }
    void  printGraph(){
        for (int i = 0; i < n; i++) {
            System.out.print(i+": ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j)+"->");
            }
            System.out.println();
        }
    }
    void DFS(int s){
        //set node แรกที่เลือกมาเป็น visit
        visit[s] = 1;
        System.out.println("visit : "+s);
//        ArrayList<Integer> list_s = adj.
        //cost n**2
        for (int i = 0; i < adj.get(s).size(); i++) {
            //adj[s][i] == 1 เช็คว่า มีเส้นเชื่อมระหว่าง Node หรือไม่
            // visit[i] == 0 คือยังไม่ได้มีการ access
            int v = adj.get(s).get(i);
            if (visit[v]==0){
                DFS(v);
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
}
