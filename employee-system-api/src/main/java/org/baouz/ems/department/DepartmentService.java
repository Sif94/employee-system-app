package org.baouz.ems.department;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    public DepartmentService(DepartmentRepository repository, DepartmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public String save(DepartmentRequest request) {
        var department = mapper.toDepartment(request);
        return repository.save(department).getId();
    }

    public DepartmentResponse findById(String id) {
        return repository.findById(id)
                .map(mapper::toDepartmentResponse)
                .orElseThrow(
                        () -> new EntityNotFoundException(format("Department with ID:: %s was not found", id))
                );
    }
}
