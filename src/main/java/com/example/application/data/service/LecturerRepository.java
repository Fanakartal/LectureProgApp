package com.example.application.data.service;

import com.example.application.data.entity.Lecture;
import com.example.application.data.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
}
