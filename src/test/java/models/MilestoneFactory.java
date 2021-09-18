package models;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.extern.log4j.Log4j2;

import java.util.Locale;

@Log4j2
public class MilestoneFactory {
    public static Milestone get() {
        log.info("Create new Milestone");
        Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        return Milestone.builder()
                .name(faker.app().name() + fakeValuesService.regexify("[A-Z]{5}"))
                .references(fakeValuesService.regexify("[A-Z]{10}"))
                .parent("")
                .description(fakeValuesService.regexify("[A-Z]{10}"))
                .startDate("9/17/2021")
                .endDate("9/20/2021")
                .build();
    }
}
