import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] inputArray = in.readLine().split(" ");
        int H = Integer.parseInt(inputArray[0]);
        int W = Integer.parseInt(inputArray[1]);

        int[][] map = new int[H][W];

//        Arrays.fill(map, -1); -> 1차원 배열에서 사용
        for(int[] sector : map) {
            Arrays.fill(sector, -1);
        }

        // O(H x W)
        for (int i = 0; i < H; i++) {
            String row = in.readLine();
            boolean isCloud = false;
            int cloudCount = 0;

            for (int j = 0; j < W; j++) {
                if (row.charAt(j) == 'c') {
                    isCloud = true;
                    cloudCount = 0;
                    map[i][j] = 0;
                } else if (isCloud) {
                    cloudCount++;
                    map[i][j] = cloudCount;
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int k = 0; k < W; k++) {
                out.write(map[i][k] + " ");
            }
            out.write("\n");
        }

        out.close();

    }

}
