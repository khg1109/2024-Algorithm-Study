import java.util.Scanner;

public class Boj9372 {

    private static final Scanner sc;
    private static int visitedCnt;
    
    // define static block
    static {
        // init scanner instance for input data
        sc = new Scanner(System.in);
        // init visitedCnt 
        visitedCnt = 0;
    }

    // making graph 
    private static int[][] makeGraph(int v) {
        return new int[v+1][v+1];
    }

    // dfs
    private static void dfs(int node, boolean[] visited, int[][] graph, int v) {
        // visitied node is true
        
        visited[node] = true;
        visitedCnt += 1;
        // 만약 방문횟수가 v가 되었다면
        if(visitedCnt == v) {
            
            System.out.println(visitedCnt - 1);
            visitedCnt = 0;
            return;
        }
        // loop adj node
        for (int adj = 1; adj <= v; adj++) {
            
            if(graph[node][adj] == 1 && !visited[adj]) {
                dfs(adj, visited, graph, v);
            }
        }
    }

    // process
    private static void run() {
        // test case
        int T = sc.nextInt();

        int[][] graph;
        boolean [] visitied;

        // loop test case
        while (T --> 0) {
           int v = sc.nextInt();
           int e = sc.nextInt();
           // 2 <= v <= 1000
           graph = makeGraph(v);
           visitied = new boolean[v+1];

           // init graph
           for (int i = 0; i < e; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a][b] = 1;
                graph[b][a] = 1;
           }

           // run dfs
           dfs(1, visitied, graph, v);
        }
    }
    public static void main(String[] args) {
        run();
    }
}