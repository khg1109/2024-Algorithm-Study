import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static Set<String> toppingSet = new HashSet<>();
    final static String CHEESE = "Cheese";

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(in.readLine());

        for (int i = 0; i < number; i++) {
            String topping = in.readLine();
            //Cheese 문자열 보다 짧은 문자는 넘어감
            if(topping.length() < 6){
                continue;
            }
            //Cheese 로 끝나는 문자열 중복없이 셋에 저장
            if (topping.endsWith(CHEESE)) {
                toppingSet.add(topping);
                if (toppingSet.size() == 4) {
                    out.write("yummy");
                    out.flush();
                    return;
                }
            }
        }
        out.write("sad");
        out.flush();
    }
}
