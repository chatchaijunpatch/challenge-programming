package week7_22_8_25_AdjacencyList_Matrix_DFS_BFS;

//uhunt problem 280

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        Scanner sc = new Scanner(System.in);
    void go() throws Exception {
//        Scanner sc = new Scanner(new FileInputStream("src/in.txt"));
        while (true) {
            int count = sc.nextInt();
            if (count == 0) break;
//            System.out.println(count);
            AdjacencyList adj = new AdjacencyList(count);
            int i = 0;
            while (true) {
                int a = sc.nextInt();
//                System.out.print(a+" ");
                if (a == 0 || i == count) break;
                while (true) {
                    int b = sc.nextInt();
//                    System.out.print(b+" ");
                    if (b == 0) break;
                    else {
                        adj.AddEdge(a, b);
                    }
                }
//                System.out.println();
                i++;
            }
//            System.out.println();
            int a = sc.nextInt();
//            System.out.print(a+" ");
            for (int j = 0; j<a;j++){
                int b = sc.nextInt();
//                System.out.print(b+ " ");
                adj.DFSinit(b);
                adj.getInVisit();
//                adj.printGraph();
            }

        }

    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }

    class AdjacencyList {
        private int n;
        private int[] visit;
        int init;
        int first;
        private ArrayList<ArrayList<Integer>> adj;

        public AdjacencyList(int n) {
            this.n = n;
            adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<Integer>());
            }
        }

        public void AddEdge(int Firstnode, int Secondnode) {
            adj.get(Firstnode).add(Secondnode);
        }

        void printGraph() {
            for (int i = 0; i <= this.n; i++) {
                System.out.print(i + ": ");
                for (int j = 0; j < adj.get(i).size(); j++) {
                    System.out.print(adj.get(i).get(j) + "->");
                }
                System.out.println();
            }
        }

        void DFS(int s) {
            if (init == 0) {

            } else {
//                System.out.println("visit : " + s);
                this.visit[s] = 1;
            }
            init = 1;
//            System.out.println("visit : "+s);
//        ArrayList<Integer> list_s = adj.
            //cost n**2
            for (int i = 0; i < adj.get(s).size(); i++) {
                //adj[s][i] == 1 เช็คว่า มีเส้นเชื่อมระหว่าง Node หรือไม่
                // visit[i] == 0 คือยังไม่ได้มีการ access
                int v = adj.get(s).get(i);
                if (visit[v] == 0) {
                    DFS(v);
                }

            }
        }

        void DFSinit(int s) {

            this.visit = new int[this.n + 1];
            for (int i = 0; i < this.n; i++) {
                visit[i] = 0;
            }

            DFS(s);
            init = 0;
        }

        public void getInVisit() {

            int count = 0;
            ArrayList<Integer> dummy = new ArrayList<>();

            int initvisit = 0;
            for (int i = 0; i < visit.length; i++) {
                if (i == 0 && initvisit == 0) {
                    initvisit = 1;
                } else {
                    if (visit[i] == 0) {
                        count += 1;
                        dummy.add(i);
                    }
                }
            }
            if (count == 0){
                System.out.println(count);
            }
            else {
                System.out.print(count + " ");
                for (int i = 0; i < dummy.size(); i++) {
                    if (i+1 == dummy.size()){
                        System.out.print(dummy.get(i));
                    }
                    else {
                        System.out.print(dummy.get(i) + " ");
                    }

                }
                System.out.println();
            }
        }
    }

}
