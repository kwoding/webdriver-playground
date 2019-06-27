package it.ding.webdriver.data;

import com.github.javafaker.Faker;
import it.ding.webdriver.model.User;

public class CommonData {

    private static Faker faker = Faker.instance();

    private CommonData() {
    }

    public static User validUser() {
        return User.builder()
            .username("tomsmith")
            .password("SuperSecretPassword!")
            .build();
    }

    public static User invalidUser() {
        return User.builder()
            .username(faker.name().username())
            .password(faker.lorem().characters(8))
            .build();
    }
}
