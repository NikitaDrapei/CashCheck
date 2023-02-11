import by.lnik.card;
import by.lnik.cashReceiptBuilder;
import by.lnik.checkerArgs;
import by.lnik.shopList;


//myString.substring(myString.indexOf("\"")+1, myString.indexOf("\"", myString.indexOf("\"")+1));
//You can just split the string..
//
//public String[] split(String regex)
//Note that java.lang.String.split uses delimiter's regular expression value. Basically like this...
//
//String filename = "abc.def.ghi";     // full file name
//String[] parts = filename.split("\\."); // String array, each element is text between dots
//
//String beforeFirstDot = parts[0];    // Text before the first dot


//3-1 2-5 5-1 card-1234
public class CheckRunner {
    public static void main(String[] args) {
        checkerArgs cArg = new checkerArgs();
        cashReceiptBuilder cRb = new cashReceiptBuilder();
        card promotionalCard = null;//card employeer
        shopList shopLists = new shopList();
        if (args.length == 0) {
            System.out.println("Не заданы аргументы");
        } else {
            promotionalCard = cArg.checkArg(args);//Запуск проверки аргументов -> checkerArgs, + есть ли там карта
            System.out.println(shopLists.returnShopL());//Вывод списка покупок
            cRb.receiptCard(shopLists.returnShopL(), promotionalCard);//Вывод чека в консоль
        }


    }
}
