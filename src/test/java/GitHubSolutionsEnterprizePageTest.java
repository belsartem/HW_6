import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class GitHubSolutionsEnterprizePageTest {

    @BeforeEach
    void beforeEachSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    void TestSolutionEnterprizePage() {
        open(Configuration.baseUrl);
        $("Header").shouldHave(text("Solutions")).shouldBe(visible);
        $("Header").$(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered")).shouldBe(visible);
        webdriver().shouldHave(url("https://github.com/enterprise"));
    }
}