package guru.qa;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.pageLoadStrategy;
import static com.codeborne.selenide.DragAndDropOptions.*;
import static com.codeborne.selenide.Selenide.*;

public class DragNDropTest {
    @BeforeAll
    static void configuration(){
        pageLoadStrategy = "eager";
    }

    @Test
    void enterprizePageShouldHaveHeader(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
