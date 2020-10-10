package com.student.data.repo;

import com.student.data.dao.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Amol Dhekane
 * @version 1.1
 * @since 01/10/20 10:25 AM
 */
public interface StudentDataRepo extends Repository<Student, Long> {

    @Query("select data from Student data")
    List<Student> getAllStudents();

    @Query("select data from Student data where id=:studentId")
    List<Student> getIdStudent(@Param("studentId") Long studentId );

    Student save(Student student);

    @Query("delete from Student data where id=:studentId")
    void deleteStudent(@Param("studentId") Long studentId );
}
