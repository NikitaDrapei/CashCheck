package by.lnik.memory;

import by.lnik.classes.card;

import java.util.ArrayList;
import java.util.List;

public class cardsStorage extends card {
    private static List<card> cards;

    //Хранилище карточек
    public cardsStorage() {
    }

    static {
        cards = new ArrayList<>();
        cards.add(new card(2344, 10.0));
        cards.add(new card(1234, 10.0));
        cards.add(new card(3488, 10.0));
        cards.add(new card(9999, 50.0));//son
    }
    ///

    //Проверка наличия карточки, true - возвращает карточку, false - null
    public static card isCardExist(int number) {
        for (card crd : cards) {
            if (crd.getNumber() == number) {
                return crd;
            }
        }
        return null;
    }
    ///

    //Возврат списка карточек
    public static List<card> returnCardList() {
        return cards;
    }
    ///
}
