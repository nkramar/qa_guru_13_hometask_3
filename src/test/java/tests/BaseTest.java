package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationFormPage;
import pages.components.ResultsTableComponent;


public class BaseTest {
  RegistrationFormPage registrationFormPage = new RegistrationFormPage();
  ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
  TestData testData = new TestData();

  @BeforeAll
  static void beforeAll() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", true);

    Configuration.browserCapabilities = capabilities;
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    Configuration.browserVersion="103";
    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
  }

  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
  }

}


