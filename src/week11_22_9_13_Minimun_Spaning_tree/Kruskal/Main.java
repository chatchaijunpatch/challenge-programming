package week11_22_9_13_Minimun_Spaning_tree.Kruskal;

import java.util.ArrayList;
import java.util.Collections;

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
    public static void makeSet(){
        parent = new int[n+1];
        size = new int[n+1];
        for (int i =1; i<=n;i++){
            parent[i] = i;
            size[i] = i;
        }
    }
    public static int find(int x){
        while(x!=parent[x]) x = parent[x];
        return x;
    }
    public static void Union(int x,int y){
        int r = find(x);
        int s = find(y);
        if (r==s) return;
        else if(size[r]>size[s]){
            parent[s] = r;
            size[r] += size[s];
        }
        else {
            parent[r] = s;
            size[s]  += size[r];
        }
    }
    public static void findMST(){
        makeSet();
        Collections.sort(EdgeList);
        for (Edge e: EdgeList) {
//            System.out.println(e.u+", "+e.v+": "+e.weight);
            if (find(e.u)!= find(e.v)){
                //Report that edge e in a MST
                System.out.println(e.u+", "+e.v+": "+e.weight);
                Union(e.u,e.v);
            }
        }
    }
    public static void main(String[] args) {
         n = 5+1;
        // 1 2 5
        // 1 3 5
        Edge e_1 = new Edge(1, 2, 5);
        Edge e_2 = new Edge(1, 3, 5);
        Edge e_3 = new Edge(1, 4, 5);
        Edge e_4 = new Edge(1, 5, 5);
        Edge e_5 = new Edge(3, 4, 8);
        Edge e_6 = new Edge(4, 5, 8);
        EdgeList = new ArrayList<>();
        EdgeList.add(e_1);
        EdgeList.add(e_2);
        EdgeList.add(e_3);
        EdgeList.add(e_4);
        EdgeList.add(e_5);
        EdgeList.add(e_6);
        findMST();
    }
}
