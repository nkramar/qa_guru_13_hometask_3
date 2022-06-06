package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationFormPage;
import pages.components.ResultsTableComponent;


public class BaseTest {
  RegistrationFormPage registrationFormPage = new RegistrationFormPage();
  ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
  TestData testData = new TestData();

  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    Configuration.holdBrowserOpen = true;
  }


}


