import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Boj1697 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int MAX_VALUE;

    public static class Coordinate {
        int x;
        int dis;
        Coordinate(int x, int dis) {
            this.x = x;
            this.dis = dis;
        }
    }

    private static void bfs(int N, int K) throws IOException {
        if(N == K) {
            bw.write(0 + "\n");
            bw.flush();
            bw.close();
            return;
        }
        boolean [] visited = new boolean[MAX_VALUE + 1];
        Queue<Coordinate> queue = new LinkedList<>();
        int dis = 1;
        queue.add(new Coordinate(N, dis));
        visited[N] = true;

        while(!queue.isEmpty()) {
            Coordinate c = queue.poll();
            int[] nextPos = {c.x * 2, c.x + 1, c.x - 1};
            for (int pos : nextPos) {
                if (pos >= 0 && pos < MAX_VALUE && !visited[pos]) {
                    if (pos == K) {
                        bw.write(c.dis + "\n");
                        bw.flush();
                        bw.close();
                        return;
                    }
                    queue.add(new Coordinate(pos, c.dis + 1));
                    visited[pos] = true;
                }
            }
        }
    }
    private static void run() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // N > K
        // N == K
        // N < K
        MAX_VALUE = Math.max(N, K) * 2;
        bfs(N, K);

    }
    public static void main(String[] args) throws IOException{
        run();
    }
}