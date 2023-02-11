package by.lnik.memory;

import by.lnik.product;
import by.lnik.shopList;

import java.util.ArrayList;
import java.util.List;

public class productsStorage extends product {

    public productsStorage() {

    }
    public productsStorage(int id, double price, String name, boolean isDiscount) {
        super(id, price, name, isDiscount);
    }

    private static List<product> products;


    static {//builder база продуктов
        products = new ArrayList<>();
        products.add(new product(1,50, "Картошка", false));
        products.add(new product(2,150, "Бананы", true));
        products.add(new product(3,500, "Баранина", false));
        products.add(new product(4,30, "Вафли", true));
    }



    public product isProductExist(int id) {
        for (product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public List<product> returnProductsStorage() {
        return products;
    }


}
