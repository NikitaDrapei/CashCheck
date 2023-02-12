package by.lnik;

import by.lnik.classes.card;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

public class cashReceiptBuilder {
    private String nameOfcompany = "SuperPuperMarket №17"; //Name of company
    Date currentDate = new Date();//Current time of shopping


    //Вывод в консоль
    public void receiptInConsole(List<shopList> shopLists, card promotionalCard) {
        double fullPrice = 0;
        System.out.println("\n------------------------------------------------------------------------------------");
        System.out.println("CASH RECEIPT");
        System.out.println(nameOfcompany);
        System.out.println(currentDate);
        System.out.println("************************************************************************************");
        System.out.println("QTY         DESCRIPTION            PRICE           TOTAL");

        for (shopList sh : shopLists) {//изменить
            System.out.printf(sh.toString() + "\n");
        }

        System.out.println("************************************************************************************");
        fullPrice = shopList.PriceForAllProducts();
        System.out.println("Price of product: " + fullPrice);
        if (promotionalCard != null) {
            System.out.println("Your card number " + promotionalCard.getNumber() + " your discount is: " + promotionalCard.getDiscount() + " %" +
                    "\nFinal price: " + shopList.FullPriceWithDiscount(promotionalCard));
        } else {
            System.out.println("Final price: " + fullPrice);
        }
        System.out.println("------------------------------------------------------------------------------------");
    }
    ///

    //Вывод в файл, повтор кода, различие в pw
    public void receiptInFile(List<shopList> shopLists, card promotionalCard, PrintWriter pw) {
        double fullPrice = 0;
        pw.println("------------------------------------------------------------------------------------");
        pw.println("CASH RECEIPT");
        pw.println(nameOfcompany);
        pw.println(currentDate);
        pw.println("************************************************************************************");
        pw.println("QTY         DESCRIPTION            PRICE           TOTAL");

        for (shopList sh : shopLists) {//изменить
            pw.printf(sh.toString() + "\n");
        }

        pw.println("************************************************************************************");
        fullPrice = shopList.PriceForAllProducts();
        pw.println("Price of product: " + fullPrice);
        if (promotionalCard != null) {
            pw.println("Your card number " + promotionalCard.getNumber() + " your discount is: " + promotionalCard.getDiscount() + " %" +
                    "\nFinal price: " + shopList.FullPriceWithDiscount(promotionalCard));
        } else {
            pw.println("Final price: " + fullPrice);
        }
        pw.println("------------------------------------------------------------------------------------");
        System.out.println("File cashreceipt.txt was updated");
    }
    ///
}
