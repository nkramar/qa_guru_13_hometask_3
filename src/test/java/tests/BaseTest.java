package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;

import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationFormPage;
import config.CredentialsConfig;

public class BaseTest {
  RegistrationFormPage registrationFormPage = new RegistrationFormPage();

  TestData testData = new TestData();

  @BeforeAll
  static void beforeAll() {
    final CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", true);

    Configuration.browserCapabilities = capabilities;
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    if(config.remote()) {
      String login = config.selenideLogin();
      String password = config.selenidePassword();
      String url = config.selenideUrl();
      Configuration.remote = String.format("https://%s:%s@%s/wd/hub/", login, password, url);
    }

  }


  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
  }

}


