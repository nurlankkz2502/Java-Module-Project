import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count;

        while (true) {
            System.out.print("Введите количество пользователей: ");
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                if (count >= 1) {
                    break;
                } else
                    System.out.println("Вы ввели некоректное число, попробуйте ещё раз");

            } else {
                System.out.println("Вы ввели некорректные данные, попробуйте ещё раз");
                scanner.next();
            }
        }
        BillSplitter calculator = new BillSplitter(count);
        calculator.addProduct();
    }
}
