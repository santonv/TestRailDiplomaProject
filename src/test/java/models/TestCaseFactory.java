package models;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.extern.log4j.Log4j2;

import java.util.Locale;

@Log4j2
public class TestCaseFactory {

    public static TestCase get(){
        log.info("Create new TestCase");
        Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        return TestCase.builder().title(faker.app().name()+fakeValuesService.regexify("[A-Z]{5}")).
                section("Test Cases").
                template("Test Case (Text)").
                type("Functional").
                priority("High").
                estimate("10").
                references("Some value").
                automationType("Ranorex").
                preconditions("Value").
                steps("Steps").
                expectedResult("Expected result").build();
    }
}
