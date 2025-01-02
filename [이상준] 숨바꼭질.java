import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_1697 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int pointX = Integer.parseInt(input[0]);
        int pointY = Integer.parseInt(input[1]);

        int max = 100000;
        int[] visited = new int[max + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(pointX);
        visited[pointX] = 1;

        while (!queue.isEmpty()) {
            //인접한 정점 모두 enQueue
            //deQueue 후 받은 정점의 인접 정점 처리
            int current = queue.poll(); //poinX 값
            int[] adjArray = {current - 1, current + 1, current * 2};

            for (int adj : adjArray) {
                if (adj >= 0 && adj <= max && visited[adj] == 0) { //인접 정점이 방문하지 않았다면 시간 추가;
                    visited[adj] = visited[current] + 1;
                    queue.add(adj);
                }
            }
            if (visited[pointY] != 0) {
                bw.write(String.valueOf(visited[pointY]-1));
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }


    }
}
