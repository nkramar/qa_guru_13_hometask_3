package tests;

import com.github.javafaker.Faker;
import utils.RandomDataGenerator;

import java.util.Locale;

public class TestData {
  Faker faker = new Faker(new Locale("en"));
  String firstName = faker.name().firstName(),
          lastName = faker.name().lastName(),
          email = faker.internet().emailAddress(),
          address = faker.address().fullAddress(),
          gender = RandomDataGenerator.randomGender(),
          subject = RandomDataGenerator.randomSubjects(),
          month = RandomDataGenerator.randomMonth(),
          hobby = RandomDataGenerator.randomHobbies(),
          phone = String.valueOf(faker.number().randomNumber(10, true)),
          day = String.valueOf(faker.number().numberBetween(1, 28)),
          year = String.valueOf(faker.number().numberBetween(1970, 2022)),
          picture = "avatar.png",
          state = "Haryana",
          city = "Karnal";

}
