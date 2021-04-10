package com.example.application.data.service;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class LecturerService
{
    private static final Logger LOGGER = Logger.getLogger(LecturerService.class.getName());
    private LecturerRepository lecturerRepository;

    public LecturerService(/*@Autowired*/ LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }
}
