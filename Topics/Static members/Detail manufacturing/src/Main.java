import java.util.Scanner;

class ManufacturingController {
    static int numberOfProduct = 0;

    public static String requestProduct(String product) {
        return String.format("%d. Requested %s", ++numberOfProduct, product);
    }

    public static int getNumberOfProducts() {
        return numberOfProduct;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String product = scanner.nextLine();
            System.out.println(ManufacturingController.requestProduct(product));
            System.out.println(ManufacturingController.getNumberOfProducts());
        }
    }
}