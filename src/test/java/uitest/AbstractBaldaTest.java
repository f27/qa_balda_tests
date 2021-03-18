package uitest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class AbstractBaldaTest {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://poncy.ru";
    }
}
