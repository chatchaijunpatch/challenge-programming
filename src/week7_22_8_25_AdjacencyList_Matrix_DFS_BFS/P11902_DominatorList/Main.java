package week7_22_8_25_AdjacencyList_Matrix_DFS_BFS.P11902_DominatorList;
//uhunt problem 11902


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        Scanner sc = new Scanner(System.in);
    void go() throws Exception {
//        Scanner sc = new Scanner(new FileInputStream("src/in.txt"));
        int count = sc.nextInt();
        for (int m = 0; m < count; m++) {
            int a = sc.nextInt();
            AdjacencyList G = new AdjacencyList(a);
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    int b = sc.nextInt();
                    if (b == 1) {
                        G.addEdge(i, j);
                    }
                }
            }
//            G.printGraph();


            String[][] result = new String[a][a];
            G.DFSinit(0,-1);
            int[] visitorigin = new int[a];
            visitorigin = G.getVisit();
//            for (int i = 0; i < visitorigin.length; i++) {
//                System.out.print(visitorigin[i]);
//            }
//            System.out.println();
            for (int i = 0; i < a; i++) {
                G.DFSinit(0, i);
                int[] visited = G.getVisit();
//                for (int k = 0; k < visited.length; k++) {
//                    System.out.print(visited[k]);
//                }
//                System.out.println();
                for (int j = 0; j < a; j++) {


                    if (visitorigin[j] == visited[j] ) result[i][j] = "N";
                    if (visitorigin[j] == visited[j]  && visitorigin[j] == 1) result[i][j] = "N";
                    if (visitorigin[j] != visited[j] ) result[i][j] = "Y";
                    if (visitorigin[j] == visited[j] && i == j && visitorigin[j] == 1) result[i][j] ="Y";
                    if ( visitorigin[j] != visited[j]) result[i][j] = "Y";


                }
//                System.out.println();
            }
            StringBuilder sb=new StringBuilder();
            sb.append("Case ");
            sb.append(m+1);
            sb.append(":\n");
            for (int i = 0; i < a; i++) {
                sb.append("+");
                for (int j = 0; j < (a * 2) - 1; j++) {
                    sb.append("-");
                }
                sb.append("+\n|");
                for (int j = 0; j < a; j++) {
                    sb.append(result[i][j]);
                    sb.append("|");
                }
                sb.append('\n');
            }
            sb.append('+');
            for (int j = 0; j < (a * 2) - 1; j++) {
                sb.append("-");
            }
            sb.append("+\n");
            System.out.print(sb.toString());


        }
    }

    public static void main(String[] args) throws Exception {
        new Main().go();
    }

    class AdjacencyList {
        private int n;
        int[] visit;
        private ArrayList<ArrayList<Integer>> adj;

        public AdjacencyList(int n) {
            this.n = n;
            adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<Integer>());
            }
        }

        public ArrayList<ArrayList<Integer>> getAdj() {
            return adj;
        }

        public int[] getVisit() {
            return visit;
        }

        public void addEdge(int Firstnode, int Secondnode) {
            adj.get(Firstnode).add(Secondnode);
        }


        void DFS(int s, int round) {
            //set node แรกที่เลือกมาเป็น visit
            visit[s] = 1;
//            System.out.println("visit : "+s);
//        ArrayList<Integer> list_s = adj.
            //cost n**2
            for (int i = 0; i < adj.get(s).size(); i++) {
                //adj[s][i] == 1 เช็คว่า มีเส้นเชื่อมระหว่าง Node หรือไม่
                // visit[i] == 0 คือยังไม่ได้มีการ access
                int v = adj.get(s).get(i);
                if (visit[v] == 0 && (s != round)) {
                    DFS(v, round);
                }

            }

        }

        void DFSinit(int s, int round) {
            visit = new int[n]; // สร้างการ visit ขึ้นมา
            //set ค่า visit
            for (int i = 0; i < n; i++) {
                visit[i] = 0;
            }
            DFS(s, round);
        }
    }
}
