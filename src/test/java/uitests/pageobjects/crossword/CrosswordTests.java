package uitests.pageobjects.crossword;

import org.junit.jupiter.api.Test;
import uitests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class CrosswordTests extends TestBase {

    @Test
    void mainPageTest() {
        open("/crossword");

        $("#id_mask").shouldBe(visible);

        $("#letter-select").getSelectedOption().shouldBe(text("Буквы / Маска"));
    }

    @Test
    void maskTest() {
        open("/crossword");

        $("#id_mask").setValue("б-------");
        $("#id_desc").setValue("газированный напиток");
        $("button.btn-primary").click();

        $("#result-interp").shouldHave(text("буратино"));
    }

    @Test
    void byLetterTest() {
        open("/crossword");

        $("#letter-select").selectOption("6 букв");
        $("#l0").setValue("б");
        $("#l3").setValue("к");
        $("#l5").setValue("л");
        $("#id_desc").setValue("глубокое озеро");
        $("button.btn-primary").click();

        $("#result-interp").shouldHave(text("байкал"));
    }

    @Test
    void googleByWordTest() {
        open("/crossword");

        $("#letter-select").selectOption("6 букв");
        $("#l0").setValue("б");
        $("#l5").setValue("л");
        $("#google-search").click();

        switchTo().window(1);
        $(byName("q")).shouldHave(attribute("value", "б****л"));
        closeWindow();
    }

    @Test
    void yandexByWordTest() {
        open("/crossword");

        $("#letter-select").selectOption("6 букв");
        $("#l0").setValue("б");
        $("#l5").setValue("л");
        $("#yandex-search").click();

        switchTo().window(1);
        $(byName("text")).shouldHave(attribute("value", "б****л"));
        closeWindow();
    }

    @Test
    void googleByDecTest() {
        open("/crossword");

        $("#letter-select").selectOption("8 букв");
        $("#id_desc").setValue("глубокое озеро");
        $("#google-search").click();

        switchTo().window(1);
        $(byName("q")).shouldHave(attribute("value", "глубокое озеро 8 букв"));
        closeWindow();
    }

    @Test
    void yandexByDecTest() {
        open("/crossword");

        $("#letter-select").selectOption("8 букв");
        $("#id_desc").setValue("глубокое озеро");
        $("#yandex-search").click();

        switchTo().window(1);
        $(byName("text")).shouldHave(attribute("value", "глубокое озеро 8 букв"));
        closeWindow();
    }
}
