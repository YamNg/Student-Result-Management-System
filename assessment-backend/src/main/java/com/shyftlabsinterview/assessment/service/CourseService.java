package com.shyftlabsinterview.assessment.service;

import com.shyftlabsinterview.assessment.entity.CourseEntity;
import com.shyftlabsinterview.assessment.model.request.AddCourseRequestModel;
import com.shyftlabsinterview.assessment.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

// Service class for course
@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository){
        this.repository = repository;
    }

    @Transactional
    public CourseEntity addCourse(AddCourseRequestModel model) throws Exception{
        CourseEntity entity = new CourseEntity(model);
        return repository.save(entity);
    }

    public List<CourseEntity> getAllCourse() throws Exception{
        return repository.findByIsActiveTrue();
    }

    @Transactional
    public void deactivateCourse(Long id) throws Exception{
        // do soft delete instead of actual deleting the data
        CourseEntity entity = repository.findById(id).orElseThrow();
        entity.setActive(false);
        repository.save(entity);
    }

    public CourseEntity getReference(Long id) throws Exception{
        return repository.getReferenceById(id);
    }
}
