package org.baouz.ems.department;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("departments")
@Tag(name = "Department")
public class DepartmentController {

    private final DepartmentService service;

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

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> findAllDepartments() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping
    public ResponseEntity<String> updateDepartment(
            @RequestBody @Valid DepartmentRequest request
    ){
        return ResponseEntity.ok(service.updateDepartment(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteDepartment(@PathVariable String id) {
        service.deleteDepartment(id);
    }
}
