package 이동섭;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {


    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());

        for (int t = 0; t < T; t++) {
            String[] NM = in.readLine().split(" ");

            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);

            for (int m = 0; m < M; m++) {
                in.readLine();
            }

            out.write((N - 1) + "\n");
        }

        out.close();
    }
}