import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayX = new ArrayList<>();
        ArrayList<Integer> arrayY = new ArrayList<>();
        HashSet<Integer> setY = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            arrayX.add(x);
            arrayY.add(y);
            setY.add(y);
        }

        for (int k : setY) {
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < arrayY.size(); i++) {
                if (k == arrayY.get(i)) {
                    arrayList.add(arrayX.get(i));
                }
            }

            Collections.sort(arrayList);

            for (int j : arrayList) {
                bw.write(j + " " + k + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
