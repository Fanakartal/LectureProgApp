package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;

@Entity
public class Lecture extends AbstractEntity
{
    public enum Semester
    {
        FALL,
        SPRING;
    }

    @NotNull
    @NotEmpty
    private String code = "CE100";

    //@NotNull
    //@NotEmpty
    //private String sectionNum = "";

    @NotNull
    @NotEmpty
    private String name = "";

    //private String lecturer;

    //@ManyToOne
    //@JoinColumn(name = "lecturer_id")
    //private Lecturer lecturer;

    //@ManyToOne(optional = false)
    //private Lecturer lecturer;

    @NotNull
    private DayOfWeek dayOfWeek;
    @NotNull
    private LocalTime beginTime;
    @NotNull
    private LocalTime endTime;

    @Enumerated(EnumType.STRING)
    private Semester givenSemester;

    private int lectureYear;
    private Year givenYear;

    @OneToOne(optional = true)
    private Lecture prerequisite;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Semester getGivenSemester() {
        return givenSemester;
    }

    public void setGivenSemester(Semester givenSemester) {
        this.givenSemester = givenSemester;
    }

    public int getLectureYear() {
        return lectureYear;
    }

    public void setLectureYear(int lectureYear) {
        this.lectureYear = lectureYear;
    }

    public Year getGivenYear() {
        return givenYear;
    }

    public void setGivenYear(Year givenYear) {
        this.givenYear = givenYear;
    }

    /*public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }*/

    public Lecture getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Lecture prerequisite) {
        this.prerequisite = prerequisite;
    }
}
