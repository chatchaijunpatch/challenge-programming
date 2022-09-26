package week12_22_9_20_shortest_path.Dijkstra_algorithm;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    static int n;
    public static class DistNodeParent implements Comparable<DistNodeParent> {

        int est_dist;
        int vertex;//node
        int parent;

        public int compareTo(DistNodeParent e) {
            return this.est_dist - e.est_dist;
        }

        DistNodeParent(int est_dist, int v,int p) {
            this.est_dist = est_dist;
            this.vertex = v;
            this.parent = p;
        }
    }
    public static  class Neighbor{
        int vertex;
        int weight;


        Neighbor(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }
    }
    static class Graph{
        ArrayList<LinkedList<Neighbor>> adj;
        PriorityQueue<DistNodeParent> PQ;
        int[] dist;
        int[] parent;
        int n;
        final  int INF = Integer.MAX_VALUE;
        public Graph(int n) {
            this.n = n;
            adj = new ArrayList<LinkedList<Neighbor>>();
            for (int i = 0; i < n; i++) {
                adj.add(new LinkedList<Neighbor>());
            }
        }
        public void addEdge(int u, int v, int w){
            adj.get(u).add(new Neighbor(v,w));
        }
        public String reportShorestPath(int u){
            if (parent[u] != -1) {return reportShorestPath(parent[u])+"->"+u;}
            else {
                return " "+u;
            }
        }
        public  void findSSP(int s){
            dist = new int[n];
            parent = new int[n];
            for (int u = 0; u < n; u++) {
                dist[u] = INF;
                parent[u] = -1;
            }
            dist[s] = 0;
            parent[s] = -1;
            PQ = new PriorityQueue<DistNodeParent>();
            PQ.add(new DistNodeParent(dist[s],s,parent[s]));
            while (!PQ.isEmpty()){
                DistNodeParent e = PQ.poll();
                if (e.est_dist > dist[e.vertex]) continue;

                int d = e.est_dist; // settled distance
                int u = e.vertex;
                int p = e.parent;
                parent[u] = p;
                System.out.println("Shortest distance from"+s+" to "+u+" is "+d);
                System.out.println("Shortest path is"+reportShorestPath(u));

                for (Neighbor v :adj.get(u)){
                    if (dist[v.vertex] > d+v.weight){
                        dist[v.vertex] = d+v.weight;
                        PQ.add(new DistNodeParent(dist[v.vertex],v.vertex,u));
                    }
                }
            }
        }





    }
    public static class Dijkstra{
    public static void main(String[] args) {
        n = 8;
        // 1 2 5
        // 1 3 5
        Graph g1 =new Graph(n);
        g1.addEdge(0,4,1);
        g1.addEdge(1,3,3);
        g1.addEdge(1,4,6);
        g1.addEdge(2,1,2);
        g1.addEdge(2,3,7);
        g1.addEdge(2,0,6);
        g1.addEdge(3,4,5);
        g1.findSSP(2);

    }
    }
}
