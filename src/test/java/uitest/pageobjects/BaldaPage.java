package uitest.pageobjects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BaldaPage {

    public void openPage() {
        open("/balda");
        $("#cell55").shouldBe(visible);
        $("#cell66").shouldNotBe(visible);
    }

    public void clearField() {
        $("#clearall").click();
        $("#used_words").shouldBe(empty);
        $("#result_words").shouldBe(empty);
    }

    private void findHints() {
        $("#search-button").click();
    }

    public void unDo(String word) {
        $("#undo-button").click();
        $("#used_words").shouldNotHave(value(word));
    }

    public void changeSize(int size) {
        $("#boardsize").selectOptionByValue(String.valueOf(size));
        $("#cell" + size + size).shouldBe(visible);
        $("#cell" + (size+1) + (size+1)).shouldNotBe(visible);
    }

    public void firstWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            enterLetter(word.substring(i, i+1), "3" + (i + 1));
        }
        findHints();
        $("#used_words").shouldHave(value(word));
    }

    public void chooseFirstHint(String word){
        $$("#result_words a").findBy(text(word)).click();
        $("#used_words").shouldHave(value(word));
    }

    public void chooseHint(String word, String startcell){
        $$("[onmouseout *= \"'cell" + startcell + "'\"]").findBy(text(word)).click();
        $("#used_words").shouldHave(value(word));
    }

    private void enterLetter(String letter, String coords) {
        $("#cell" + coords).setValue(letter);
    }
}
