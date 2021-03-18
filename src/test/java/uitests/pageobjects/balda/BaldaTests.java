package uitests.pageobjects.balda;

import org.junit.jupiter.api.Test;
import uitests.TestBase;

public class BaldaTests extends TestBase {
    BaldaPage baldaPage;

    @Test
    void baldaTest() {
        /*
1)Зайти в балду
должна быть 5 на 5 (нет ячейки 66)

2)Вписать бонус и нажать найти
В использованных словах должно быть бонус

3)Нажать на первую подсказку тонус
В использованных словах тонус

4)Отменить ввод тонус
В использованных словах бонус , но нет тонус

5)Нажать конус начинающийся с ячейки 42
В использованных словах конус

6)Очистить
Подсказки и использованные слова должны быть пустыми

7)Сменить размер на 6 на 6
Должна появится ячейка 66
 */
        baldaPage = new BaldaPage();

        baldaPage.openPage();
        baldaPage.firstWord("БОНУС");
        baldaPage.chooseFirstHint("ТОНУС");
        baldaPage.unDo("ТОНУС");
        baldaPage.chooseHint("КОНУС", "42");
        baldaPage.clearField();
        baldaPage.changeSize(6);

    }

}
