package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;
import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Lecturer extends AbstractEntity
{
    @NotNull
    @NotEmpty
    private String firstName = "";

    @NotNull
    @NotEmpty
    private String lastName = "";

    @Email
    @NotNull
    @NotEmpty
    private String email = "";

    //@OneToMany(mappedBy = "lecture", fetch = FetchType.EAGER)
    //private List<Lecture> lectures = new LinkedList<>();
    //private List<String> lectures = new LinkedList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public List<String> getLectures() {
        return lectures;
    }

    public void setLectures(List<String> lectures) {
        this.lectures = lectures;
    }*/
}
