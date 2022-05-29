import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    Configuration.holdBrowserOpen = true;
  }

  @Test
  void practiceformTest() {
    String firstName = "Ivan";
    String lastName = "Ivanov";
    String userEmal = "IvanIvanov@gmail.com";
    String userNumber = "8954966770";
    String subject1 = "Economics";
    String subject2 = "Math";

    open("/automation-practice-form");
    executeJavaScript("$('footer').remove()");
    executeJavaScript("$('#fixedban').remove()");

    $("[id=firstName]").setValue(firstName);
    $("[id=lastName]").setValue(lastName);
    $("[id=userEmail]").setValue(userEmal);
    $(byText("Male")).click();
    $("[id=userNumber]").setValue(userNumber);

    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption("May");
    $(".react-datepicker__year-select").selectOption("1978");
    $(byText("2")).click();

    $(byText("Sports")).click();
    $("#subjectsInput").sendKeys(subject1);
    $("#subjectsInput").pressEnter();
    $("#subjectsInput").sendKeys(subject2);
    $("#subjectsInput").pressEnter();

    $("#uploadPicture").uploadFile(new File("src\\test\\resources\\avatar.png"));
    $("#currentAddress").setValue("Moskovskaja 22");

    $("#react-select-3-input").setValue("Haryana").pressEnter();
    $("#react-select-4-input").setValue("Karnal").pressEnter();

    $("[id=submit]").click();

    $(".modal-body").shouldHave(
            text("Ivan Ivanov"),
            text("IvanIvanov@gmail.com"),
            text("Male"),
            text("8954966770"),
            text("02 May,1978"),
            text("Economics, Maths"),
            text("Sports"),
            text("avatar.png"),
            text("Moskovskaja 22"),
            text("Haryana Karnal")
    );
  }
}


