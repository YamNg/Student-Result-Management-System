package com.shyftlabsinterview.assessment.controller;

import com.shyftlabsinterview.assessment.constant.ResponseStatus;
import com.shyftlabsinterview.assessment.entity.CourseEntity;
import com.shyftlabsinterview.assessment.model.dto.CourseDto;
import com.shyftlabsinterview.assessment.model.request.AddCourseRequestModel;
import com.shyftlabsinterview.assessment.model.response.GenericResponseModel;
import com.shyftlabsinterview.assessment.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    // Create Course
    @PostMapping
    public GenericResponseModel<CourseDto> addCourse(@Valid @RequestBody AddCourseRequestModel model) throws Exception {
        CourseEntity newEntity = courseService.addCourse(model);
        return new GenericResponseModel<>(ResponseStatus.SUCCESS, new CourseDto(newEntity));
    }

    // Get list of Courses
    @GetMapping
    public GenericResponseModel<List<CourseDto>> getCourses() throws Exception {
        return new GenericResponseModel<>(ResponseStatus.SUCCESS, courseService.getAllCourse().stream().map(CourseDto::new).toList());
    }

    // Delete (Soft delete) for Course
    @DeleteMapping("/{id}")
    public GenericResponseModel<Void> deactivateCourse(@PathVariable("id") Long id) throws Exception {
        courseService.deactivateCourse(id);
        return new GenericResponseModel<>(ResponseStatus.SUCCESS);
    }
}
