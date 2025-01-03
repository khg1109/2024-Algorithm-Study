package 이동섭;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
// 숨바꼭질 1697
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int MAX = 100000;

    public static void main(String[] args) throws IOException {

        String[] nk = in.readLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX + 1];

        queue.offer(new int[] {n, 0}); // position, time

        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            if (position == k) {
                out.write(time + "\n");
                out.close();
                return;
            }

            int[] nextPosition = {position + 1, position - 1, position * 2};

            for (int next : nextPosition) {
                if (next >= 0 && next <= MAX && !visited[next]) {
                    queue.offer(new int[] {next, time + 1});
                    visited[next] = true;
                }
            }

        }
    }
}
