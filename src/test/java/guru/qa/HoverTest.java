package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.pageLoadStrategy;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HoverTest {
    @BeforeAll
    static void configuration(){
        pageLoadStrategy = "eager";
    }

    @Test
    void enterprizePageShouldHaveHeader(){
        open("https://github.com");
        $$(".HeaderMenu-item").get(1).shouldHave(text("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").filterBy(text("Enterprise")).first().click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" + "developer platform."));
    }
}
