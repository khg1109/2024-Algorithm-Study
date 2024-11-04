import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String findCheese = "Cheese";
        String[] stringArray = new String[size];
        Set<String> toppingSet = new HashSet<>();

        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = scanner.next();
            if (stringArray[i].endsWith(findCheese)) {
                toppingSet.add(stringArray[i]);
            }
        }

        if (toppingSet.size() >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }
    }
}
