import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


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
    String currentAddress = "Moskovskaja 22";
    String month = "May";
    String year = "1978";
    String state = "Haryana";
    String city = "Karnal";


    open("/automation-practice-form");
    executeJavaScript("$('footer').remove()");
    executeJavaScript("$('#fixedban').remove()");

    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(userEmal);
    $(byText("Male")).click();
    $("#userNumber").setValue(userNumber);

    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(month);
    $(".react-datepicker__year-select").selectOption(year);
    $(byText("2")).click();


    $(byText("Sports")).click();
    $("#subjectsInput").sendKeys(subject1);
    $("#subjectsInput").pressEnter();
    $("#subjectsInput").sendKeys(subject2);
    $("#subjectsInput").pressEnter();

    $("#uploadPicture").uploadFromClasspath("avatar.png");
    $("#currentAddress").setValue(currentAddress);

    $("#react-select-3-input").setValue(state).pressEnter();
    $("#react-select-4-input").setValue(city).pressEnter();

    $("[id=submit]").click();

    $(".modal-body").shouldHave(
            text(firstName), text(lastName),
            text(userEmal),
            text("Male"),
            text(userNumber),
            text("02"), text(month), text(year),
            text(subject1), text(subject2),
            text("Sports"),
            text("avatar.png"),
            text(currentAddress),
            text(state), text(city)
    );
  }
}


