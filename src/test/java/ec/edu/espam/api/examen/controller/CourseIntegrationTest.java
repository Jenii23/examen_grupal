package ec.edu.espam.api.examen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.edu.espam.api.examen.domain.Course;
import ec.edu.espam.api.examen.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CourseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CourseService courseService;

    @Test
    void testCreateCourse() throws Exception {
        // Crear un objeto Course para enviar en la solicitud POST
        Course course = new Course();
        course.setName("Curso de Prueba");
        course.setDescription("Descripción del curso de prueba");
        course.setCreationdate(LocalDate.now());

        // Convertir el objeto Course a JSON
        String courseJson = objectMapper.writeValueAsString(course);

        // Enviar la solicitud POST al Endpoint y esperar un código de respuesta 201 (CREATED)
        ResultActions result = mockMvc.perform(post("/course")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(courseJson))
                .andExpect(status().isCreated());

        // Puedes agregar más aserciones según tus necesidades, por ejemplo, verificar la respuesta JSON devuelta.
    }
}
