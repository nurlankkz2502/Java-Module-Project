import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class BillSplitter {
    double totalAmount;
    int personCount;

    List<Product> productList;

    BillSplitter(int count) {
        totalAmount = 0;
        personCount = count;
        productList = new Vector<>();
    }

    public String checkDouble(Double value) {
        double d = value % 1;
        double integralPart = value - d;
        String result;
        if (integralPart < 2) {
            result = String.format("%.2f", value) + " рубль";
        } else if (integralPart < 10) {
            result = String.format("%.2f", value) + " рубля";
        } else {
            result = String.format("%.2f", value) + " рублей";
        }

        return result;
    }

    public void addProduct() {

        String commandText;
        String productName;
        Double productPrice;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        while (true) {

            System.out.print("Введите название товара: ");
            productName = scanner.nextLine();
            System.out.print("Введите стоимость в формате: \"'рубли.копейки' [10.45, 11.40]\": ");
            productPrice = scanner.nextDouble();

            productList.add(new Product(productName, productPrice));

            totalAmount = totalAmount + productPrice;

            System.out.println("Продукт " + productName + " был добавлен");
            System.out.println("Вы хотите добавить еще один товар?");
            commandText = scanner.next();
            scanner.nextLine();

            if (commandText.equalsIgnoreCase("завершить"))
                break;

        }

        System.out.println("Добавленные товары:");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).title + "\t" + this.checkDouble(productList.get(i).price));
        }
        System.out.println("\nОбщая сумма на каждого человека: " + this.checkDouble(totalAmount / personCount));
    }
}
