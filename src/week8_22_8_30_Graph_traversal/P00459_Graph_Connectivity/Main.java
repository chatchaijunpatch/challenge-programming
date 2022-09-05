package week8_22_8_30_Graph_traversal.P00459_Graph_Connectivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//Not Done
public class Main {
    Scanner sc = new Scanner(System.in);

    void go() throws Exception {
//        Scanner sc = new Scanner(new FileInputStream("src/in.txt"));
        ArrayList<Integer> result = new ArrayList<Integer>();
        int count = Integer.parseInt(sc.nextLine());
        String dum = sc.nextLine();
        AdjacencyList G = new AdjacencyList('A');
        int start = 0;
        for (int i = 0; i < count; i++) {
//            c = sc.readLine();
//            System.out.println(c);
            while (sc.hasNextLine()) {
                String c = sc.nextLine();
//                System.out.println(c);
                if (c.isEmpty()) break;
                if (start == 0) {
//                    System.out.println("EEE");
                    G = new AdjacencyList(c.charAt(0));
                    start = 1;
                } else {
                    G.AddEdge(c.charAt(0), c.charAt(1));
                }

            }
            start = 0;
            G.DFSinit(0);
            G.traverseAllComponent();
            result.add(G.count_component);
//            System.out.println(G.count_component);
//            System.out.println();
        }
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                System.out.println(result.get(i));
            } else {
                System.out.println(result.get(i));
                System.out.println();
            }
        }
//        int count = sc.nextInt();
//
//        for (int i = 0; i < count; i++) {
//            String a = sc.next();
//            while (!a.equals(" ")){
//                a = sc.next();
//
//            }
//        }
//        AdjacencyList G = new AdjacencyList('E');
//        G.AddEdge('A','B');
//        G.AddEdge('C','E');
//        G.AddEdge('D','B');
//        G.AddEdge('E','C');
//        G.printGraph();
//        G.DFSinit(0);
////        G.BFS(0);
//        G.traverseAllComponent();
////        G.traverseAllComponentByBFS();
//        System.out.println(G.count_component);
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
            adj.get(Firstnode - offset).add(Secondnode - offset);
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
