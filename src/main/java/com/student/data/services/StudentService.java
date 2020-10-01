package com.student.data.services;

import com.student.data.dao.Student;
import com.student.data.repo.StudentDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Amol Dhekane
 * @version 1.1
 * @since 01/10/20 10:29 AM
 */
@Service
public class StudentService {

    private final StudentDataRepo studentDataRepo;

    @Autowired
    public StudentService(StudentDataRepo studentDataRepo) {
        this.studentDataRepo = studentDataRepo;
    }

    public List<Student> getAllStudents(){
        return studentDataRepo.getAllStudents();
    }
}
