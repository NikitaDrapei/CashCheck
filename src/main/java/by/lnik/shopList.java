package by.lnik;

import by.lnik.classes.card;
import by.lnik.classes.product;

import java.util.ArrayList;
import java.util.List;

public class shopList extends checkerArgs {
    //
    private int quantity;
    private String fullPriceofProduct;
    ///
    //конструкторы
    public shopList() {
    }

    public shopList(int id, double price, String name, boolean isDiscount, int quantity, String fullPriceofProduct) {
        super(id, price, name, isDiscount);
        this.quantity = quantity;
        this.fullPriceofProduct = fullPriceofProduct;
    }
    ///
    //Возвращает стоимость 1 товара(с учетом скидки по опту если имеется)
    //Getters
    public String getFullPriceofProduct() {
        return fullPriceofProduct;
    }
    public int getQuantity() {
        return quantity;
    }
    ///

    //Хранилище списка покупок
    private static List<shopList> shopLists;

    static {
        shopLists = new ArrayList<>();
    }
    ///

    //Добавление продукта в shopList, + проверкой на скидку по опту
    public static void addProduct(String[] part, product prd) {
        int id = 0;//Проверка id в списке продуктов
        int quantity = Integer.parseInt(part[1]);
        for (shopList shpl : shopLists) {
            id = Math.max(shpl.getId(), id);
        }
        id++;
        shopLists.add(new shopList(id, prd.getPrice(), prd.getName(), prd.getIsDiscount(),//добавление продукта в список покупок
                quantity, priceToQuantityDiscount(quantity, prd)));
    }
    ///

    //Проверка явл. ли товар дисконтным, true - возвращает товар со скидкой String, false - без скидки
    private static String priceToQuantityDiscount(int quantity, product prd) {//получение полной цены для определенной позиции, в зависимости от опта
        if (prd.getIsDiscount() && quantity > prd.getHowMuchForDiscount()) {
            return (prd.getPrice() * quantity) * ((100 - prd.getHowMuchDiscount()) / 100) + " - " + prd.getHowMuchDiscount() + " %% discount for opt";
        } else {
            return (prd.getPrice() * quantity) + "";
        }
    }
    ///

    //Возвращает полную стоимость(с учетом скидок по опту, String)
    public static double PriceForAllProducts() {
        double fullPrice = 0.0;
        for (shopList shpl : shopLists) {
            fullPrice += priceStringToDouble(shpl.getFullPriceofProduct());
        }
        return fullPrice;
    }
    public static double priceStringToDouble(String price) {
        String[] prices = price.split("\\ ");
        return Double.parseDouble(prices[0]);
    }
    ///

    //Возвращает полную стоимость(с учетом скидки опту + карточка)
    public static double FullPriceWithDiscount(card promotionalCard) {
        double fullPrice = PriceForAllProducts();
        return (fullPrice * ((100 - promotionalCard.getDiscount()) / 100));
    }
    ///

    //Возврат списка покупок
    public static List<shopList> returnShopL() {
        return shopLists;
    }
    ///

    //Вывод данных, форматированный
    @Override
    public String toString() {
        return
                String.format("%-12d%-23s%-16.2f%s", quantity,this.getName(), this.getPrice(), fullPriceofProduct);
    }
    ///
}
