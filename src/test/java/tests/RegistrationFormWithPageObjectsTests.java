package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class RegistrationFormWithPageObjectsTests extends BaseTest {
  @Tag("demoqa_tests")
  @DisplayName("Заполнение формы регистрации студента")
  @Test
  void practiceFormTest() {

    registrationFormPage
            .openPage()
            .setFirstName(testData.firstName)
            .setLastName(testData.lastName)
            .setUserEmail(testData.email)
            .setGender(testData.gender)
            .setUserNumber(testData.phone)
            .setDateOfBirth(testData.month, testData.year, testData.day)
            .setSubject(testData.subject)
            .setHobby(testData.hobby)
            .uploadPicture(testData.picture)
            .setCurrentAddress(testData.address)
            .setState(testData.state)
            .setCity(testData.city)
            .clickSubmitButton()
            .checkTextInResultTable()
            .checkResult("Student Name", testData.firstName + " " + testData.lastName)
            .checkResult("Student Email", testData.email)
            .checkResult("Gender", testData.gender)
            .checkResult("Mobile", testData.phone)
            .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
            .checkResult("Subjects", testData.subject)
            .checkResult("Hobbies", testData.hobby)
            .checkResult("Picture", testData.picture)
            .checkResult("Address", testData.address)
            .checkResult("State and City", testData.state + " " + testData.city);
  }
}

