package org.baouz.ems.department;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("departments")
@RequiredArgsConstructor
@Tag(name = "Department")
public class DepartmentController {

    private final DepartmentService service;

    @PostMapping
    public ResponseEntity<String> saveDepartment(
            @RequestBody @Valid DepartmentRequest request
    ){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(request));
    }
}
