package org.baouz.ems.department;

import lombok.Builder;

@Builder
public record DepartmentResponse(
        String id,
        String name,
        String description,
        String location
) {
}
