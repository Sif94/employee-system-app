package org.baouz.ems.department;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record DepartmentResponse(
        String id,
        String name,
        String description,
        String location,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate
) {}
