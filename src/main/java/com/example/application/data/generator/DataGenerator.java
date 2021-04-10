package com.example.application.data.generator;

import com.example.application.data.entity.Lecture;
import com.example.application.data.entity.Person;
import com.example.application.data.service.LectureRepository;
import com.example.application.data.service.PersonRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.vaadin.artur.exampledata.DataType;
import org.vaadin.artur.exampledata.ExampleDataGenerator;

import java.util.logging.Logger;

//@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(PersonRepository personRepository, LectureRepository lectureRepository) {
        return args -> {
            Logger logger = (Logger) LoggerFactory.getLogger(getClass());
            if (personRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 100 Person entities...");
            ExampleDataGenerator<Person> personRepositoryGenerator = new ExampleDataGenerator<>(Person.class);
            personRepositoryGenerator.setData(Person::setId, DataType.ID);
            personRepositoryGenerator.setData(Person::setFirstName, DataType.FIRST_NAME);
            personRepositoryGenerator.setData(Person::setLastName, DataType.LAST_NAME);
            personRepositoryGenerator.setData(Person::setEmail, DataType.EMAIL);
            personRepositoryGenerator.setData(Person::setPhone, DataType.PHONE_NUMBER);
            personRepositoryGenerator.setData(Person::setDateOfBirth, DataType.DATE_OF_BIRTH);
            personRepositoryGenerator.setData(Person::setOccupation, DataType.OCCUPATION);
            personRepositoryGenerator.setData(Person::setImportant, DataType.BOOLEAN_10_90);
            personRepository.saveAll(personRepositoryGenerator.create(100, seed));

            /*logger.info("... generating 100 Lecture entities...");
            ExampleDataGenerator<Lecture> lectureRepositoryGenerator = new ExampleDataGenerator<>(Lecture.class);
            lectureRepositoryGenerator.setData(Lecture::setCode, DataType.ZIP_CODE);
            lectureRepositoryGenerator.setData(Lecture::setName, DataType.COMPANY_NAME);
            //lectureRepositoryGenerator.setData(Lecture::setLecturer, DataType.FULL_NAME);
            //lectureRepositoryGenerator.setData(Lecture::setDayOfWeek, DataType.DATE_LAST_1_YEAR.getValue(new Random(), seed).getDayOfWeek());
            //lectureRepositoryGenerator.setData(Lecture::setBeginTime, DataType.DATE_LAST_1_YEAR.getValue(new Random(), seed).);
            lectureRepository.saveAll(lectureRepositoryGenerator.create(10, seed)); */

            logger.info("Generated demo data");
        };
    }

}