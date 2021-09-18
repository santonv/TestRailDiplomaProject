package models;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.extern.log4j.Log4j2;

import java.util.Locale;

@Log4j2
public class TestRunFactory {

    public static TestRun get(){
       log.info("Create new test run");
       Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        return TestRun.builder()
                .name(faker.app().name() + fakeValuesService.regexify("[A-Z]{5}") + "9/20/2021")
                .references("")
                .milestone("")
                .assignedTo("Me")
                .description("Description")
                .build();
    }
}
