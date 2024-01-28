package ec.edu.espam.api.examen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.espam.api.examen.Application;
import ec.edu.espam.api.examen.domain.Course;
import ec.edu.espam.api.examen.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

@AutoConfigureMockMvc
 public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CourseService courseService;

    @Test
    void testCreateCourse() throws Exception {
        Course course = new Course();
        course.setName("Curso de Prueba");
        course.setDescription("Descripción del curso de prueba");
        course.setCreationdate(LocalDate.now());

        String courseJson = objectMapper.writeValueAsString(course);

        ResultActions result = mockMvc.perform(post("/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(courseJson))
                .andExpect(status().isCreated());

    }
}

