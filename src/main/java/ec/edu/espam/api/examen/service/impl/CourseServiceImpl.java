package ec.edu.espam.api.examen.service.impl;

import ec.edu.espam.api.examen.domain.Course;
import ec.edu.espam.api.examen.repository.CourseRepository;
import ec.edu.espam.api.examen.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course create(Course course) {
        course.setCreationdate(LocalDate.now());
        return courseRepository.save(course);
    }
    @Override
    public Course getById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteById(Long id) {
         courseRepository.deleteById(id);
    }
}
