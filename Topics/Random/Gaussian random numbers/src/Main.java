import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextLong();
        long n = scanner.nextLong();
        double m = scanner.nextDouble();
        while (true) {
            boolean findK = true;
            Random random = new Random(k);
            for (int i = 0; i < n; i ++) {
                double g = random.nextGaussian();
                if (g > m) {
                    findK = false;
                    break;
                }
            }
            if (findK) {
                System.out.println(k);
                break;
            } else {
                k++;
            }
        }
    }
}