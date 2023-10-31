package com.example.servletdemo.controller;

import com.example.servletdemo.model.Student;
import com.example.servletdemo.service.StudentsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "studentsServlet", value = "/students/*")
public class StudentsServlet extends HttpServlet {
    private final StudentsService studentsService = StudentsService.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pathInfo = request.getPathInfo();

        if (pathInfo != null) {
            if (pathInfo.equalsIgnoreCase("/new")) {
                request.getRequestDispatcher("/new-student.jsp").forward(request, response);
                return;
            } else if (pathInfo.equalsIgnoreCase("/edit")) {
                request.setAttribute("student", studentsService.finById(Long.parseLong(request.getParameter("id"))));
                request.getRequestDispatcher("/new-student.jsp").forward(request,response);
                return;
            }
        }

        request.setAttribute("studentsList", studentsService.findAll());
        request.getRequestDispatcher("/students.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String firstName = req.getParameter("FirstName");
        String lastName = req.getParameter("LastName");
        String email = req.getParameter("email");

        Student student = Student.builder()
                .id(Long.parseLong(id))
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build();
        System.out.println(student);

        studentsService.save(student);
    }

    public void destroy() {
    }
}