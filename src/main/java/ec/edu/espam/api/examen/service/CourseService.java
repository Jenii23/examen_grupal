package ec.edu.espam.api.examen.service;

import ec.edu.espam.api.examen.domain.Course;

import java.util.List;

public interface CourseService {


    Course create(Course course);
    Course getById(Long id);
    void deleteById(Long id);
}
