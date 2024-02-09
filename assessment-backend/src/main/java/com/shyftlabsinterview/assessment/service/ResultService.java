package com.shyftlabsinterview.assessment.service;

import com.shyftlabsinterview.assessment.constant.ErrorCode;
import com.shyftlabsinterview.assessment.entity.ResultEntity;
import com.shyftlabsinterview.assessment.model.exception.AppException;
import com.shyftlabsinterview.assessment.model.request.AddResultRequestModel;
import com.shyftlabsinterview.assessment.repository.ResultRepository;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

// Service class for result
@Service
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService(ResultRepository repository){
        this.resultRepository = repository;
    }

    @Transactional
    public ResultEntity addResult(AddResultRequestModel model) throws Exception {
        ResultEntity entity = new ResultEntity(model);
        return resultRepository.save(entity);
    }

    public List<ResultEntity> getAllResult() throws Exception{
        return resultRepository.findByStudentIsActiveTrueAndCourseIsActiveTrue();
    }
}
