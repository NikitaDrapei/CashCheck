import by.lnik.classes.card;
import by.lnik.cashReceiptBuilder;
import by.lnik.checkerArgs;
import by.lnik.classes.product;
import by.lnik.memory.cardsStorage;
import by.lnik.memory.productsStorage;
import by.lnik.shopList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//3-1 2-5 5-1 card-1234
public class CheckRunner {
    public static void main(String[] args) {
        boolean fExit = true;
        boolean fExit1 = true;
        //Объявление переменной для menu, путь файла, для записи
        int menu = 0;
        final String FILE_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "cashreceipt.txt";
        ///

        //Создание объекта card
        card promotionalCard = null;
        ///

        //Создание объектов для вызова их внутренних методов
        checkerArgs checker = new checkerArgs();
        cashReceiptBuilder cashRecBuild = new cashReceiptBuilder();
        ///

        if (args.length == 0) {
            System.out.println("No arguments given");//end
        } else {
            promotionalCard = checker.scanArguments(args);//Запуск проверки аргументов checkerArgs,
            // есть ли там карта, true - присвоим карту, false - остается null
            cashRecBuild.receiptInConsole(shopList.returnShopL(), promotionalCard);//Вывод чека в консоль
            //Функционал через меню
            do {
                System.out.println();
                fExit1 = true;
                Scanner sc = new Scanner(System.in);
                System.out.println("Select a menu item:");
                System.out.println("1. Output cash receipt to a file");
                System.out.println("2. Output cards storage");
                System.out.println("3. Output products storage");
                System.out.println("4. Exit");
                do {///Проверка на выбор меню
                    System.out.println("Choose between 1 to 4:");
                    menu = sc.nextInt();
                    if (menu <= 0 || menu > 4) {
                        System.out.println("Input correct number between 1 to 4");
                    } else {
                        fExit1 = false;
                    }
                } while (fExit1);

                switch (menu) {
                    case 1://Вывод чека в файл
                        File file = new File(FILE_PATH);
                        try {
                            PrintWriter pw = new PrintWriter(file);
                            cashRecBuild.receiptInFile(shopList.returnShopL(), promotionalCard, pw);
                            pw.close();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2://Вывод всех имеющихся карточек
                        System.out.println("Card storage:");
                        for (card cards : cardsStorage.returnCardList()) {
                            System.out.println(cards.toString());
                        }
                        break;
                    case 3://Вывод списка продуктов на "складе"
                        System.out.println("Products storage:");
                        for (product products : productsStorage.returnProductList()) {
                            System.out.println(products.toString());
                        }
                        break;
                    case 4://Выход
                        sc.close();
                        fExit = false;
                        break;
                }
            } while (fExit);
            ///
        }
    }
}
