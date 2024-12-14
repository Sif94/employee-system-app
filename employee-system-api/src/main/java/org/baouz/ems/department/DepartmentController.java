package org.baouz.ems.department;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("departments")
@Tag(name = "Department")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> saveDepartment(
            @RequestBody @Valid DepartmentRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> findDepartmentById(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(service.findById(id));
    }
}
