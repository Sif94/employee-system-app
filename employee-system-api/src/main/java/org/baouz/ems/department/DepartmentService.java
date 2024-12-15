package org.baouz.ems.department;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;



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

    public List<DepartmentResponse> findAll() {
        return repository.findAll().stream().map(mapper::toDepartmentResponse).collect(Collectors.toList());
    }

    public String updateDepartment(DepartmentRequest request) {
        repository.findById(request.id())
                .orElseThrow(
                        () -> new EntityNotFoundException(format("Department with ID:: %s was not found", request.id()))
                );
        var updatedDepartment = mapper.toDepartment(request);
        return repository.save(updatedDepartment).getId();
    }

    public void deleteDepartment(String id) {
        repository.deleteById(id);
    }
}
