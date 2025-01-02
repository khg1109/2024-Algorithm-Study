import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N; // 수빈이의 현재 위치
    static int K; // 동생의 위치
    static int[] check = new int[100001]; // 방문 여부 및 이동 횟수 기록

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        // 수빈이와 동생의 위치가 같을 경우
        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        check[start] = 1; // 시작점 방문 처리

        while (!q.isEmpty()) {
            int current = q.poll();

            // 현재 위치에서 이동 가능한 3가지 경우
            int[] nextPositions = {current + 1, current - 1, current * 2};

            for (int next : nextPositions) {
                // 동생의 위치에 도{'[][]ㄷㅂㅈㄷ달하면 결과 출력 후 종료
                if (next == K) {
                    System.out.println(check[current]);
                    return;
                }

                // 유효한 범위 내에서 아직 방문하지 않은 위치만 큐에 추가
                if (next >= 0 && next < check.length && check[next] == 0) {
                    q.add(next);
                    check[next] = check[current] + 1; // 이동 횟수 증가
                }
            }
        }
    }
}