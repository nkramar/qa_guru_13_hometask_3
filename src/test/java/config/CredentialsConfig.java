package config;

import org.aeonbits.owner.Config;


@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {

  @Key("remote")
  Boolean remote();

  @Key("selenide.url")
  String selenideUrl();

  @Key("selenide.login")
  String selenideLogin();

  @Key("selenide.password")
  String selenidePassword();

}
