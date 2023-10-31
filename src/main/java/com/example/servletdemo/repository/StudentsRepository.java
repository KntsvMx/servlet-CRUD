package com.example.servletdemo.repository;

import com.example.servletdemo.model.Student;

import javax.swing.text.html.Option;
import java.util.*;

public class StudentsRepository {

    private static StudentsRepository studentsRepository = null;

    public static StudentsRepository getInstance() {
        if (studentsRepository == null) {
            studentsRepository = new StudentsRepository();
        }
        return studentsRepository;
    }

    private HashMap<Long, Student> studentMap = new HashMap<>() {{
        put(1L, Student.builder().id(1L).firstName("John").lastName("Smith").email("test1@gmail.com").build());
        put(2L, Student.builder().id(2L).firstName("Elias").lastName("Key").email("test2@gmail.com").build());
    }};

    public Optional<Student> getById(long id) {
        return Optional.ofNullable(studentMap.get(id));
    }

    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    public void save(Student student) {
        studentMap.put(student.getId(), student);
    }

    public void delete(long id) {
        studentMap.remove(id);
    }

    public boolean isPresent(long id) {
        return studentMap.containsKey(id);
    }

    public boolean isPresent(Student student) {
        return studentMap.containsKey(student.getId());
    }
}
