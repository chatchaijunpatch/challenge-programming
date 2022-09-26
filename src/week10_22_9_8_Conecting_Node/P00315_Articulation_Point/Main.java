package week10_22_9_8_Conecting_Node.P00315_Articulation_Point;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

//Articulration point
public class Main {
    public static class AdjList {
        final int INF = Integer.MAX_VALUE;
        int n;
        int dfs_num[];
        int dfs_low[];
        int parent[];
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
            adj.get(v).add(u);
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

        int DFSinit(int s) {
            dfs_num = new int[n];
            dfs_low = new int[n];
            parent = new int[n];
            int count = 0;

            articulation = new boolean[n];
            for (int u = 0; u < n; u++) {
                dfs_low[u] = INF;
                dfs_num[u] = INF;
                parent[u] = INF;
                articulation[u] = false;
            }
            parent[s] = -1;
            time_step = 0;
            DFSvisit(s);
            int m = 0;
            for (int u = 0; u < n; u++) {
                if (articulation[u] == true) {
                    count += 1;
//                    System.out.println("An articulation point is founded at vertex " + u);
//                    System.out.println(count);

                   }
            }
//                System.out.println(count);

            return count;


            }

            void DFSvisit ( int u){
                //visit u
                dfs_num[u] = time_step;
                dfs_low[u] = time_step;
                time_step++;
                for (Integer v : adj.get(u)) {
                    if (dfs_num[v] == INF) // if v is not visited
                    {

                        parent[v] = u;
                        DFSvisit(v);
                        dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
                        if (dfs_num[u] <= dfs_low[v]) articulation[u] = true;
                        if (dfs_num[u] < dfs_low[v]) ;
                        //System.out.println("A bridge is founded at edge" + "(" + u + "," + v + ")");
                    } else // v is already visited
                    {
                        if (parent[u] != v) //if a back edge is found
                        {

                            dfs_low[u] = Math.min(dfs_num[v], dfs_low[u]);
                        }
                    }
                    if (parent[u] == -1) // if root is detected
                    {
                        if (adj.get(u).size() > 1) articulation[u] = true;
                        else articulation[u] = false;
                    }

                }

            }

        }

        static Scanner sc = new Scanner(System.in);

        static void go() throws Exception {
//            sc = new Scanner(new FileInputStream("src/in.txt"));
            int input = sc.nextInt();
            while (input != 0) {
//            System.out.println(input+1);
                AdjList G = new AdjList(input + 1);
//                G.addEdge(0,0);
//            System.out.print(input);
                String s = sc.nextLine();
                while (!s.equals("0")) {
                    String[] s2 = s.split(" ");

                    for (int i = 1; i < s2.length; i++) {
                        G.addEdge(Integer.parseInt(String.valueOf(s2[0])), Integer.parseInt(String.valueOf(s2[i])));
                    }
                    s = sc.nextLine();
                }
//                G.printGraph();
                ArrayList<Integer> result =  new ArrayList<Integer>();
                for (int i = 0; i < input; i++) {
                    if (G.DFSinit(i) == 0);
                    else {
                        result.add(G.DFSinit(i));
                    }
//                    System.out.println();
                }

                if (result.isEmpty()) System.out.println(0);
                else {
                    System.out.println(Collections.min(result));
                }
                input = sc.nextInt();
            }

        }

        public static void main(String[] args) throws Exception {
            new Main().go();
//        AdjList G = new AdjList(7);
//        G.addEdge(2,1);
//        G.addEdge(2,3);
//        G.addEdge(5,4);
//        G.addEdge(5,6);
//        G.addEdge(5,2);
//        G.printGraph();
//        G.DFSinit(1);
//        G.addEdge(0, 1);
//        G.addEdge(1, 2);
//        G.addEdge(1, 4);
//        G.addEdge(1, 5);
//        G.addEdge(3, 4);
//        G.addEdge(4,5);
//        G.printGraph();
//        G.DFSinit(0);
        }
    }
