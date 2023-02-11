package by.lnik;

import java.util.ArrayList;
import java.util.List;

public class shopList extends checkerArgs {
    private int quantity;
    private String fullPriceofProduct;

    public shopList() {//конструкторы
    }

    public shopList(int id, double price, String name, boolean isDiscount, int quantity, String fullPriceofProduct) {
        super(id, price, name, isDiscount);
        this.quantity = quantity;
        this.fullPriceofProduct = fullPriceofProduct;
    }

    public String getFullPriceofProduct() {
        return fullPriceofProduct;
    }

    private static List<shopList> shopLists;


    static {//builder база продуктов
        shopLists = new ArrayList<>();
    }

    public static void addProduct(String[] part, product prd) {//Добавление продукта в shopList, с изменением id, + проверкой на скидку по опту
        int id = 0;//Проверка id в списке продуктов
        int quantity = Integer.parseInt(part[1]);
        for (shopList shpl : shopLists) {
            id = Math.max(shpl.getId(), id);
        }
        id++;
        shopLists.add(new shopList(id, prd.getPrice(), prd.getName(), prd.getIsDiscount(),//добавление продукта в список покупок
                quantity, fullPriceofProduct(quantity, prd)));
    }

    private static String fullPriceofProduct(int quantity, product prd) {//получение полной цены для определенной позиции, в зависимости от опта
        if (prd.getIsDiscount() && quantity > prd.getHowMuchForDiscount()) {
            return (prd.getPrice() * quantity) * ((100 - prd.getHowMuchDiscount()) / 100) + " is a " + prd.getHowMuchDiscount() + " % discount for opt";
        } else {
            return (prd.getPrice() * quantity) + "";
        }
    }


    public static double getFullPrice() {
        double fullPrice = 0.0;
        for (shopList shpl : shopLists) {
            fullPrice += priceStringToDouble(shpl.getFullPriceofProduct());
        }
        return fullPrice;
    }

    public static double getFullPriceWithDiscount(card promotionalCard) {
        double fullPrice = getFullPrice();
        return (fullPrice * ((100 - promotionalCard.getDiscount()) / 100));

    }


    public static double priceStringToDouble(String price) {
        String[] prices = price.split("\\ ");
        return Double.parseDouble(prices[0]);
    }


    public List<shopList> returnShopL() {
        return shopLists;
    }

    public void clearList() {
        shopLists.clear();
    }

    @Override
    public String toString() {
        return
                quantity + " " + this.getName() + " " + this.getPrice() + " " + fullPriceofProduct;

    }
}
