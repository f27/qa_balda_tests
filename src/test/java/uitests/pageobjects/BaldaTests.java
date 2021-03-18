package uitests.pageobjects;

import org.junit.jupiter.api.Test;
import uitests.AbstractBaldaTest;

public class BaldaTests extends AbstractBaldaTest {
    BaldaPage baldaPage;

    @Test
    void baldaTest(){
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
