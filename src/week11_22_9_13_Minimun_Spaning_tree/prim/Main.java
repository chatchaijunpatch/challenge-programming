package week11_22_9_13_Minimun_Spaning_tree.prim;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    static  ArrayList<Edge> EdgeList;
    static  int parent[];
    static int n;
    static  int size[];
    public static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int weight;

        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.weight = w;
        }
    }
    public static  class Neighbor{
        int v;
        int weight;


        Neighbor(int v, int w) {
            this.v = v;
            this.weight = w;
        }
    }
    static class Graph{
        ArrayList<LinkedList<Neighbor>> adj;
        PriorityQueue<Edge> PQ;
        ArrayList<Edge>MST;
        boolean marked[];
        int n;

        public Graph(int n) {
            this.n = n;
            adj = new ArrayList<LinkedList<Neighbor>>();
            for (int i = 0; i < n; i++) {
                adj.add(new LinkedList<Neighbor>());
            }
        }
        public void addEdge(int u, int v, int w){
            adj.get(u).add(new Neighbor(v,w));
            adj.get(v).add(new Neighbor(u,w));
        }
        public void visit(int s){
            marked[s] =true;
            for(Neighbor e : adj.get(s)){
                if (!marked[e.v]) PQ.add(new Edge(s,e.v,e.weight));
            }

        }

        public void  findMST(int s){
            PQ = new PriorityQueue<Edge>();
            MST = new ArrayList<Edge>();
            marked = new boolean[n];
            visit(s);
            while (!PQ.isEmpty() && MST.size() <= n-1){
                Edge e =  PQ.poll();
                int u = e.u;
                int v = e.v;
                int w = e.weight;
                if (marked[u] && marked[v]) continue;
                MST.add(e);
                if (!marked[v]) visit(v);
                if (!marked[u]) visit(u);
            }
            System.out.println("Edges in MST are as follows");
            for (Edge e : MST){
                System.out.println("("+e.u+","+e.v+")"+ "With weight = "+e.weight);
            }
        }



    }
    public static void main(String[] args) {
        n = 5;
        // 1 2 5
        // 1 3 5
        Graph g1 =new Graph(n);
        g1.addEdge(0,1,5);
        g1.addEdge(0,2,5);
        g1.addEdge(0,3,5);
        g1.addEdge(0,4,5);
        g1.addEdge(2,3,8);
        g1.addEdge(3,4,8);
        g1.findMST(0);

    }
}
