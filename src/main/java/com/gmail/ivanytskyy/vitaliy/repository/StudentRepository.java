package com.gmail.ivanytskyy.vitaliy.repository;
import java.util.List;
import com.gmail.ivanytskyy.vitaliy.model.Student;
/*
 * Task #4/2016/01/03 (web project #4)
 * StudentRepository interface
 * @version 1.01 2016.01.03
 * @author Vitaliy Ivanytskyy
 */
public interface StudentRepository {
	Student create(Student student);
	Student findById(long id);
	List<Student> findByGroupId(long id);
	List<Student> findByName(String name);
	List<Student> findAll();
	void deleteById(long id);
}