package week7_22_8_25_AdjacencyList_Matrix_DFS_BFS.P11902_Dominator;


import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
        Scanner sc = new Scanner(System.in);
    void go() throws Exception {
        Scanner sc = new Scanner(new FileInputStream("src/in.txt"));
        int count = sc.nextInt();
        for (int m = 0; m < count; m++) {
            int a = sc.nextInt();
            AdjacencyMatrix G = new AdjacencyMatrix(a);
//        System.out.println(a);
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    int b = sc.nextInt();
                    if (b == 1) {
                        G.addEdge(i, j);
                    }
                }
            }
            String[][] result = new String[a][a];
            G.DFSinit(0,-1);
            int[] visitorigin = new int[a];
            visitorigin = G.getVisit();
//            for (int k = 0; k < visitorigin.length; k++) {
//                System.out.print(visitorigin[k]);
//            }
//            System.out.println();


            for (int i = 0; i < a; i++) {
                G.DFSinit(0,i);
                int[] visited = G.getVisit();
//                for (int k = 0; k < visited.length; k++) {
//                    System.out.print(visited[k]);
//                }
//                System.out.println();
                for (int j = 0; j < a; j++) {
//                        if (i == j) result[i][j] = "Y";
//                        if (G.getAdj()[i][j] == 0 && (i!=j)) result[i][j] = "N";
//                        if (visitorigin[j] == visited[j] &&(i!=j)) result[i][j] = "N";
//                        else {
//                            result[i][j] = "Y";
//                        }
                        //1111
                        //1111
                        if (G.getAdj()[i][j] == 0) result[i][j] = "N";
                        if (visitorigin[j] == visited[j] && (G.getAdj()[i][j] == 1)) result[i][j] = "N";
                        if (visitorigin[j] == visited[j] && (G.getAdj()[i][j] == 1) && visitorigin[j] == 1) result[i][j] = "N";
                        if (visitorigin[j] != visited[j] && G.getAdj()[i][j] == 1) result[i][j] = "Y";
                        if (visitorigin[j] == visited[j] && i == j && visitorigin[j] == 1) result[i][j] ="Y";
                        if (G.getAdj()[i][j] == 0 && visitorigin[j] != visited[j]) result[i][j] = "Y";
//                        if (i == j && visitorigin[j] == 1) result[i][j] = "Y";



                }
//                System.out.println();
            }
            System.out.println("Case "+(m+1)+":");
            for (int i = 0; i < a; i++) {
                System.out.print("+");
                for (int j = 0; j < (a*2)-1; j++) {
                    System.out.print("-");
                }
                System.out.print("+");
                System.out.println();
                for (int j = 0; j < a; j++) {

                    System.out.print("|"+result[i][j]);
                }
                System.out.print("|");
                System.out.println();
            }
            System.out.print("+");
            for (int j = 0; j < (a*2)-1; j++) {
                System.out.print("-");
            }
            System.out.print("+");
            System.out.println();

        }




    }



    class AdjacencyMatrix {
        private int n;
        private int[][] adj;
        int[] visit;
        public int[] getVisit() {
            return this.visit;
        }

//        public void setAdj(int[][] adj) {
//            this.adj = adj;
//        }

        public int[][] getAdj() {
            return this.adj;
        }

        public AdjacencyMatrix(int n) {
            this.n = n;
            this.adj = new int[n][n];
            setGraph(n);

        }

        void setGraph(int n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    this.adj[i][j] = 0;
                }
            }
        }

        public void addEdge(int FirstNode, int SecondNode) {
            this.adj[FirstNode][SecondNode] = 1;
        }

//        public void SetEdge(int FirstNode, int SecondNode) {
//            this.adj[FirstNode][SecondNode] = 0;
//        }
//
//        void printGraph() {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(this.adj[i][j]);
//                }
//                System.out.println();
//            }
//        }

        void DFSinit(int s,int round) {

            this.visit = new int[n]; // สร้างการ visit ขึ้นมา\
            //set ค่า visit
            DFS(s,round);
        }

        void DFS(int s,int round) {
            //set node แรกที่เลือกมาเป็น visit
            this.visit[s] = 1;
//            System.out.println("visit : " + s);
            //cost n**2
            for (int i = 0; i < n; i++) {
                //adj[s][i] == 1 เช็คว่า มีเส้นเชื่อมระหว่าง Node หรือไม่
                // visit[i] == 0 คือยังไม่ได้มีการ access
                if ((this.adj[s][i] == 1) && this.visit[i] == 0 &&(s != round)) {
                    DFS(i,round);
                }

            }


        }

    }

    public static void main(String[] args) throws Exception{
        new Main().go();
    }

}
