package by.lnik.memory;

import by.lnik.classes.product;

import java.util.ArrayList;
import java.util.List;

public class productsStorage extends product {

    //Конструкторы
    public productsStorage() {
    }

    public productsStorage(int id, double price, String name, boolean isDiscount) {
        super(id, price, name, isDiscount);
    }
    ///

    //Хранилище продуктов
    private static List<product> products;

    static {
        products = new ArrayList<>();
        products.add(new product(1, 50, "Potato", false));
        products.add(new product(2, 150, "Banana", true));
        products.add(new product(3, 500, "Meat", false));
        products.add(new product(4, 30, "Waffles", true));
    }
    ///

    //Проверка наличия продукта, true - возвращает продукт, false - null
    public product isProductExist(int id) {
        for (product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    ///

    //Возврат списка продуктов
    public static List<product> returnProductList() {
        return products;
    }
    ///
}
