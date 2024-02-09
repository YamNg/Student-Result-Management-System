package com.shyftlabsinterview.assessment.service;

import com.shyftlabsinterview.assessment.entity.StudentEntity;
import com.shyftlabsinterview.assessment.model.request.AddStudentRequestModel;
import com.shyftlabsinterview.assessment.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

// Service class for student
@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    @Transactional
    public StudentEntity addStudent(AddStudentRequestModel model) throws Exception{
        StudentEntity entity = new StudentEntity(model);
        System.out.println("testing");
        System.out.println(entity);
        return repository.save(entity);
    }

    public List<StudentEntity> getAllStudent() throws Exception{
        return repository.findByIsActiveTrue();
    }

    @Transactional
    public void deactivateStudent(Long id) throws Exception{
        // do soft delete instead of actual deleting the data
        StudentEntity entity = repository.findById(id).orElseThrow();
        entity.setActive(false);
        repository.save(entity);
    }

    public StudentEntity getReference(Long id) throws Exception{
        return repository.getReferenceById(id);
    }
}
