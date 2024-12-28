import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 행(H)과 열(W) 입력 받기
        int H = sc.nextInt();
        int W = sc.nextInt();
        sc.nextLine(); // 개행 문자 소비 (정수 입력 후 남아있는 줄바꿈 문자 처리)

        // 2차원 문자 배열 선언 및 초기화
        char[][] arr = new char[H][W];

        // 배열에 문자 입력받기
        for (int i = 0; i < H; i++) {
            String line = sc.nextLine(); // 한 줄 전체를 입력 받음
            for (int j = 0; j < W; j++) {
                arr[i][j] = line.charAt(j); // 각 문자를 배열에 저장
            }
        }

        sc.close(); // 스캐너 닫기
        // 자바 숙력도 부족으로 gpt 사용

        int cnt = -1;
        for(int i = 0; i < H; i++){
            cnt = -1; // 행을 바뀔때 마다 cnt를 -1로 변경
            for(int j = 0; j < W; j++){
                if(arr[i][j] == 'c'){  // c값이 나오면 cnt를 0으로 변경
                    cnt = 0;
                }
                System.out.printf("%d ", cnt);  // cnt 출력
                if(cnt >= 0){  // cnt가 0이상이면 cnt를 1씩 증가시킨다
                    cnt++;
                }
            }
            System.out.println();
        }
    }
}