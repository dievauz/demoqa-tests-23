package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }
    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Snow");
        $("#userEmail").setValue("john8snow@mail.ru");
        $("label[for=gender-radio-2]").click();
        $("#userNumber").setValue("9361475285");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day.react-datepicker__day--013").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#subjectsInput").setValue("Economics").pressEnter();
        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-2]").click();
        $("#uploadPicture").uploadFromClasspath("picture.png");
        $("#currentAddress").setValue("Winter fell");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("John Snow"));
        $(".table-responsive").shouldHave(text("john8snow@mail.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("9361475285"));
        $(".table-responsive").shouldHave(text("13 May,2024"));
        $(".table-responsive").shouldHave(text("History, Economics"));
        $(".table-responsive").shouldHave(text("Sports, Reading"));
        $(".table-responsive").shouldHave(text("picture.png"));
        $(".table-responsive").shouldHave(text("Winter fell"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

    }
}
