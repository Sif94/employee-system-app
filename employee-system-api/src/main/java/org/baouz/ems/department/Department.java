package org.baouz.ems.department;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static jakarta.persistence.GenerationType.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(
        name = "departments",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "departments_unique_constraints_name",
                        columnNames = {"name"}
                )
        }
)
public class Department {
    @Id @GeneratedValue(strategy = UUID)
    private String id;
    private String name;
    private String description;
    private String location;
}
