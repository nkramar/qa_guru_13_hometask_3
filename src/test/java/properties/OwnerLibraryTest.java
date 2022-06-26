package properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;


public class OwnerLibraryTest {
  CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

  @Test

  void ownerTest() {
    String login = config.login();
    String password = config.password();
    String remoteURL = format("I logged in as %s with password %s", login, password);
  }
}
