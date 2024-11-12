import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            int counter = -1;

            for (int j = 0; j < col; j++) {
                if (str.charAt(j) == 'c') {
                    counter = 0; //연속적인 구름일경우 counter 초기화
                }
                sb.append(counter).append(" ");
                if (counter != -1){
                    counter++;
                }
            }

            bw.write(sb.toString().trim());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
