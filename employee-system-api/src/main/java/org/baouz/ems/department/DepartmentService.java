package org.baouz.ems.department;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper mapper;
    public String save(DepartmentRequest request) {
        var department = mapper.toDepartment(request);
        return departmentRepository.save(department).getId();
    }
}
