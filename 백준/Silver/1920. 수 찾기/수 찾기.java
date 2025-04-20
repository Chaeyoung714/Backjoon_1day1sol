
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Set<Integer> standardInts = new HashSet<>();
        for (int i = 0; i < n; i++) {
            standardInts.add(scanner.nextInt());
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int comparingInt = scanner.nextInt();
            if (isNumberExist(comparingInt, standardInts)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean isNumberExist(int comparingInt, Set<Integer> standardInts) {
        if (standardInts.contains(comparingInt)) {
            return true;
        }
        return false;
    }
}