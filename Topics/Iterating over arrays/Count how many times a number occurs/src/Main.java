import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}