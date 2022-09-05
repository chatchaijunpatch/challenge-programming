package week7_22_8_30.xxx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    void go() throws Exception {
//        Scanner sc = new Scanner(new FileInputStream("src/in.txt"));
//        while (true) {
//            int count = sc.nextInt();
//            if (count == 0) break;
////            System.out.println(count);
//            AdjacencyList adj = new AdjacencyList(count);
//            int i = 0;
//            while (true) {
//                int a = sc.nextInt();
////                System.out.print(a+" ");
//                if (a == 0 || i == count) break;
//                while (true) {
//                    int b = sc.nextInt();
////                    System.out.print(b+" ");
//                    if (b == 0) break;
//                    else {
//                        adj.AddEdge(a, b);
//                    }
//                }
////                System.out.println();
//                i++;
//            }
////            System.out.println();
//            int a = sc.nextInt();
////            System.out.print(a+" ");
//            for (int j = 0; j<a;j++){
//                int b = sc.nextInt();
////                System.out.print(b+ " ");
//                adj.DFSinit(b);
//                adj.getInVisit();
////                adj.printGraph();
//            }
//
//        }
        AdjacencyList adj = new AdjacencyList('Z');
        adj.AddEdge('X','Z');
        adj.AddEdge('W','X');
        adj.AddEdge('Y',' ');
        adj.AddEdge('Z','Z');
        adj.AddEdge('X','X');
        adj.AddEdge(' ','Y');
        adj.AddEdge('Z','Z');
        adj.AddEdge('X','X');
        adj.AddEdge('Y','Z');

        adj.printGraph();

    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }

    class AdjacencyList {
        private int n;
        private int[] visit;
        int offset = 65; // index A character
        private ArrayList<ArrayList<Integer>> adj;
        int count_component = 0;

        public AdjacencyList(char N) {
            int c = N;
            this.n = c - offset + 1;
            adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<Integer>());
            }
        }

        public void AddEdge(char Firstnode, char Secondnode) {
            adj.get(Secondnode - offset).add(Firstnode - offset);
        }

        void printGraph() {
            for (int i = 0; i < n; i++) {
                System.out.print(i + ": ");
                for (int j = 0; j < adj.get(i).size(); j++) {
                    System.out.print(adj.get(i).get(j) + "->");
                }
                System.out.println();
            }
        }

        void DFSinit(int s) {
            count_component++;
            visit = new int[n];
            for (int u = 0; u < n; u++) {
                visit[u] = 0;
            }
            DFS(s);
        }

        void traverseAllComponent() {
            for (int u = 0; u < n; u++) {
//                System.out.println();
                if (visit[u] == 0) {
                    DFS(u);
                    count_component++;
                }
            }
        }

        void traverseAllComponentByBFS() {
            visit = new int[n];
            for (int u = 0; u < n; u++) {
                visit[u] = 0;
            }
            for (int u = 0; u < n; u++) {
//                System.out.println();
                if (visit[u] == 0) {
                    BFS(u);
                    count_component++;
                }
            }
        }

        void BFS(int s) {
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            visit[s] = 1;
            while (!q.isEmpty()) {
                int v = q.poll();
                System.out.println("visit ->" + (char) (v + offset));
                ArrayList<Integer> list_s = adj.get(s);
                for (int i = 0; i < list_s.size(); i++) {
                    int w = list_s.get(i);
                    if (visit[w] == 0) {
                        q.add(w);
                        visit[w] = 1;
                    }
                }
            }
        }

        void DFS(int s) {
            char u = (char) (s + offset);
//            System.out.println("visit -> " + u);
            visit[s] = 1;
            ArrayList<Integer> list_s = adj.get(s);
            for (int j = 0; j < list_s.size(); j++) {
                int v = list_s.get(j);
                if (visit[v] == 0) {
                    DFS(v);
                }
            }
        }
    }

}
