package com.example.application.data.service;

import com.example.application.data.entity.Lecture;

import com.example.application.data.entity.Lecturer;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

import javax.annotation.PostConstruct;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LectureService /*extends CrudService<Lecture, Integer>*/ {

    private static final Logger LOGGER = Logger.getLogger(LectureService.class.getName());
    private LectureRepository lectureRepository;

    public LectureService(/*@Autowired*/ LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    /*@Override
    protected LectureRepository getRepository()
    {
        return lectureRepository;
    }*/

    public List<Lecture> findAll() {
        return lectureRepository.findAll();
    }

    public long count() {
        return lectureRepository.count();
    }

    public void delete(Lecture lecture) {
        lectureRepository.delete(lecture);
    }

    public void save(Lecture lecture) {
        if (lecture == null) {
            LOGGER.log(Level.SEVERE,
                    "Lecture is null. Are you sure you have connected your form to the application?");
            return;
        }
        lectureRepository.save(lecture);
    }

    @PostConstruct
    public void populateTestData() {
        if (lectureRepository.count() == 0) {
            Random r = new Random(0);
            List<Lecture> lectures = new ArrayList<>();

            for (int i = 0; i < 10; i++) { // TODO: Change this
                Lecture temp = new Lecture();
                //Lecturer tempLecturer = new Lecturer();
                temp.setCode("CE22" + i);
                temp.setName("Intro to Computer " + i);
                //tempLecturer.setFirstName("FirstName"+i);
                //tempLecturer.setLastName("LastName"+i);
                //tempLecturer.setEmail(tempLecturer.getFirstName() + "." + tempLecturer.getLastName() + "@ieu.edu.tr");
                //temp.setLecturer(tempLecturer);
                temp.setDayOfWeek(DayOfWeek.of((i % 7) + 1));
                temp.setBeginTime(LocalTime.now());
                temp.setEndTime(LocalTime.of(8, i));
                temp.setGivenSemester(Lecture.Semester.FALL);
                temp.setGivenYear(Year.of(2020));
                temp.setLectureYear((i % 4) + 1);
                lectures.add(temp);
            }

            lectureRepository.saveAll(lectures);

            /*lectureRepository.saveAll(
                    Stream.of("CE221", "CE223", "CE303", "CE306")
                            .map(code ->
                            {
                                //Lecture lecture = new Lecture();
                                lecture.setCode(code);
                                return lecture;
                            }).collect(Collectors.toList())*/
            /*, Stream.of("Algorithm", "Database", "Network", "OS").
                            map(name ->
                            {
                                lecture.setName(name);
                                return lecture;
                            }).collect(Collectors.toList()));*/
        }

    /*
    @PostConstruct
    public void populateTestData() {
	if (companyRepository.count() == 0) {
		companyRepository.saveAll(
			Stream.of("Path-Way Electronics", "E-Tech Management", "Path-E-Tech Management")
				.map(Company::new)
				.collect(Collectors.toList()));
	}

	if (contactRepository.count() == 0) {
		Random r = new Random(0);
		List<Company> companies = companyRepository.findAll();
		contactRepository.saveAll(
			Stream.of("Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
				"Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
				"Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
				"Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
				"Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
				"Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
				"Jaydan Jackson", "Bernard Nilsen")
				.map(name -> {
					String[] split = name.split(" ");
					Contact contact = new Contact();
					contact.setFirstName(split[0]);
					contact.setLastName(split[1]);
					contact.setCompany(companies.get(r.nextInt(companies.size())));
					contact.setStatus(Contact.Status.values()[r.nextInt(Contact.Status.values().length)]);
					String email = (contact.getFirstName() + "." + contact.getLastName() + "@" + contact.getCompany().getName().replaceAll("[\\s-]", "") + ".com").toLowerCase();
					contact.setEmail(email);
					return contact;
				}).collect(Collectors.toList()));
	}
}*/

    }

}
