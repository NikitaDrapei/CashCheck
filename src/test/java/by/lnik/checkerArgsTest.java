package by.lnik;

import by.lnik.memory.cardsStorage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class checkerArgsTest {

    //Тест карточек
    @Test
    void realNumberCard() {
        String[] partOfcard = {"card", "1234"};
        checkerArgs checker = new checkerArgs();
        assertEquals(cardsStorage.isCardExist(1234), checker.checkCard(partOfcard));
    }

    @Test
    void fakeNumberCard() {
        String[] partOfcard = {"card", "3214"};
        checkerArgs checker = new checkerArgs();
        assertEquals(null, checker.checkCard(partOfcard));
    }

    ///
    // Добавить продукт
    @Test
    void realProductAdd() {
        String[] partOfproduct = {"1", "972"};
        checkerArgs checker = new checkerArgs();
        boolean isTrue = checker.checkProduct(partOfproduct);
        assertEquals(isExist(partOfproduct), isTrue);

    }

    @Test
    void fakeProductAdd() {
        String[] partOfproduct = {"7", "12"};
        checkerArgs checker = new checkerArgs();
        boolean isFalse = checker.checkProduct(partOfproduct);
        assertEquals(isExist(partOfproduct), isFalse);
    }

    //Собственная проверка есть ли продукт в базе
    private boolean isExist(String[] pop) {
        int id = Integer.parseInt(pop[0]);
        int quantity = Integer.parseInt(pop[1]);
        for (shopList sl : shopList.returnShopL()) {
            if (sl.getId() == id && sl.getQuantity() == quantity) {
                return true;
            }
        }
        return false;
    }
    ///

}