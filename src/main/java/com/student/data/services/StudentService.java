package com.student.data.services;

import com.student.data.dao.Student;
import com.student.data.repo.StudentDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Student> getIdStudent(Long studentId) {
        return studentDataRepo.getIdStudent(studentId);
    }

    public Student save(Student student){
        return studentDataRepo.save(student);
    }

    public void deleteStudent(Long studentId) {
        studentDataRepo.deleteStudent(studentId);
    }
}
