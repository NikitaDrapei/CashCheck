package by.lnik;

import java.util.Date;
import java.util.List;

public class cashReceiptBuilder {
    private String nameOfcompany="SuperPuperMarket №17";


    public void receiptCard(List<shopList> shopLists, card promotionalCard) {//зачем он нужен
        if (promotionalCard!=null){
            receiptConsole(shopLists, promotionalCard);
        }else {
            receiptConsole(shopLists, null);
        }

    }







    public void receiptConsole(List<shopList> shopLists, card promotionalCard){
        double fullPrice = 0;

        System.out.println("\nCASH RECEIPT");
        System.out.println(nameOfcompany);
        Date currentDate = new Date();
        System.out.println(currentDate);
        System.out.println("****************************");
        System.out.println("QTY         name            price           FULL price");

        for (shopList sh:shopLists) {//изменить
            System.out.println(sh.toString());
        }

        System.out.println("****************************");
        fullPrice = shopList.getFullPrice();
        System.out.println("Price of product: " + fullPrice);

        if (promotionalCard!=null){
            System.out.println("Your card number " + promotionalCard.getNumber() + " your discount is " + promotionalCard.getDiscount() + " %" +
                    "\nFinal price: " + shopList.getFullPriceWithDiscount(promotionalCard));
        }else{
            System.out.println("Final price:" + fullPrice);
        }



    }




}
