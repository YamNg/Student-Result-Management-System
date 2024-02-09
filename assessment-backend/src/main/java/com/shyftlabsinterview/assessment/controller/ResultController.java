package com.shyftlabsinterview.assessment.controller;

import com.shyftlabsinterview.assessment.constant.ErrorCode;
import com.shyftlabsinterview.assessment.constant.ResponseStatus;
import com.shyftlabsinterview.assessment.entity.ResultEntity;
import com.shyftlabsinterview.assessment.model.dto.ResultDto;
import com.shyftlabsinterview.assessment.model.exception.AppException;
import com.shyftlabsinterview.assessment.model.request.AddResultRequestModel;
import com.shyftlabsinterview.assessment.model.response.GenericResponseModel;
import com.shyftlabsinterview.assessment.service.CourseService;
import com.shyftlabsinterview.assessment.service.ResultService;
import com.shyftlabsinterview.assessment.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {

    private final StudentService studentService;
    private final CourseService courseService;
    private final ResultService resultService;

    public ResultController(StudentService studentService, CourseService courseService, ResultService resultService){
        this.studentService = studentService;
        this.courseService = courseService;
        this.resultService = resultService;
    }

    // Create Result
    @PostMapping
    public GenericResponseModel<ResultDto> addResult(@Valid @RequestBody AddResultRequestModel model) throws Exception {
        // get reference instead of findById to retrieve related object, which will not execute select statement under the hood
        model.setStudent(studentService.getReference(model.getStudentId()));
        model.setCourse(courseService.getReference(model.getCourseId()));

        // handle the case which 1 student should only have 1 result for 1 course
        try{
            ResultEntity newEntity = resultService.addResult(model);
            return new GenericResponseModel<>(ResponseStatus.SUCCESS, new ResultDto(newEntity));
        } catch (DataIntegrityViolationException dataIntegrityViolationException){
            throw new AppException(ErrorCode.DATA_RESULT_EXISTS);
        }
    }

    // Get list of Results
    @GetMapping
    public GenericResponseModel<List<ResultDto>> getResults() throws Exception {
        return new GenericResponseModel<>(ResponseStatus.SUCCESS, resultService.getAllResult().stream().map(ResultDto::new).toList());
    }
}
