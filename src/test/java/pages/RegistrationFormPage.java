package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalenderComponent;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

  public CalenderComponent calenderComponent = new CalenderComponent();
  public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

  SelenideElement
          firstNameInput = $("#firstName"),
          lastNameInput = $("#lastName"),
          userEmailInput = $("#userEmail"),
          userNumberInput = $("#userNumber"),
          genderInput = $("#genterWrapper"),
          hobbiesInput = $("#hobbiesWrapper"),
          dateOfBirthInput = $("#dateOfBirthInput"),
          subjectsInput = $("#subjectsInput"),
          uploadPictureInput = $("#uploadPicture"),
          currentAddressInput = $("#currentAddress"),
          stateInput = $("#state"),
          stateMenuInput = $("#stateCity-wrapper"),
          cityInput = $("#city"),
          cityMenuInput = $("#stateCity-wrapper"),
          submitButton = $("#submit"),
          resultTableText = $("#example-modal-sizes-title-lg");

  public RegistrationFormPage openPage() {
    open("/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    executeJavaScript("$('footer').remove()");
    executeJavaScript("$('#fixedban').remove()");

    return this;
  }

  public RegistrationFormPage setFirstName(String value) {
    firstNameInput.setValue(value);

    return this;
  }

  public RegistrationFormPage setLastName(String value) {
    lastNameInput.setValue(value);

    return this;
  }

  public RegistrationFormPage setUserEmail(String value) {
    userEmailInput.setValue(value);

    return this;
  }

  public RegistrationFormPage setGender(String value) {
    genderInput.$(byText(value)).click();

    return this;
  }

  public RegistrationFormPage setUserNumber(String value) {
    userNumberInput.setValue(value);

    return this;
  }

  public RegistrationFormPage setDateOfBirth(String month, String year, String day) {
    dateOfBirthInput.click();
    calenderComponent.setDate(month, year, day);

    return this;
  }

  public RegistrationFormPage setSubject(String value) {
    subjectsInput.sendKeys(value);
    subjectsInput.pressEnter();
    return this;
  }


  public RegistrationFormPage setHobby(String value) {
    hobbiesInput.$(byText(value)).click();

    return this;
  }

  public RegistrationFormPage uploadPicture(String value) {
    uploadPictureInput.uploadFromClasspath(value);

    return this;
  }

  public RegistrationFormPage setCurrentAddress(String value) {
    currentAddressInput.setValue(value);

    return this;
  }

  public RegistrationFormPage setState(String value) {
    stateInput.click();
    stateMenuInput.$(byText(value)).click();

    return this;
  }

  public RegistrationFormPage setCity(String value) {
    cityInput.click();
    cityMenuInput.$(byText(value)).click();

    return this;
  }

  public RegistrationFormPage clickSubmitButton() {
    submitButton.click();
    return this;
  }

  public RegistrationFormPage checkTextInResultTable() {
   resultTableText.shouldHave(text("Thanks for submitting the form"));
    return this;
  }

  public RegistrationFormPage checkResult(String key, String value) {
    resultsTableComponent.checkResult(key, value);

    return this;
  }
}
