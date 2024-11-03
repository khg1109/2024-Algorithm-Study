import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    final static String CHEESE = "Cheese";

    public static void main(String[] args) throws IOException {

        String n = in.readLine();

        String[] cheeseArray = in.readLine().split(" ");

        Set<String> cheeseSet = Arrays.stream(cheeseArray)
            .filter(cheese -> cheese.endsWith(CHEESE))
            .collect(Collectors.toSet());

        if (cheeseSet.size() >= 4) {
            out.write("yummy");
            out.close();
            return;
        }
        out.write("sad");
        out.close();
    }
}
