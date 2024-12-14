package org.baouz.ems.department;


public record DepartmentRequest(
        String id,
        String name,
        String description,
        String location
) {
}
