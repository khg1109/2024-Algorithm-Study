import java.util.*;
import java.io.*;

class Boj27964 {

    // 상수화
    private static final String CHEESE = "Cheese";
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        	
        // O(N + M)
        // 토핑의 개수
        int toppingLen = Integer.parseInt(br.readLine()); // O(N)

        // 토핑을 담을 테이블
        Map<String, Boolean> toppingTb = new HashMap<>();

        // 공백으로 구분
        String[] inputToppingNames = br.readLine().split(" ");

        // 입력받은 토핑 이름들을 하나씩 가지고 와서 처리할 준비
        for (String toppingName : inputToppingNames) {
            int nameLen = toppingName.length();
            if (nameLen < 6) {
                continue;
            }

            // Cheese
            if(toppingName.charAt(nameLen - 1) == 'e' &&
                toppingName.charAt(nameLen - 2) == 's' &&
                toppingName.charAt(nameLen - 3) == 'e' &&
                toppingName.charAt(nameLen - 4) == 'e' &&
                toppingName.charAt(nameLen - 5) == 'h' &&
                toppingName.charAt(nameLen - 6) == 'C') {

                if (toppingTb.get(toppingName) == null) {
                toppingTb.put(toppingName, true); 
                }
            }
        }

        // 결과 출력
        System.out.println(toppingTb.size() >= 4 ? "yummy" : "sad");
    }
}
