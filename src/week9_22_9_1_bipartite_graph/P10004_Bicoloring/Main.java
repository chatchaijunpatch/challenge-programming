package week9_22_9_1_bipartite_graph.P10004_Bicoloring;
//

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    void go() throws Exception {
//        Scanner sc = new Scanner(new FileInputStream("src/in.txt"));
        while (true){
            int a = sc.nextInt();
            if (a == 0) break;
            AdjacencyMatrix al = new AdjacencyMatrix(a);
            int b  = sc.nextInt();
            for (int i = 0; i < b; i++) {
                int c = sc.nextInt();
                int d = sc.nextInt();
                if (c != d) al.AddEdge(c,d);
            }
            if (al.DFSinit(0,1)){
                System.out.println("BICOLORABLE.");
            }
            else System.out.println("NOT BICOLORABLE.");
        }
    }
    public static class AdjacencyMatrix {
        private int n;
        private boolean[][] adj;
        int[] visit;


        public AdjacencyMatrix(int n) {
            this.n = n;
            adj = new boolean[n][n];
//            setGraph(n);
        }

        public void AddEdge(int FirstNode, int SecondNode) {
            adj[FirstNode][SecondNode] = true;
            adj[SecondNode][FirstNode] = true;
        }

        void setGraph(int n) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = false;
                }
            }
        }

        boolean DFS(int s, int tofill) {
            if (visit[s] == 0) {
                boolean f = true;
                visit[s] = tofill;
                for (int i = 0; i < n; i++) {
                    if (adj[s][i]) {
                        f = DFS(i, 1 - tofill);
                    }
                }
                return f;
            } else if (visit[s] != tofill) {
                return false;
            }
            return true;
        }

        boolean DFSinit(int s, int tofill) {
            visit = new int[n]; // สร้างการ visit ขึ้นมา
            //set ค่า visit
            for (int i = 0; i < n; i++) {
                visit[i] = 0;
            }
           return DFS(s, tofill);
        }

        void printGraph() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(adj[i][j]);
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }
}
