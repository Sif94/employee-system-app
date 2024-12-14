package org.baouz.ems.department;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface DepartmentRepository extends JpaRepository<Department,String> {
    Optional<Department> findByName(String name);
    Set<Department> findByNameContainingIgnoreCase(String name);
}
