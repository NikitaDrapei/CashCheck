package by.lnik;

import by.lnik.classes.card;
import by.lnik.classes.product;
import by.lnik.memory.cardsStorage;
import by.lnik.memory.productsStorage;

import static by.lnik.shopList.addProduct;

public class checkerArgs extends productsStorage {
    //
    private String[] cardPart;
    ///
    //Конструкторы
    public checkerArgs() {
        super();
    }

    public checkerArgs(int id, double price, String name, boolean isDiscount) {
        super(id, price, name, isDiscount);
    }
    ///

    //Проверка это карта или продукт, по 1 аргументу. + Возвращает карту если она есть
    public card scanArguments(String[] args) {
        String[] part;
        boolean isCard = false;
        for (String arg : args) {
            part = arg.split("\\-");
            if (part[0].equals("card")) {//Это карта?
                if (checkCard(part) != null) {//Она существует?
                    isCard = true;
                    cardPart = part;
                }
            } else {//Это продукт
                checkProduct(part);
            }
        }
        return (isCard) ? checkCard(cardPart) : null;//Карта была и она настоящая? true - отдаем карту, false - null
    }
    ///

    //Проверка карты, она есть? true - отдаем карту обратно, false - null
    public card checkCard(String[] part) {
        int number = Integer.parseInt(part[1]);
        if (cardsStorage.isCardExist(number) != null) {
            return cardsStorage.isCardExist(number);
        } else {
            System.out.println("Card with number " + number + " not exist");
            return null;
        }
    }
    ///

    //Проверка продукта, он есть? true - добавляем его в список покупок, false - указываем что его нет
    public boolean checkProduct(String[] part) {
        int id = Integer.parseInt(part[0]);
        if (isProductExist(id) != null) {//Продукт существует?
            product prd = (isProductExist(id));//Добавляемый продукт
            addProduct(part, prd);//Добавляем продукт в список покупок
            return true;
        } else {
            System.out.println("Product with index " + id + " not exist");
            return false;
        }
    }
}
