import java.util.Scanner;

public class Boj9372 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            
            int N = sc.nextInt();
            int M = sc.nextInt();

            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
            }
            // 비행 스케줄이 항상 연결 그래프를 이룬다고 한다. 그렇다는건 MST를 만족한다는 것이고
            // 따라서, 연결 그래프의 특징으로 어떤 한 정점에서 다른 정점으로 모든 노드를 연결하는 경로는 적어도 하나 존재한다.
            // 그것은 노드의 개수 - 1 이다.
            // 따라서, 문제의 특성상, 가장 적은 종류의 비행기라고 하는것은, 결국 적어도 하나 존재하는 경우 N - 1개의 간선을 거쳐서 모든 노드를 방문하는 경우이다.
            System.out.println(N - 1);
        }
    }
}
