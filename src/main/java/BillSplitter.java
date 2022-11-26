import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class BillSplitter {
    double totalAmount = 0;
    int personCount;

    List<Product> productList = new Vector<>();

    BillSplitter(int count) {
        personCount = count;
    }

    public String checkDouble(Double value) {
        double d = value % 10;
        String result = String.format("%.2f", value);
            if (d==1)
                result+=" рубль";
            else if(d==2||d==3||d==4)
                result+=" рубля";
            else
                result+=" рублей";
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
            if (scanner.hasNextDouble()) {
                productPrice = scanner.nextDouble();
                if (productPrice >= 0) {
                    productList.add(new Product(productName, productPrice));
                    totalAmount += productPrice;
                } else {
                    System.out.println("Вы ввели некорректные данные цены, попробуйте заново");
                    scanner.nextLine();
                    continue;
                }
            } else {
                System.out.println("Вы ввели некорректные данные цены, попробуйте заново");
                scanner.nextLine();
                continue;
            }
            System.out.println("Продукт " + productName + " был добавлен\nВы хотите добавить еще один товар?");
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
