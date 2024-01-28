package ec.edu.espam.api.examen.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Entity(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Name is required")
    private String name;

    @Column(name = "description")
    @NotNull(message = "Description is required")
    private String description;

    @Column(name = "creationdate")
    private LocalDate creationdate;
}
