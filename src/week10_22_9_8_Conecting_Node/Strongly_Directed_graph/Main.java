package week10_22_9_8_Conecting_Node.Strongly_Directed_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static class AdjList {
        final int INF = Integer.MAX_VALUE;
        int n;
        int visit[];
        Stack<Integer> S;
        int dfs_num[];
        int dfs_low[];

        boolean articulation[];
        int time_step;
        ArrayList<LinkedList<Integer>> adj;

        public AdjList(int n) {
            this.n = n;
            adj = new ArrayList<LinkedList<Integer>>();
            for (int i = 0; i < n; i++) {
                adj.add(new LinkedList<Integer>());
            }
        }

        public void addEdge(int u, int v) {
            // Add biderectional edge
            adj.get(u).add(v);
        }

        public void printGraph() {
            for (int i = 0; i < n; i++) {
                System.out.print("[" + i + "] : ");
                for (Integer v : adj.get(i)) {
                    System.out.print(v + "->");
                }
                System.out.println("Null");
            }
        }

        void DFSinit(int s) {
            dfs_num = new int[n];
            visit = new int[n];
            dfs_low = new int[n];
            S = new Stack<>();

            articulation = new boolean[n];
            for (int u = 0; u < n; u++) {
                dfs_low[u] = INF;
                visit[u] = 0;
                dfs_num[u] = INF;
                articulation[u] = false;
            }

            time_step = 0;
            DFSvisit(s);
            for (int u = 0; u < n; u++) {
                if (articulation[u] == true)
                    System.out.println("An articulation point is founded at vertex " + u);
            }


        }

        void DFSvisit(int u) {
            //visit u
            dfs_num[u] = time_step;
            dfs_low[u] = time_step;
            S.add(u);
            visit[u] = 1;
            time_step++;
            for (Integer v : adj.get(u)) {
                if (dfs_num[v] == INF) // if v is not visited
                {

                    DFSvisit(v);
                } else // v is already visited
                {
                    if (visit[v] == 1) //if a back edge is found
                    {
                        dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
                    }
                }


            }
            if (dfs_low[u] == dfs_num[u]) // if we are at root node and found SCC
            {
                System.out.print("An SCC is found: ");
                while (true){
                    int t = S.pop();
                    visit[t] = 0;
                    System.out.print(t);
                    if (t == u) break;
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        AdjList G = new AdjList(8);
        G.addEdge(0,1);
        G.addEdge(1,3);
        G.addEdge(3,4);
        G.addEdge(3,2);
        G.addEdge(2,1);
        G.addEdge(4,5);
        G.addEdge(5,7);
        G.addEdge(7,6);
        G.addEdge(6,4);
        G.printGraph();
        G.DFSinit(0);
    }
}
