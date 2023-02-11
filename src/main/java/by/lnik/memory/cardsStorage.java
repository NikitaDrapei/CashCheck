package by.lnik.memory;

import by.lnik.card;
import by.lnik.product;

import java.util.ArrayList;
import java.util.List;

public class cardsStorage extends card {
    private static List<card> cards;

    public cardsStorage() {
    }

    static {//builder база продуктов
        cards = new ArrayList<>();
        cards.add(new card(2344,10.0));
        cards.add(new card(1234,10.0));
        cards.add(new card(3488,10.0));
        cards.add(new card(9999,55.0));//son

    }

    public card isCardExist(int number) {
        for (card crd : cards) {
            if (crd.getNumber() == number) {
                return crd;
            }
        }
        return null;
    }
}
