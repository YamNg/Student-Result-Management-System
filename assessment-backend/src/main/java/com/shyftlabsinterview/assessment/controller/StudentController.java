package com.shyftlabsinterview.assessment.controller;

import com.shyftlabsinterview.assessment.constant.ResponseStatus;
import com.shyftlabsinterview.assessment.entity.StudentEntity;
import com.shyftlabsinterview.assessment.model.dto.StudentDto;
import com.shyftlabsinterview.assessment.model.request.AddStudentRequestModel;
import com.shyftlabsinterview.assessment.model.response.GenericResponseModel;
import com.shyftlabsinterview.assessment.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // Create Student
    @PostMapping
    public GenericResponseModel<StudentDto> addStudent(@Valid @RequestBody AddStudentRequestModel model) throws Exception {
        StudentEntity newEntity = studentService.addStudent(model);
        return new GenericResponseModel<>(ResponseStatus.SUCCESS, new StudentDto(newEntity));
    }

    // Get list of Students
    @GetMapping
    public GenericResponseModel<List<StudentDto>> getStudents() throws Exception {
        return new GenericResponseModel<>(ResponseStatus.SUCCESS, studentService.getAllStudent().stream().map(StudentDto::new).toList());
    }

    // Delete (Soft delete) for Student
    @DeleteMapping("/{id}")
    public GenericResponseModel<Void> deactivateStudent(@PathVariable("id") Long id) throws Exception {
        studentService.deactivateStudent(id);
        return new GenericResponseModel<>(ResponseStatus.SUCCESS);
    }

}
