import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeEach
    void beforeEachSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void TestDragAndDropSelenideActions() {
        open("/drag_and_drop");

        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");

        Selenide.actions().dragAndDrop(elementA, elementB).perform();
        elementA.$("header").shouldHave(text("B"));
    }

    @Test
    void TestSelenideDragAndDrop() {
        open("/drag_and_drop");

        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
    }
}