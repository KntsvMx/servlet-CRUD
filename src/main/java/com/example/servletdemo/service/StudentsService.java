package com.example.servletdemo.service;

import com.example.servletdemo.model.Student;
import com.example.servletdemo.repository.StudentsRepository;

import java.util.Collection;
import java.util.Optional;

public class StudentsService {
    private static StudentsService instance;
    private final StudentsRepository studentsRepository = StudentsRepository.getInstance();

    public static StudentsService getInstance() {
        if (instance == null) {
            instance = new StudentsService();
        }
        return instance;
    }

    public Collection<Student> findAll() {
        return  studentsRepository.findAll();
    }

    public Student finById(long id) {
        return studentsRepository.getById(id).orElse(new Student());
    }

    public void save(Student student) {
        studentsRepository.save(student);
    }
}
