package guru.qa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#RightSide_Advertisement').remove()");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("alex@ivanov.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9219998877");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("1");
        $(".react-datepicker__year-select").selectOptionByValue("1987");
        $(".react-datepicker__day--025").click();
        $("#subjectsInput").setValue("mat");
        $("#subjectsWrapper").$(byText("Maths")).click();
        $("#subjectsInput").setValue("ph");
        $("#subjectsWrapper").$(byText("Physics")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test-image.png");
        $("#currentAddress").setValue("Россия, край Забайкальский, р-н Агинский, пгт Агинское, ул Олимпийская, индекс: 687000");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Ivanov"));
        $(".table-responsive").shouldHave(text("alex@ivanov.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("9219998877"));
        $(".table-responsive").shouldHave(text("25 February,1987"));
        $(".table-responsive").shouldHave(text("Maths, Physics"));
        $(".table-responsive").shouldHave(text("Reading, Music"));
        $(".table-responsive").shouldHave(text("test-image.png"));
        $(".table-responsive").shouldHave(text("Россия, край Забайкальский, р-н Агинский, пгт Агинское, ул Олимпийская, индекс: 687000"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));
    }
}
