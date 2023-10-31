package com.example.servletdemo.api;

import com.example.servletdemo.model.Student;
import com.example.servletdemo.service.StudentsService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "studentsApi", value = "/api/students")
public class StudentsApi extends HttpServlet {
    private static final Gson gson = new Gson();
    private final StudentsService studentsService = StudentsService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.getWriter().write(studentsService.findAll().toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentJson = request.getReader()
                .lines()
                .collect(Collectors.joining());
        Student student = gson.fromJson(studentJson, Student.class);
        studentsService.save(student);
    }
}