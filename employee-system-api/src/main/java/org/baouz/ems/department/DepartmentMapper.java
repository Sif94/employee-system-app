package org.baouz.ems.department;

import org.springframework.stereotype.Service;

@Service
public class DepartmentMapper {
    public Department toDepartment(DepartmentRequest request) {
        return Department.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .location(request.location())
                .build();
    }
}
