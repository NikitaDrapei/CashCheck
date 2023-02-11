package by.lnik;

import by.lnik.memory.cardsStorage;
import by.lnik.memory.productsStorage;

import static by.lnik.shopList.addProduct;

public class checkerArgs extends productsStorage {
    private cardsStorage crdS = new cardsStorage();
    private String[] Cardpart;

    public checkerArgs() {
        super();
    }

    public checkerArgs(int id, double price, String name, boolean isDiscount) {
        super(id, price, name, isDiscount);
    }

    public card checkArg(String[] args) {//Проверка это карта или продукт, по 1 аргументу. + Возвращает карту если она есть, и она валидная
        String[] part;
        boolean isCard = false;
        for (int i = 0; i < args.length; i++) {
            part = args[i].split("\\-");
            if (part[0].equals("card")) {//Это карта?
                //cardIfexist = checkCard(part);
                if (checkCard(part) != null) {//Она существует?
                    isCard = true;
                    Cardpart = part;
                }
            } else {
                checkProduct(part);
            }
        }

        return (isCard) ? checkCard(Cardpart) : null;
    }

    private card checkCard(String[] part) {//Действие с картой
        int number = Integer.parseInt(part[1]);
        if (crdS.isCardExist(number) != null) {//rework вызов метода 2 раза
            return (card) (crdS.isCardExist(number));
        } else {
            System.out.println("Карточки с таким номером не существует!");
            return null;
        }
    }

    private void checkProduct(String[] part) {//Действие с продуктами
        int id = Integer.parseInt(part[0]);
        if (isProductExist(id) != null) {
            product prd = (isProductExist(id));//Добавляемый продукт
            addProduct(part, prd);
        } else {
            System.out.println("Продукта с индексом " + id + " не существует");
        }
    }
}
