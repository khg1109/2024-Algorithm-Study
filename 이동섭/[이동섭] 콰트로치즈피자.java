import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static Set<String> cheeseToppingSet = new HashSet<>();

    final static String CHEESE = "Cheese";

    public static void main(String[] args) throws IOException {

        String n = in.readLine();

        String[] cheeseToppingArray = in.readLine().split(" ");

        for (String cheeseTopping : cheeseToppingArray) {
            if (cheeseTopping.endsWith(CHEESE)) {
                cheeseToppingSet.add(cheeseTopping);
            }
        }

        if (cheeseToppingSet.size() >= 4) {
            out.write("yummy");
            out.close();
            return;
        }

        out.write("sad");
        out.close();

    }

}
