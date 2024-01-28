package ec.edu.espam.api.examen.controller;

import ec.edu.espam.api.examen.domain.Course;
import ec.edu.espam.api.examen.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/course")
public class CourseController {
    private final CourseService service;

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody @Valid Course course) {
        return new ResponseEntity<>(service.create(course), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
